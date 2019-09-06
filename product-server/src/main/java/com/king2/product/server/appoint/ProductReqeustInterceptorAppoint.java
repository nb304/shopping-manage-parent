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
 * 商品拦截器的委派类
 */
@Component
public class ProductReqeustInterceptorAppoint {

    // 用户token存在cookie中的key
    public static final String USER_TOKEN_COOKIE_KEY = "King2UserCookie";
    public static final String LOGIN_USER_COOKIE_KEY = "king2LoginUserName";

    // 注入JedisPool
    @Autowired
    private JedisPool jedisPool;

    /**
     * 校验Redis中是否存在数据
     *
     * @param obj
     * @return
     * @throws Exception
     */
    public SystemResult checkRedisIsExistUserInfo(Object obj) throws Exception {
        String[] cookies = (String[]) obj;

        // 查询redis中是否存在数据
        UserManageUtil manageUtil = new UserManageUtil(jedisPool);
        SystemResult userInfoByAccountAndToken = manageUtil.getUserInfoByAccountAndToken(cookies[1], cookies[0]);
        return userInfoByAccountAndToken;
    }

    /**
     * 查询请求的用户是否携带cookie信息
     *
     * @param request
     * @return
     */
    public static SystemResult reqeustUserIfCarryCookie(HttpServletRequest request) {
        // 判断用户是否携带Token过来
        String King2UserCookie = CookieUtils.getCookieValue(request, USER_TOKEN_COOKIE_KEY);
        if (StringUtils.isEmpty(King2UserCookie)) {
            // 用户没有携带Token过来
            return new SystemResult(100, "用户未登录");
        }
        // 判断用户是否携带账号回来
        String king2LoginUserName = CookieUtils.getCookieValue(request, LOGIN_USER_COOKIE_KEY);
        if (StringUtils.isEmpty(king2LoginUserName)) {
            // 用户没有携带账号过来
            return new SystemResult(100, "用户未登录");
        }

        // 携带了账号 对token信息进行解密
        tokenDeCode(King2UserCookie);

        // 创建返回的数据
        String[] cookies = new String[2];
        cookies[0] = King2UserCookie;
        cookies[1] = king2LoginUserName;
        return new SystemResult(cookies);
    }

    /**
     * 对token信息进行解密
     *
     * @param token
     */
    public static void tokenDeCode(String token) {
    }

    /**
     * 校验本地缓存是否存在数据
     *
     * @return
     */
    public static SystemResult checkCacheIfExistUserInfo(Object obj) {
        String[] cookies = (String[]) obj;
        // 获取本地缓存的信息
        UserInfoCacheManage instance = UserInfoCacheManage.getInstance();
        // 开启锁
        synchronized (instance) {
            // 获取用户信息的Map集合
            ConcurrentHashMap<String, K2MemberAndElseInfo> userInfoCacheMapDatas = instance.getUserInfoCacheMapDatas();
            if (CollectionUtils.isEmpty(userInfoCacheMapDatas)) {
                if (userInfoCacheMapDatas == null) instance.setUserInfoCacheMapDatas(new ConcurrentHashMap<>());
                // 说明缓存数据没有用户信息
                return new SystemResult(201, "缓存数据没有用户信息");
            } else if (!userInfoCacheMapDatas.containsKey(cookies[0])) {
                return new SystemResult(201, "缓存数据没有用户信息");
            }

            // 到这里 说明缓存数据中存在用户的信息 取出缓存数据中的信息 比较登录前存入的MAC地址是否一致
            K2MemberAndElseInfo k2MemberAndElseInfo = userInfoCacheMapDatas.get(cookies[0]);

            // 暂时不校验 考虑到效率问题
            return new SystemResult(k2MemberAndElseInfo);
        }
    }

    /**
     * 校验没有通过
     *
     * @param response
     * @param XRequested
     * @throws Exception
     */
    public static void checkNotPass(HttpServletResponse response, String XRequested, boolean flag) throws Exception {

        // 是否携带了Cookie信息 如果携带了 说明是被顶号了
        if (flag) {
            response.getWriter().write(JsonUtils.objectToJson(new SystemResult(201, "用户未登录", null)));
        } else {
            response.getWriter().write(JsonUtils.objectToJson(new SystemResult(401, "用户未登录", null)));
        }
    }

}
