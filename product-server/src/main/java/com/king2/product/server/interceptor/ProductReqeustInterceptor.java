package com.king2.product.server.interceptor;


import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.pojo.K2Role;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.CookieUtils;
import com.king2.commons.utils.JsonUtils;
import com.king2.commons.utils.NetworkUtil;
import com.king2.commons.utils.UserManageUtil;
import com.king2.product.server.appoint.ProductReqeustInterceptorAppoint;
import com.king2.product.server.cache.UserInfoCacheManage;
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
    // ע��������
    @Autowired
    private ProductReqeustInterceptorAppoint productReqeustInterceptorAppoint;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // ��������ͽ���Cookie��Ϣ
        String origin = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "Origin,Content-Type,Accept,token,X-Requested-With");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("P3P", "CP=\"CAO PSA OUR\"");

        // ��ȡ�������ͷ
        String XRequested = request.getHeader("X-Requested-With");

        //************************************ ��һ���ֵļ�У��

        // �ж��û��Ƿ�Я��Cookie��Ϣ
        SystemResult checkCookieResult = ProductReqeustInterceptorAppoint.reqeustUserIfCarryCookie(request);
        if (checkCookieResult.getStatus() != 200) {
            ProductReqeustInterceptorAppoint.checkNotPass(response, XRequested);
            return false;
        }


        //************************************ �ڶ����ֵ�У��
        // ��һ������У��ͨ�� ȡ������ У�鱾�ػ����Ƿ��������
        SystemResult checkCacheResult = ProductReqeustInterceptorAppoint.checkCacheIfExistUserInfo(checkCookieResult.getData());
        if (checkCacheResult.getStatus() == 200) {
            // �������ݴ������ݾ�ֱ��ͨ�� ������������� ����Ҫ���е�����У�� ȥredis�в�ѯ����
            request.setAttribute("user", checkCacheResult.getData());
            return true;
        }

        //************************************ �������ֵ�У��
        // �ڶ���û�в�ѯ���������и��û�����Ϣ ���Ǿ���Ҫȥredis�в�ѯ������Ϣ �����redis�ж���������Ϣ
        // ˵�����û�û�е�¼
        // ���redis�д��ڸ��û�����Ϣ �ͽ����û�����Ϣ���뱾�صĻ����� �����Ϳ��Լ��ٲ���redis�Ĵ���
        SystemResult checkRedisIsResult = productReqeustInterceptorAppoint.checkRedisIsExistUserInfo(checkCookieResult.getData());
        if (checkRedisIsResult.getStatus() != 200) {
            ProductReqeustInterceptorAppoint.checkNotPass(response, XRequested);
            return false;
        }

        //************************************ ���Ĳ����뻺��
        // ˵��ͨ����У�� ��Ҫ���û���Ϣ���뻺��������
        UserInfoCacheManage instance = UserInfoCacheManage.getInstance();
        synchronized (instance) {
            String[] cookies = (String[]) checkCookieResult.getData();
            instance.getUserInfoCacheMapDatas().put(cookies[0], (K2MemberAndElseInfo) checkRedisIsResult.getData());
        }
        request.setAttribute("user", checkRedisIsResult.getData());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
