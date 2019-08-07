package com.king2.product.server.controller;

import com.king2.commons.getnumber.ShoppingNumberManage;
import com.king2.commons.pojo.K2Member;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.CookieUtils;
import com.king2.commons.utils.UserManageUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 测试
 */
@RestController
@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestDemoController {

    @Autowired
    private JedisPool jedisPool;

    /**
     * 测试获取用户信息
     *
     * @param acc
     * @param request
     * @return
     */
    @RequestMapping("/getUser")
    public SystemResult getUser(String acc, HttpServletRequest request) throws Exception {
        String token = CookieUtils.getCookieValue(request, "token", true);
        Jedis jedis = jedisPool.getResource();
        // 创建用户管理类
        UserManageUtil userManageUtil = new UserManageUtil(jedis);
        SystemResult userInfoByAccountAndToken = userManageUtil.getUserInfoByAccountAndToken(acc, token);
        if (!StringUtils.isEmpty(token) && userInfoByAccountAndToken == null) {
            return new SystemResult(100, "该账号在其他地方登录", null);
        }
        return userInfoByAccountAndToken;
    }


    /**
     * 用户登录成功的调用思路
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/userLogin")
    public SystemResult userLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {

        K2Member member = new K2Member();
        member.setMemberAccount("luqiqi");
        member.setMemberAddress("上海市");
        // 登录成功 生成唯一Token
        StringBuffer sb = new StringBuffer();
        sb.append(UUID.randomUUID().toString().replaceAll("-", "").substring(22));
        sb.append("-" + new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
        // 创建用户管理类
        Jedis jedis = jedisPool.getResource();
        UserManageUtil userManageUtil = new UserManageUtil(jedis);
        // 调用redis
        SystemResult refresh = userManageUtil.refresh(member, sb.toString());
        // 写回Cookie
        CookieUtils.setCookie(request, response, "token", sb.toString(), true);
        return refresh;
    }

    @Value("${PRODUCT_NUMBER_REDIS_KEY}")
    private String PRODUCT_NUMBER_REDIS_KEY;

    /**
     * 测试添加编号
     *
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping("/testAddNumber")
    public SystemResult testAddNumber(int size) throws Exception {
        System.out.println(System.getProperty("file.encoding"));
        Jedis jedis = jedisPool.getResource();
        // new File("classpath:unlock.lua")
        String srcipt = FileUtils.readFileToString(ResourceUtils.getFile("classpath:unlock.lua"), "utf-8");
        ShoppingNumberManage numberManage = new ShoppingNumberManage(jedis, srcipt, PRODUCT_NUMBER_REDIS_KEY, "SP", 11);
        SystemResult systemResult = numberManage.addProductNumber(size, 0);
        return systemResult;
    }


    /**
     * 测试获取reids中的编号
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/testGetNumber")
    public SystemResult testGetNumber() throws Exception {

        BigDecimal bigDecimal = new BigDecimal("ada");
        System.out.println(bigDecimal.floatValue());
        return null;
    }

}
