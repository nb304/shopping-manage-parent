package com.king2.product.server.init;

import cn.hutool.core.date.DateUtil;
import com.king2.commons.getnumber.ShoppingNumberManage;
import com.king2.commons.getnumber.ShoppingNumberPojo;
import com.king2.commons.lock.Lock;
import com.king2.commons.lock.impl.DfsRedisLock;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.FileUtil;
import com.king2.product.server.cache.SystemCacheManage;
import com.king2.product.server.log.ProductServerLog;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Date;

/*=======================================================
	˵��:    ��Ʒ����ģ��ĳ�ʼ��

	����		ʱ��					ע��
  	����		2019.08.08   			����
=======================================================*/
@Component
public class ProductManageApplicationRun implements ApplicationRunner {

    // ע����Ʒ��Ŵ���redis�е�key
    @Value("${PRODUCT_NUMBER_REDIS_KEY}")
    private String PRODUCT_NUMBER_REDIS_KEY;
    // ע��Jedis���ӳ�
    @Autowired
    private JedisPool jedisPool;
    // ע��Զ�̵���ģ��
    @Autowired
    private RestTemplate restTemplate;
    // ע�뻺���������ַ
    @Value("${CACHE_SERVER_URL}")
    private String CACHE_SERVER_URL;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // ������־��Ϣ
        ProductServerLog.systemInitLog();

        // ��ʼ��reids�����ű�
        writeRedisLua();

        // ��ʼ����Ʒ���
        initProductNumber(jedisPool, PRODUCT_NUMBER_REDIS_KEY, restTemplate, CACHE_SERVER_URL);

        // ������ʱ�����Ʒ��ŵĹ���
        timerAddProductNumber(20, jedisPool, PRODUCT_NUMBER_REDIS_KEY, restTemplate, CACHE_SERVER_URL);
    }


    /**
     * �����ѯ�Ƿ���Ҫ�����Ʒ���
     *
     * @param sleepTime ÿ������
     * @param jedisPool jedisPool���ӳ�
     * @param key       redis��key
     */
    public static void timerAddProductNumber(int sleepTime, JedisPool jedisPool, String key, RestTemplate restTemplate, String URL) {
        // ����һ���µ��߳�
        new Thread(() -> {
            while (true) {
                try {
                    // ���������Ʒ��Ϣ
                    initProductNumber(jedisPool, key, restTemplate, URL);
                    // sleep���ó�cpu����Դ ���Բ��ú�����Դ�˷�
                    // sleep���ó�cpu����Դ ���ǲ����ó�����Դ
                    // wait ���ó�cpu����Դ Ҳ���ó�����Դ
                    Thread.sleep(sleepTime * 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }


    /**
     * ��ʼ��1000����Ʒ���
     *
     * @param jedisPool                Jedis���ӳ�
     * @param PRODUCT_NUMBER_REDIS_KEY Redis�е�key
     * @throws Exception
     */
    public static void initProductNumber(JedisPool jedisPool, String PRODUCT_NUMBER_REDIS_KEY, RestTemplate restTemplate, String servletUrl) throws Exception {
        Jedis jedis = null;
        Lock lock = null;
        try {
            jedis = jedisPool.getResource();
            lock = new DfsRedisLock(PRODUCT_NUMBER_REDIS_KEY + "_LOCK", 10, jedis);
            // ������
            lock.lock();
            // ��ȡ��Ʒ��ŵ�JSON��
            String productNumberJson = jedis.get(PRODUCT_NUMBER_REDIS_KEY);
            if (StringUtils.isEmpty(productNumberJson)) {
                // �Ѿ�û��JSON���� ���1000��JSON��
                ShoppingNumberPojo sp = new ShoppingNumberPojo(jedisPool, SystemCacheManage.UNLOCK_REDIS_LUA, PRODUCT_NUMBER_REDIS_KEY, "SP", 11, restTemplate, servletUrl);
                // ��ȡ��Ʒ��Ϣ�ж��Ƿ�Ϊ��
                ShoppingNumberManage numberManage = new ShoppingNumberManage(sp, sp.NUMBER_TYPE_PRODUCT);
                SystemResult systemResult = numberManage.addProductNumberGotoRedis(1000);
                if (systemResult.getStatus() != 200) {
                    // ������Ʒ���ʧ�� д����־
                    FileUtil.fileWrite(ProductServerLog.PRODUCT_SYSTEM_INFO_FILE,
                            "��ų�ʼ��ʧ��,����Redis�����Ƿ���������---ʱ��:" + DateUtil.formatDateTime(new Date()),
                            true);
                } else {
                    FileUtil.fileWrite(ProductServerLog.PRODUCT_SYSTEM_INFO_FILE,
                            "��ų�ʼ���ɹ�,��ʼ����1000�������Ϣ---ʱ��:" + DateUtil.formatDateTime(new Date()),
                            true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // ����ͻ���
            if (jedis != null) jedis.close();
            if (lock != null) lock.unlock(SystemCacheManage.UNLOCK_REDIS_LUA);
        }

    }


    /**
     * ��ʼ�������ű�
     *
     * @throws Exception
     */
    public static void writeRedisLua() throws Exception {

        // ��ȡϵͳ�������
        SystemCacheManage instance = SystemCacheManage.getInstance();
        // ��ȡlua�ű��洢�����������
        String luaScript = FileUtils.readFileToString(ResourceUtils.getFile("classpath:unlock.lua"), "utf-8");
        // �ж�lua�ű��Ƿ�Ϊ��
        if (StringUtils.isEmpty(luaScript)) {
            // д����־��Ϣ
            FileUtil.fileWrite(ProductServerLog.PRODUCT_SYSTEM_INFO_FILE,
                    "����lua�ű�ע��ʧ��,�����ļ��Ƿ����---ʱ��:" + DateUtil.formatDateTime(new Date()),
                    true);
        }
        instance.UNLOCK_REDIS_LUA = luaScript;
    }
}
