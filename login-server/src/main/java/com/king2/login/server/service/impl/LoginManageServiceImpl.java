package com.king2.login.server.service.impl;

import com.king2.commons.mapper.K2MemberMapper;
import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.pojo.K2MemberExample;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.GetErrorInfo;
import com.king2.commons.utils.MD5Utils;
import com.king2.commons.utils.NetworkUtil;
import com.king2.commons.utils.UserManageUtil;
import com.king2.login.server.cache.UserLoginCacheManage2;
import com.king2.login.server.service.LoginManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LoginManageServiceImpl implements LoginManageService {

    @Autowired
    private K2MemberMapper k2MemberMapper;
    @Autowired
    private JedisPool jedisPool;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginManageServiceImpl.class);


    @Override
    public SystemResult login(String username, String password, HttpServletRequest request) {

        // 我这边就只进行查询用户是否存在 他的角色信息和其他的信息 我就不查询了

        // 校验缓存数据是否存在该用户的信息
        SystemResult checkCacheResult = checkCacheIsUserInfo(username, password);
        // 状态==200 说明缓存中存在该用户的数据信息 并且账号密码通过了验证 返回值是一个用户的数据信息
        if (checkCacheResult.getStatus() == 200) {
            // 取出信息
            K2Member member = (K2Member) checkCacheResult.getData();

            // 将用户数据重新存入redis中
            SystemResult result = null;
            try {
                result = userInfoGotoRedisCache(member, request);
            } catch (Exception e) {
                LOGGER.error("将用户信息存入redis中出错,错误信息:" + e);
                LOGGER.error(GetErrorInfo.getTrace(e));
                e.printStackTrace();
            }
            // 返回信息  状态==200或者201说明登入成功 登入成功后 会携带本地的token 需要我们手动写回客户端
            return result;
        }

        // 说明缓存中没有该用户的数据信息 我们需要查询数据库中的信息
        SystemResult checkMySqlInfoResult =
                cacheNotFoundUserInfoCurrentGotoMySqlGetInfo(username, password);
        if (checkMySqlInfoResult.getStatus() != 200) return checkMySqlInfoResult;

        // 校验成功 说明用户登入成功了 checkMySqlInfoResult返回的data中携带了该用户的账号信息
        K2Member data = (K2Member) checkMySqlInfoResult.getData();

        // 这里提两个思路
        // 1、你可以生成用户token并返回给用户  提醒用户登录成功 然后创建一个安全的线程将用户信息存入reids和本地缓存中
        //      1、1存和取的过程中是一定要加锁的 否则会出现数据安全的隐患
        // 2、一条线走下去

        // 我现在选择第二种办法
        SystemResult result = null;
        try {

            // 将用户信息存入本地的缓存数据
            userInfoAddToCache(data);

            // 存入成功后 存入redis中
            result = userInfoGotoRedisCache(data, request);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return result;
    }

    /**
     * 在缓存中没有找到该用户的信息  现在我们去往数据库查询该用户的信息
     *
     * @return
     */
    public SystemResult cacheNotFoundUserInfoCurrentGotoMySqlGetInfo(String username, String password) {

        // 查询数据库的信息
        K2MemberExample example = new K2MemberExample();
        example.createCriteria().andMemberAccountEqualTo(username);
        List<K2Member> k2Members = k2MemberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(k2Members)) {
            // 说明用户名存在 比较密码
            K2Member member = k2Members.get(0);
            // 加密规则自己定义
            if (!password.equals(member.getMemberPassword())) {
                return new SystemResult(100, "用户名或密码错误!!");
            }
        } else {
            return new SystemResult(100, "用户名或密码错误!!");
        }

        return new SystemResult(k2Members.get(0));
    }

    /**
     * 将用户数据重新存入redis中
     *
     * @param k2Member
     * @return
     * @throws Exception
     */
    public SystemResult userInfoGotoRedisCache(K2Member k2Member, HttpServletRequest request) throws Exception {

        // 创建Redis中需要的数据结构
        K2MemberAndElseInfo k2MemberAndElseInfo = new K2MemberAndElseInfo();
        k2Member.setReqeustUserMac(NetworkUtil.getHostMacAddress(request));
        k2MemberAndElseInfo.setK2Member(k2Member);
        // 角色信息
        k2MemberAndElseInfo.setK2Roles(new ArrayList<>());

        // 生成token信息
        // token规则你可以自己定义
        String token = MD5Utils.md5(k2Member.getMemberAccount() + new Date().getTime() + UUID.randomUUID().toString());
        // 调用UserUtil的刷新工具
        UserManageUtil userManageUtil = new UserManageUtil(jedisPool);
        SystemResult refresh = userManageUtil.refresh(k2MemberAndElseInfo, token);

        // 这里的refresh会返回本次登入的状态 详情看方法内部
        k2MemberAndElseInfo.setCurrentToken(token);
        return refresh;
    }

    /**
     * 将用户信息存入本地缓存
     *
     * @param k2Member
     * @return
     */
    public static void userInfoAddToCache(K2Member k2Member) {
        // 需要锁
        UserLoginCacheManage2 instance = UserLoginCacheManage2.getInstance();
        // 由于instance是单例的 所以可以直接用来当锁使用
        synchronized (instance) {

            instance.getUserCacheHashMapDatas().put(k2Member.getMemberAccount(), k2Member);
        }
    }

    /**
     * 校验缓存信息的用户数据信息
     *
     * @param username
     * @param password
     * @return
     */
    public static SystemResult checkCacheIsUserInfo(String username, String password) {
        // 获取缓存数据
        // 需要锁
        UserLoginCacheManage2 instance = UserLoginCacheManage2.getInstance();
        // 由于instance是单例的 所以可以直接用来当锁使用
        synchronized (instance) {


            // 用户的数据信息
            ConcurrentHashMap<String, K2Member> userCacheHashMapDatas =
                    instance.getUserCacheHashMapDatas();

            // 判断缓存信息是否存在该用户
            if (CollectionUtils.isEmpty(userCacheHashMapDatas)) {
                return new SystemResult(100, "缓存数据不存在数据");
            } else if (!userCacheHashMapDatas.containsKey(username)) {
                return new SystemResult(100, "缓存数据不存在数据");
            }

            // 用户存在缓存的信息  如果用户进行改密码等其他敏感数据的操作  记住删除缓存的数据信息
            K2Member k2Member = userCacheHashMapDatas.get(username);
            if (k2Member == null) return new SystemResult(100, "缓存数据不存在数据");

            // 比较密码
            if (!password.equals(k2Member.getMemberPassword())) {
                return new SystemResult(100, "用户名或密码错误!!");
            }

            return new SystemResult(k2Member);
        }

    }
}
