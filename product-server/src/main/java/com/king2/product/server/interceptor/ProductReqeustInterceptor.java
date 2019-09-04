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
	说明:   商城模块后台拦截器

	作者		时间					注释
  	俞烨		2019.8.9   			创建

=======================================================*/
public class ProductReqeustInterceptor implements HandlerInterceptor {

    // 注入RedisPool连接池
    @Autowired
    private JedisPool jedisPool;
    // 注入拦截器
    @Autowired
    private ProductReqeustInterceptorAppoint productReqeustInterceptorAppoint;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 开启跨域和接受Cookie信息
        String origin = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "Origin,Content-Type,Accept,token,X-Requested-With");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("P3P", "CP=\"CAO PSA OUR\"");

        // 获取浏览器的头
        String XRequested = request.getHeader("X-Requested-With");

        //************************************ 第一部分的简单校验

        // 判断用户是否携带Cookie信息
        SystemResult checkCookieResult = ProductReqeustInterceptorAppoint.reqeustUserIfCarryCookie(request);
        if (checkCookieResult.getStatus() != 200) {
            ProductReqeustInterceptorAppoint.checkNotPass(response, XRequested);
            return false;
        }


        //************************************ 第二部分的校验
        // 第一步部分校验通过 取出数据 校验本地缓存是否存在数据
        SystemResult checkCacheResult = ProductReqeustInterceptorAppoint.checkCacheIfExistUserInfo(checkCookieResult.getData());
        if (checkCacheResult.getStatus() == 200) {
            // 缓存数据存在数据就直接通过 如果不存在数据 就需要进行第三步校验 去redis中查询数据
            request.setAttribute("user", checkCacheResult.getData());
            return true;
        }

        //************************************ 第三部分的校验
        // 第二步没有查询到缓存中有该用户的信息 我们就需要去redis中查询数据信息 如果连redis中都不存在信息
        // 说明该用户没有登录
        // 如果redis中存在该用户的信息 就将该用户的信息存入本地的缓存中 这样就可以减少操作redis的次数
        SystemResult checkRedisIsResult = productReqeustInterceptorAppoint.checkRedisIsExistUserInfo(checkCookieResult.getData());
        if (checkRedisIsResult.getStatus() != 200) {
            ProductReqeustInterceptorAppoint.checkNotPass(response, XRequested);
            return false;
        }

        //************************************ 第四步存入缓存
        // 说明通过了校验 需要将用户信息存入缓存数据中
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
