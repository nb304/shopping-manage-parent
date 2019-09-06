package com.king2.product.server.appoint;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.CookieUtils;
import com.king2.commons.utils.JsonUtils;
import com.king2.commons.utils.UserManageUtil;
import com.king2.product.server.cache.UserInfoCacheManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ��Ʒ��������ί����
 */
@Component
public class ProductReqeustInterceptorAppoint {

    // �û�token����cookie�е�key
    public static final String USER_TOKEN_COOKIE_KEY = "King2UserCookie";
    public static final String LOGIN_USER_COOKIE_KEY = "king2LoginUserName";

    // ע��JedisPool
    @Autowired
    private JedisPool jedisPool;

    /**
     * У��Redis���Ƿ��������
     *
     * @param obj
     * @return
     * @throws Exception
     */
    public SystemResult checkRedisIsExistUserInfo(Object obj) throws Exception {
        String[] cookies = (String[]) obj;

        // ��ѯredis���Ƿ��������
        UserManageUtil manageUtil = new UserManageUtil(jedisPool);
        SystemResult userInfoByAccountAndToken = manageUtil.getUserInfoByAccountAndToken(cookies[1], cookies[0]);
        return userInfoByAccountAndToken;
    }

    /**
     * ��ѯ������û��Ƿ�Я��cookie��Ϣ
     *
     * @param request
     * @return
     */
    public static SystemResult reqeustUserIfCarryCookie(HttpServletRequest request) {
        // �ж��û��Ƿ�Я��Token����
        String King2UserCookie = CookieUtils.getCookieValue(request, USER_TOKEN_COOKIE_KEY);
        if (StringUtils.isEmpty(King2UserCookie)) {
            // �û�û��Я��Token����
            return new SystemResult(100, "�û�δ��¼");
        }
        // �ж��û��Ƿ�Я���˺Ż���
        String king2LoginUserName = CookieUtils.getCookieValue(request, LOGIN_USER_COOKIE_KEY);
        if (StringUtils.isEmpty(king2LoginUserName)) {
            // �û�û��Я���˺Ź���
            return new SystemResult(100, "�û�δ��¼");
        }

        // Я�����˺� ��token��Ϣ���н���
        tokenDeCode(King2UserCookie);

        // �������ص�����
        String[] cookies = new String[2];
        cookies[0] = King2UserCookie;
        cookies[1] = king2LoginUserName;
        return new SystemResult(cookies);
    }

    /**
     * ��token��Ϣ���н���
     *
     * @param token
     */
    public static void tokenDeCode(String token) {
    }

    /**
     * У�鱾�ػ����Ƿ��������
     *
     * @return
     */
    public static SystemResult checkCacheIfExistUserInfo(Object obj) {
        String[] cookies = (String[]) obj;
        // ��ȡ���ػ������Ϣ
        UserInfoCacheManage instance = UserInfoCacheManage.getInstance();
        // ������
        synchronized (instance) {
            // ��ȡ�û���Ϣ��Map����
            ConcurrentHashMap<String, K2MemberAndElseInfo> userInfoCacheMapDatas = instance.getUserInfoCacheMapDatas();
            if (CollectionUtils.isEmpty(userInfoCacheMapDatas)) {
                if (userInfoCacheMapDatas == null) instance.setUserInfoCacheMapDatas(new ConcurrentHashMap<>());
                // ˵����������û���û���Ϣ
                return new SystemResult(201, "��������û���û���Ϣ");
            } else if (!userInfoCacheMapDatas.containsKey(cookies[0])) {
                return new SystemResult(201, "��������û���û���Ϣ");
            }

            // ������ ˵�����������д����û�����Ϣ ȡ�����������е���Ϣ �Ƚϵ�¼ǰ�����MAC��ַ�Ƿ�һ��
            K2MemberAndElseInfo k2MemberAndElseInfo = userInfoCacheMapDatas.get(cookies[0]);

            // ��ʱ��У�� ���ǵ�Ч������
            return new SystemResult(k2MemberAndElseInfo);
        }
    }

    /**
     * У��û��ͨ��
     *
     * @param response
     * @param XRequested
     * @throws Exception
     */
    public static void checkNotPass(HttpServletResponse response, String XRequested, boolean flag) throws Exception {

        // �Ƿ�Я����Cookie��Ϣ ���Я���� ˵���Ǳ�������
        if (flag) {
            response.getWriter().write(JsonUtils.objectToJson(new SystemResult(201, "�û�δ��¼", null)));
        } else {
            response.getWriter().write(JsonUtils.objectToJson(new SystemResult(401, "�û�δ��¼", null)));
        }
    }

}
