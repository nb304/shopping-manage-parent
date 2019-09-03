package com.king2.login.server.service.impl;

import cn.hutool.core.util.StrUtil;
import com.king2.commons.mapper.K2MemberMapper;
import com.king2.commons.pojo.*;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.*;
import com.king2.login.server.cache.UserLoginCacheManage;
import com.king2.login.server.mapper.MyLoginMapper;
import com.king2.login.server.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*================================================================
说明：用户登录业务接口实现类

作者          	时间            		注释
刘梓江           2019/8/31           创建类

==================================================================*/
@Service
public class LoginServiceImpl implements LoginService {


    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private JedisPool jedisPool;                        //注入对应的redis缓存池

    @Autowired
    private K2MemberMapper K2MemberMapper;              //注入操作用户信息接口mapper

    @Autowired
    private  MyLoginMapper myLoginmapper;               //注入操作用户角色、用户权限mapper

    @Value("${VUE-FRONT-IP}")
    private String  VUEFRONT_IP;                       //获取远程的前端后台的IP地址

    @Value("${FAILURE_MESS}")
    private  String FAILURE_MESS;                  //将请求失败信息(IP+MAC地址)存储到缓存中的标志记录失败次数

    @Value("${BLACK_LIST}")
    private  String BLACK_LIST;                    //黑名单在本地缓存中的标志

    private final String MEMBERS_AUTH="MEMBERS_AUTH";   //将用户信息存储到缓存中的标志



    /**-----------------------------------------------------------------
     * 功能：登录
     *
     * 参数：形参名               类型		                    描述
     *      account             String                      用户账号
     *      password            String                      用户密码
     *      request             HttpServletRequest          请求对象
     *      response            HttpServletResponse         响应对象
     *
     * 返回：SystemResult 该方法返回信息封装存储到响应体对象
     -------------------------------------------------------------------*/
    @Override
    public SystemResult login(String account, String password, HttpServletRequest request, HttpServletResponse response) {

        //获取解码后的用户名和密码
        Map<String,String> decryptionMap=this.AccountDecryption(account,password);
        K2MemberAndElseInfo info=null
        try {
            //获取请求对应的IP地址
            String  IPAddress=NetworkUtil.getHostIpAddress(request);
            //获取请求对应的Mac地址
            String  MacAddress=NetworkUtil.getHostMacAddress(request);

            //获取对应的本地缓存管理器
            UserLoginCacheManage manage=UserLoginCacheManage.getCacheManage();
            ConcurrentHashMap<String,HashMap<String,Object>> hostCacheManage=manage.getMap();

            //获取对应的远程缓存管理器
            Jedis resource = jedisPool.getResource();

            //获取用户信息
            info = this.getMemberInfo(decryptionMap, hostCacheManage, resource);
            if(info==null){
                //密码或用户名错误将错误记录到本地缓存中
                this.setFailureCache(IPAddress,MacAddress,hostCacheManage);

                //代表用户名或密码错误
                return SystemResult.build(401,"用户名或密码错误");
            }
            if(info.getK2Member().getMemberState()==1) {
                this.setFailureCache(IPAddress,MacAddress,hostCacheManage);

                //代表用户非正常状态
                return SystemResult.build(402,"该用户名已被锁定,需要联系管理员,请勿重新登录");
            }
            if(info.getK2Roles()==null ||info.getK2Roles().size()<1 ||info.getK2Jurs()==null ||info.getK2Jurs().size()<1 ){
                //代表用户没有任何权限访问该系统
                return SystemResult.build(403,"没有权限访问该系统");
            }

            //生成当前登录成功的唯一标志
            String memberToken= MD5Utils.md5(decryptionMap.get("account")+MacAddress+System.currentTimeMillis());

            //将当前用户存储到远程缓存中
            UserManageUtil userManage= new  UserManageUtil(jedisPool);
            userManage.refresh(info,memberToken);

            //将当前登录成功的用户信息存储到本地缓存中一份
            HashMap<String, Object> stringObjectHashMap = hostCacheManage.get(MEMBERS_AUTH);
            if(stringObjectHashMap.get(decryptionMap.get("account"))==null){
                stringObjectHashMap.put(decryptionMap.get("account"),info);
            }

            //将当前登录成功的用户信息也存储一份到远程缓存中
            resource.set(MEMBERS_AUTH,JsonUtils.objectToJson(stringObjectHashMap));

            //将用户写入到Cookie中
            Cookie USER_TOKEN=new Cookie("USER_TOKEN",memberToken);
            Cookie USER_MESS=new Cookie("USER_MESS",info);

            USER_TOKEN.setDomain();



        }catch (IOException e) {

        }catch (Exception e) {
            e.printStackTrace();
            return SystemResult.build(501,"访问人数过多请稍后再试");
        }finally {
            resource.close()
        }
        return SystemResult.ok(info);
    }






    /**-----------------------------------------------------------------
     * 功能：登录失败后将信息记录到本地缓存中
     *
     * 参数：形参名               类型		                    描述
     *      IPAddress         String                        客户端的ip地址
     *      MacAddress        String                        客户端的MAC地址
     *      failureMap        HashMap<String, Object>       本地缓存管理器
     * 返回：Boolean true:操作成功 同理
     -------------------------------------------------------------------*/
    public Boolean setFailureCache(String  IPAddress,String  MacAddress,ConcurrentHashMap<String, HashMap<String, Object>> hostCacheManage){
        HashMap<String, Object> failureMessMap = hostCacheManage.get(FAILURE_MESS);
        HashMap<String, Object> blackListMap = hostCacheManage.get(BLACK_LIST);

        //由于是多线程，出现数据不能同步问题利用Lock锁进行线程原子性操作
        Lock lock = new ReentrantLock();
        try {
            lock.lock();

            //判断failureMess、blackList是否为空
            if(blackListMap==null||failureMessMap==null){
                //进行数据初始化
                failureMessMap=new HashMap<>();
                blackListMap=new HashMap<>();
            }

            Object frequencyNumber = failureMessMap.get(IPAddress + "_" + MacAddress);
            if(frequencyNumber==null){
                failureMessMap.put(IPAddress + "_" + MacAddress,1);
            }

            Integer number=Integer.parseInt(frequencyNumber.toString());

            if(number==9){

                //由于失败次数连续超过了10次,将该今天的登录失败次数制空,且放入到黑名单中
                failureMessMap.put(IPAddress + "_" + MacAddress,null);

                //将当前客户端列入到黑名单列表中
                blackListMap.put(IPAddress + "_" + MacAddress,System.currentTimeMillis());
            }

            if(number<9){
                //对当前的连续失败次数进行计数
                failureMessMap.put(IPAddress + "_" + MacAddress,number+1);
            }

            //将当前同步后的数据重新刷新的本地缓存中
            hostCacheManage.put(FAILURE_MESS,failureMessMap);
            hostCacheManage.put(BLACK_LIST,blackListMap);

            return true;

        } finally {
            lock.unlock();
        }
    }

    /**-----------------------------------------------------------------
     * 功能：登录成功后将信息记录到本地缓存中
     *
     * 参数：形参名               类型		                    描述
     *      IPAddress         String                        客户端的ip地址
     *      MacAddress        String                        客户端的MAC地址
     *      failureMap        HashMap<String, Object>       本地缓存管理器
     * 返回：Boolean true:操作成功 同理
     -------------------------------------------------------------------*/
    public Boolean setSuccessfulCache(String  IPAddress,String  MacAddress,
                                      ConcurrentHashMap<String, HashMap<String, Object>> hostCacheManage,
                                      Jedis
                                        ){



    }


    /**-----------------------------------------------------------------
     * 功能：退出登录
     *
     * 参数：形参名               类型		        描述
     *      token               String        用户登录成功的唯一标识
     *      account             String        用户账号
     *      HttpServletRequest  request       请求对象
     *
     * 返回：SystemResult 该方法返回信息封装存储到响应体对象
     -------------------------------------------------------------------*/
    @Override
    public SystemResult outLogin(String token, String account, HttpServletRequest request) {
        return null;
    }




    /**-----------------------------------------------------------------
     * 功能：获取对应的用户信息
     *
     * 参数：形参名               类型		                    描述
     *      decryptionMap       Map<String,String>          存储账号、密码、解码信息
     *      manageMap           ConcurrentHashMap<String,HashMap<String,Object>> 本地缓存管理对象
     *      resource            Jedis                       远程缓存管理对象
     *
     * 返回：K2MemberAndElseInfo 封装了用户信息,用户不存在返回null
     -------------------------------------------------------------------*/
    public K2MemberAndElseInfo getMemberInfo(Map<String,String> decryptionMap,
                                          ConcurrentHashMap<String,HashMap<String,Object>> manageMap,
                                          Jedis resource) {
        //定义对应的封装用户成员信息
        K2MemberAndElseInfo k2MemberAndElseInfo = null;

        try {

            //定义对应的是否有对应的用户信息标志
            Boolean authFalg = true;

            //获取redis缓存中的用户信息
            if (resource != null) {
                //获取该缓存中的用户经常登录的消息信息
                String authMess = resource.get(MEMBERS_AUTH);
                if (StrUtil.isNotEmpty(authMess)) {

                    //authMess换成Map key:账号 value:是对应的该用户的成员信息(成员、角色、权限信息)
                    Map<String, K2MemberAndElseInfo> reidsAuthInfoMap = null;

                    reidsAuthInfoMap = JsonUtils.jsonToPojo(authMess, Map.class);

                    //判断当前信息是否在远程缓存中存在
                    k2MemberAndElseInfo = reidsAuthInfoMap.get(decryptionMap.get("account"));
                    authFalg = (k2MemberAndElseInfo == null ? true : false);

                }
            }

            //如果redis中的缓存无法连接到就到本地缓存中查找
            if (authFalg) {
                //获取对应的账号用户名信息
                Map<String, Object> hostCacheMap = manageMap.get("MEMBERS_AUTH");

                //判断当前信息是否在本地缓存中存在
                k2MemberAndElseInfo = (K2MemberAndElseInfo) hostCacheMap.get(decryptionMap.get("account"));
                authFalg = (k2MemberAndElseInfo == null ? true : false);
            }


            //如果本地缓存及对应的远程缓存都找不到就去数据库中查找
            if (authFalg) {
                //判断用户名、密码是否填写正确
                K2MemberExample example = new K2MemberExample();
                K2MemberExample.Criteria criteria = example.createCriteria();
                criteria.andMemberAccountEqualTo(decryptionMap.get("account"));
                criteria.andMemberPasswordEqualTo(decryptionMap.get("password"));
                criteria.andMemberStateNotEqualTo(2);
                List<K2Member> members = K2MemberMapper.selectByExample(example);

                k2MemberAndElseInfo = (members.size() < 1 ? null : getMemeberInfo(members.get(0)));
            }
        }catch(IOException e) {
            e.printStackTrace();
            try {
            }catch (Exception e) {
                LOGGER.error("获取用户信息错误");
                LOGGER.error(GetErrorInfo.getTrace(e));
            }
            return null;
        }finally {
            resource.close();
        }

        return k2MemberAndElseInfo;
    }




    /**-----------------------------------------------------------------
     * 功能：从数据库中获取该用户对应的角色、权限信息
     *
     * 参数：形参名         类型		    描述
     *      参数1         类型1          描述1

     * 返回：K2MemberAndElseInfo 封装用户对应的角色,权限信息
     -------------------------------------------------------------------*/
    public K2MemberAndElseInfo getMemeberInfo(K2Member  k2member){

        //创建K2MemberAndElseInfo对象 封装 成员、成员角色、成员权限信息
        K2MemberAndElseInfo info=new K2MemberAndElseInfo();
        info.setK2Member(k2member);
        //判断用户账号状态时候是正常的
        if(k2member.getMemberState()==1){
            return info;
        }

        //获取用户对应的角色信息
        List<K2Role> roleMess = myLoginmapper.getMemberOnRoleMess(k2member.getMemberAccount());
        if(roleMess.size()<1){
            return info;
        }

        //创建一个角色id集合
        List<Integer> roleIds=new ArrayList<>();
        for(int a=0;a<roleMess.size();a++){
            roleIds.add(roleMess.get(a).getRoleId());
        }

        //获取用户对应的权限信息
        List<K2Jurisdiction> jurs = myLoginmapper.getMemberOnJurMess(roleIds);

        info.setK2Roles(roleMess);
        info.setK2Jurs(jurs);

        return info;

    }


    /**-----------------------------------------------------------------
     * 功能：用于对账号、密码 进行解码
     *
     * 参数：形参名               类型		        描述
     *      account             String          账号
     *      password            String          密码
     *
     * 返回：Map<String,String>   key(account,password) value(对应解密后的内容)
     -------------------------------------------------------------------*/
    public Map<String,String> AccountDecryption(String account, String password){
        Map<String,String> decryptionMap=new HashMap<>();





        decryptionMap.put(account,account);
        decryptionMap.put(password,password);

        return decryptionMap;
    }
}
