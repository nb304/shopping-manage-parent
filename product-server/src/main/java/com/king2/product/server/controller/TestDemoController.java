package com.king2.product.server.controller;

import com.king2.commons.getnumber.ShoppingNumberManage;
import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2ProductSkuKey;
import com.king2.commons.pojo.K2ProductWithBLOBs;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.*;
import com.king2.product.server.cache.SystemCacheManage;
import com.king2.product.server.pojo.ProductSkuPojo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * ????
 */
@RestController
@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
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
        ShoppingNumberManage manage = new ShoppingNumberManage(jedisPool, SystemCacheManage.UNLOCK_REDIS_LUA,"DD","PP",11);
        SystemResult dd = manage.getNumberByRedisKey("DD", 123);

        return null;
    }


    /**
     * ???????????????·
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
        // ?????? ????Ψ?Token
        StringBuffer sb = new StringBuffer();
        sb.append(UUID.randomUUID().toString().replaceAll("-", "").substring(22));
        sb.append("-" + new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
        // ?????????????
        Jedis jedis = jedisPool.getResource();
        UserManageUtil userManageUtil = new UserManageUtil(jedisPool);
        // ????redis
        SystemResult refresh = userManageUtil.refresh(member, sb.toString());
        // д??Cookie
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
        String srcipt = FileUtils.readFileToString(ResourceUtils.getFile("classpath:unlock.lua"), "utf-8");
        ShoppingNumberManage numberManage = new ShoppingNumberManage(jedisPool, srcipt, PRODUCT_NUMBER_REDIS_KEY, "SP", 11);
        SystemResult systemResult = numberManage.addProductNumber(100000 );


        return null;
    }

    public static void main(String[] args) throws Exception {
        K2ProductWithBLOBs k2ProductWithBLOBs = new K2ProductWithBLOBs();
        k2ProductWithBLOBs.setProductName("DW手表");
        k2ProductWithBLOBs.setProductBrandId(1);
        k2ProductWithBLOBs.setProductOneCategoryId(1);
        k2ProductWithBLOBs.setProductTwoCategoryId(2);
        k2ProductWithBLOBs.setProductBazaarPrice(new BigDecimal(3000.32));
        k2ProductWithBLOBs.setProductSystemPrice(new BigDecimal(2000.00));
        k2ProductWithBLOBs.setProductPoints("DW手表好看实用");
        k2ProductWithBLOBs.setProductOrderRule(2);
        k2ProductWithBLOBs.setProductUnit("个");
        k2ProductWithBLOBs.setProductSketchId(1);
        k2ProductWithBLOBs.setProductIfSupport(1);
        k2ProductWithBLOBs.setProductSupportDay(30);
        k2ProductWithBLOBs.setProductImage("adasd,13123");
        k2ProductWithBLOBs.setProductImageDescribe("luqiqi,asdasd,qeqwe,dcada");
        System.out.println(JsonUtils.objectToJson(k2ProductWithBLOBs));
        List<ProductSkuPojo> dtos = new ArrayList<>();
        ProductSkuPojo dto = new ProductSkuPojo();
        dto.setSpuOrder("1");
        dto.setSkuKey("颜色");
        dto.setSkuValue("红色,黄色,绿色");
        dto.setSystemDef(false);
        ProductSkuPojo dto2 = new ProductSkuPojo();
        dto2.setSpuOrder("2");
        dto2.setSkuKey("内存");
        dto2.setSkuValue("16GB,32GB,64GB");
        dto2.setSystemDef(false);
        ProductSkuPojo dto3 = new ProductSkuPojo();
        dto3.setSpuOrder("3");
        dto3.setSkuKey("版本");
        dto3.setSkuValue("M6,M8,Iphone10");
        dto3.setSystemDef(false);
        dtos.add(dto);
        dtos.add(dto2);
        dtos.add(dto3);
        System.out.println(JsonUtils.objectToJson(dtos));

    }


    /**
     * ??????reids?е???
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
