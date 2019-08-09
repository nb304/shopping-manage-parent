package com.king2.product.server.interceptor;


import com.king2.commons.pojo.K2Member;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*=======================================================
	说明:   商城模块后台拦截器

	作者		时间					注释
  	俞烨		2019.8.9   			创建

=======================================================*/
public class ProductReqeustInterceptor implements HandlerInterceptor {

    // 注入RedisPool连接池
    @Autowired
    private JedisPool jedisPool;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // *************************************** 第一部分的校验
        // 获取浏览器的头
        String XRequested = request.getHeader("X-Requested-With");
        /*if (StringUtils.isEmpty(XRequested))
            response.getWriter().write(JsonUtils.objectToJson(new SystemResult(100, "请勿跨浏览器", null)));*/


        // 获取用户存在于Cookie的token信息
        String token = CookieUtils.getCookieValue(request, UserManageUtil.USER_COOKIE_TOKEN, true);
        // 获取用户存在于Cookie的账号信息
        String userName = CookieUtils.getCookieValue(request, UserManageUtil.USER_COOKIE_USERNAME, true);
        // 判断数据是否正确
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(userName)) {
            // token为空 用户没有登录
            // 判断是否是AJAX访问
            if ("XMLHttpRequest".equals(XRequested)) {
                response.getWriter().write(JsonUtils.objectToJson(new SystemResult(206, "用户未登录", null)));
            } else {
                // 用户未登录
                response.getWriter().write(JsonUtils.objectToJson(new SystemResult(207, "用户未登录", null)));
            }
            return false;
        }


        // *************************************** 第二部分的校验
        // 说明有数据 查询redis中是否存在数据
        UserManageUtil userManageUtil = new UserManageUtil(jedisPool);
        SystemResult getUserInfo = userManageUtil.getUserInfoByAccountAndToken(userName, token);
        if (getUserInfo.getStatus() != 200) response.getWriter().write(JsonUtils.objectToJson(getUserInfo));

        // 在redis中查询到该用户的数据 拿出来用第一次存进去的MAC和现在请求过来的MAC地址相比较 防止Cookie盗用
        String requestMac = NetworkUtil.getHostMacAddress(request);
        // 或得用户数据
        K2Member k2Member = (K2Member) getUserInfo.getData();
        // 比较MAC地址
        if (StringUtils.isEmpty(k2Member.getReqeustUserMac()) || StringUtils.isEmpty(requestMac)) {
            response.getWriter().write(JsonUtils.objectToJson(new SystemResult(207, "用户未登录", null)));
            return false;
        }
        // 盗用token 行为超过10次 封锁IP+MAC地址
        if (!k2Member.getReqeustUserMac().equals(requestMac)) {
            response.getWriter().write(JsonUtils.objectToJson(new SystemResult(208, "盗用token", null)));
            return false;
        }

        // 校验成功 获取到了用户的数据 k2Member
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
