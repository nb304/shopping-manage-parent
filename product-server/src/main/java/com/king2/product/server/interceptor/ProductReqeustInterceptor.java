package com.king2.product.server.interceptor;


import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.pojo.K2Role;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.CookieUtils;
import com.king2.commons.utils.JsonUtils;
import com.king2.commons.utils.NetworkUtil;
import com.king2.commons.utils.UserManageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/*=======================================================
	˵��:   �̳�ģ���̨������

	����		ʱ��					ע��
  	����		2019.8.9   			����

=======================================================*/
public class ProductReqeustInterceptor implements HandlerInterceptor {

    // ע��RedisPool���ӳ�
    @Autowired
    private JedisPool jedisPool;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String origin = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "Origin,Content-Type,Accept,token,X-Requested-With");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("P3P", "CP=\"CAO PSA OUR\"");

        // *************************************** ���Բ���
        String user = CookieUtils.getCookieValue(request, "userKey");
        K2MemberAndElseInfo info = new K2MemberAndElseInfo();
        K2Member k2Member2 = new K2Member();

        if(!StringUtils.isEmpty(user)) {
            k2Member2.setMemberAccount("luqiqi");
            k2Member2.setRetain1("1");
            k2Member2.setMemberId(1);
            k2Member2.setMemberName("¹����");
            k2Member2.setMemberPortrait("http://39.105.41.2:9000/king2-product-image/king2-BRAND-LOGO-SP7FD5F6064FF9907DD1A16D0FE8EB593295.jpg");
        } else {
            k2Member2.setMemberAccount("ziqing");
            k2Member2.setRetain1("1");
            k2Member2.setMemberId(2);
            k2Member2.setMemberName("����");
            k2Member2.setMemberPortrait("http://39.105.41.2:9000/king2-product-image/king2-BRAND-LOGO-SP6FB4BB1542D59224599FB3313E80254051.png");
        }

        info.setK2Member(k2Member2);

        // ������ɫ
        List<K2Role> roles = new ArrayList<>();
        K2Role role = new K2Role();
        role.setCreateUserName("��������Ա");
        role.setRetain1("KING2_SYSTEM_ADMIN");
        roles.add(role);
        info.setK2Roles(roles);
        request.setAttribute("user", info);
        if (roles != null) return true;
        // *************************************** ��һ���ֵ�У��
        // ��ȡ�������ͷ
        String XRequested = request.getHeader("X-Requested-With");
        /*if (StringUtils.isEmpty(XRequested))
            response.getWriter().write(JsonUtils.objectToJson(new SystemResult(100, "����������", null)));*/


        // ��ȡ�û�������Cookie��token��Ϣ
        String token = CookieUtils.getCookieValue(request, UserManageUtil.USER_COOKIE_TOKEN, true);
        // ��ȡ�û�������Cookie���˺���Ϣ
        String userName = CookieUtils.getCookieValue(request, UserManageUtil.USER_COOKIE_USERNAME, true);
        // �ж������Ƿ���ȷ
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(userName)) {
            // tokenΪ�� �û�û�е�¼
            // �ж��Ƿ���AJAX����
            if ("XMLHttpRequest".equals(XRequested)) {
                response.getWriter().write(JsonUtils.objectToJson(new SystemResult(206, "�û�δ��¼", null)));
            } else {
                // �û�δ��¼
                response.getWriter().write(JsonUtils.objectToJson(new SystemResult(207, "�û�δ��¼", null)));
            }
            return false;
        }


        // *************************************** �ڶ����ֵ�У��
        // ˵�������� ��ѯredis���Ƿ��������
        UserManageUtil userManageUtil = new UserManageUtil(jedisPool);
        SystemResult getUserInfo = userManageUtil.getUserInfoByAccountAndToken(userName, token);
        if (getUserInfo.getStatus() != 200) response.getWriter().write(JsonUtils.objectToJson(getUserInfo));

        // ��redis�в�ѯ�����û������� �ó����õ�һ�δ��ȥ��MAC���������������MAC��ַ��Ƚ� ��ֹCookie����
        String requestMac = NetworkUtil.getHostMacAddress(request);
        // ����û�����
        K2Member k2Member = (K2Member) getUserInfo.getData();
        // �Ƚ�MAC��ַ
        if (StringUtils.isEmpty(k2Member.getReqeustUserMac()) || StringUtils.isEmpty(requestMac)) {
            response.getWriter().write(JsonUtils.objectToJson(new SystemResult(207, "�û�δ��¼", null)));
            return false;
        }
        // ����token ��Ϊ����10�� ����IP+MAC��ַ
        if (!k2Member.getReqeustUserMac().equals(requestMac)) {
            response.getWriter().write(JsonUtils.objectToJson(new SystemResult(208, "����token", null)));
            return false;
        }

        // У��ɹ� ��ȡ�����û������� k2Member
        request.setAttribute("user", k2Member);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
