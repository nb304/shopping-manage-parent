package com.king2.login.server.cache;


import cn.hutool.core.date.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/*================================================================
说明：本地缓存存储用户登录信息的管理器

作者          	时间            		注释
刘梓江           2019/8/31           创建类

==================================================================*/
public class UserLoginCacheManage {


    private final String FAILURE_MESS="FAILURE_MESS";                   //将请求失败信息(IP+MAC地址)存储到缓存中的标志记录失败次数

    private final String BLACK_LIST="BLACK_LIST";                       //黑名单在本地缓存中的标志

    private final Logger log=LoggerFactory.getLogger(UserLoginCacheManage.class);


    //私有掉构造不能new 该管理器对象
    private UserLoginCacheManage()
    {
        super();
        //this.ListeningCacheContent();
    }

    //创建对应的用户登录缓存管理器
    private static  UserLoginCacheManage cacheManage =new UserLoginCacheManage();
    public static   UserLoginCacheManage  getCacheManage()
    {
        return cacheManage;
    }


    //创建了一个同步map的数据结构对象,存储对应的登录信息
    private ConcurrentHashMap<String,HashMap<String,Object>> map=new ConcurrentHashMap();


    public ConcurrentHashMap<String, HashMap<String, Object>> getMap() {
        return map;
    }

    public void setMap(ConcurrentHashMap<String, HashMap<String, Object>> map) {
        this.map = map;
    }


    public void ListeningCacheContent(){

        //监听本地缓存中的内容
        while(true){
            //获取当前今天时间
            Long currTimeNumber=System.currentTimeMillis();

            //获取今天当前最后一个时间段的时间
            Date endOfDay = DateUtil.endOfDay(new Date());
            Long endTimeNumber=endOfDay.getTime();

            //计算出当前时间与最后一个时间段的时间差
            Long cha=endTimeNumber-currTimeNumber;

            //将当前线程休眠
            try {
                Thread.sleep(cha);
            } catch (InterruptedException e) {

            }


        }

    }



}
