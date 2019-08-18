package com.king2.product.server.controller;

import com.king2.commons.getnumber.ShoppingNumberManage;
import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2ProductSkuKey;
import com.king2.commons.pojo.K2ProductWithBLOBs;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.*;
import com.king2.product.server.cache.SystemCacheManage;
import com.king2.product.server.dto.ProductInfoDto;
import com.king2.product.server.locks.ProductQueueLockFactory;
import com.king2.product.server.pojo.ProductSkuPojo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ????
 */
@RestController
@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class TestDemoController {

    @Autowired
    private JedisPool jedisPool;

    /**
     * ????????????
     *
     * @param acc
     * @param request
     * @return
     */
    @RequestMapping("/getUser")
    public SystemResult getUser(String acc, HttpServletRequest request) throws Exception {
        /*String mac = NetworkUtil.getHostMacAddress(request);
        System.out.println(mac);*/

        // System.out.println(ProductServerLog.SYSTEM_PATH);
       /* ShoppingNumberManage manage = new ShoppingNumberManage(jedisPool, SystemCacheManage.UNLOCK_REDIS_LUA,"DD","PP",11);
        SystemResult dd = manage.getNumberByRedisKey("DD", 123);*/

        UserManageUtil userManageUtil = new UserManageUtil(jedisPool);

        K2Member k2Member = new K2Member();
        k2Member.setMemberAccount("luqiqi2");
        k2Member.setReqeustUserMac("FF-FF-FF");
        String token = "luqiqi";

        SystemResult refresh = userManageUtil.refresh(k2Member, token);

        return null;
    }


    @RequestMapping("/user/login")
    public SystemResult login(String username, String password) {
        System.out.println();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {

            return new SystemResult(100, "�û�������Ϊ��", null);
        } else if (!"admin".equals(username) || !"admin1".equals(password)) {
            return new SystemResult(100, "�û����������", null);
        }

        return new SystemResult("ok");
    }


    /**
     * ???????????????��
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
        member.setMemberAddress("?????");
        // ?????? ????��?Token
        StringBuffer sb = new StringBuffer();
        sb.append(UUID.randomUUID().toString().replaceAll("-", "").substring(22));
        sb.append("-" + new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
        // ?????????????
        Jedis jedis = jedisPool.getResource();
        UserManageUtil userManageUtil = new UserManageUtil(jedisPool);
        // ????redis
        SystemResult refresh = userManageUtil.refresh(member, sb.toString());
        // ��??Cookie
        CookieUtils.setCookie(request, response, "token", sb.toString(), true);
        return refresh;
    }

    @Value("${PRODUCT_NUMBER_REDIS_KEY}")
    private String PRODUCT_NUMBER_REDIS_KEY;

    /**
     * ?????????
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
//        String srcipt = FileUtils.readFileToString(ResourceUtils.getFile("classpath:unlock.lua"), "utf-8");
//        ShoppingNumberManage numberManage = new ShoppingNumberManage(jedisPool, srcipt, PRODUCT_NUMBER_REDIS_KEY, "SP", 11);
//        SystemResult systemResult = numberManage.addProductNumber(100000 );
        String addRedisLockFlag = jedis.set("DDLOCK", "1123", "NX", "EX", 100);

        return null;
    }


    /**
     * ������
     *
     * @return
     */
    @RequestMapping("/lock")
    public SystemResult lock() {
        // ��ȡ������
        ProductQueueLockFactory instance = ProductQueueLockFactory.getInstance();
        ReentrantLock reentrantLock = instance.getLockMaps().get(instance.DEFAULT_PRODUCT_INFO_KEY).getLock();
        Condition condition = instance.getLockMaps().get(instance.DEFAULT_PRODUCT_INFO_KEY).getCondition();
        try {
            System.out.println("���Լ�����������");
            reentrantLock.lock();
            System.out.println("�����ɹ�!!!!!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("���Խ���������");
            // ���������߳�
            condition.signalAll();
            reentrantLock.unlock();
            System.out.println("���ѳɹ���������");
            System.out.println("���Խ����ɹ�������");
        }
        return new SystemResult("ok");
    }

    public static void main(String[] args) throws Exception {
        ProductInfoDto infoDto = new ProductInfoDto();
        infoDto.setProductBazaarPrice(new BigDecimal(3200.99));
        infoDto.setProductBrandId(1);
        infoDto.setProductIfSupport(1);
        infoDto.setProductName("DW�ֱ�");
        infoDto.setProductOneCategoryId(1);
        infoDto.setProductTwoCategoryId(2);
        infoDto.setProductPoints("��������");
        infoDto.setProductSketchContent("���Բ���");
        infoDto.setProductSystemPrice(new BigDecimal(2323));
        infoDto.setProductUnit("��");
        System.out.println(JsonUtils.objectToJson(infoDto));
        List<ProductSkuPojo> dtos = new ArrayList<>();
        ProductSkuPojo dto = new ProductSkuPojo();
        dto.setSkuKeyOrder("1");
        dto.setProductSkuKeyName("��ɫ");
        dto.setSkuValue("��ɫ,��ɫ,��ɫ");
        dtos.add(dto);
        System.out.println(JsonUtils.objectToJson(dtos));

    }


    /*public static void main(String[] args) throws Exception {

        InputStreamReader reader = new InputStreamReader(new FileInputStream(new File("C:\\Users\\22464\\Desktop\\�����ʿ�.txt")));
        BufferedReader sr = new BufferedReader(reader);
        String lineText = "";
        FileWriter writer = new FileWriter(new File("C:\\Users\\22464\\Desktop\\txt.txt"),true);
        while ((lineText = sr.readLine()) != null) {
            writer.append(lineText + ",");
            writer.flush();
        }

        writer.close();
    }*/

    /**
     * ??????reids?��???
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
