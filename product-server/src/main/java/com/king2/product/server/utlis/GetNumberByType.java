package com.king2.product.server.utlis;

import com.king2.commons.getnumber.ShoppingNumberManage;
import com.king2.commons.getnumber.ShoppingNumberPojo;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.GetErrorInfo;
import com.king2.product.server.cache.SystemCacheManage;
import com.king2.product.server.cache.SystemIndexCacheManage;
import com.king2.product.server.dto.LockPojo;
import com.king2.product.server.enmu.ProductQueueLockFactoryTypeEnum;
import com.king2.product.server.locks.ProductQueueLockFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.JedisPool;

import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * �������ͻ�ȡ���
 */
@Component
@Scope(value = "prototype")
public class GetNumberByType {

    // �������
    public static String TYPE = "NB";
    // ��ų���
    public static Integer SIZE = 11;
    // ǰ׺
    public static String PX = "NB";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JedisPool jedisPool;

    @Value("${CACHE_SERVER_URL}")
    private String CACHE_SERVER_URL;

    // ��־
    private static final Logger LOGGER = LoggerFactory.getLogger(GetNumberByType.class);

    /**
     * ��ȡԶ�̵�reids�еı����Ϣ
     *
     * @param type redis�е�key
     * @param size ����
     * @param px   ǰ׺
     * @return
     * @throws Exception
     */
    public SystemResult getNumber(String type, Integer size, String px) throws Exception {

        // ����ϵͳ��Ź���
        ShoppingNumberPojo pojo = new ShoppingNumberPojo(jedisPool, SystemCacheManage.UNLOCK_REDIS_LUA, type, px, size, restTemplate, CACHE_SERVER_URL);
        ShoppingNumberManage shoppingNumberManage = new ShoppingNumberManage(pojo, type);
        SystemResult numberByRedisKey = shoppingNumberManage.getNumberByRedisKey(type, 10);
        return numberByRedisKey;
    }

    /**
     * ��ȡһ���û���Ϣ��Ψһid
     *
     * @return
     */
    public static SystemResult getMessageId() {
        // ��ȡ����Դ
        LockPojo lockPojo = ProductQueueLockFactory.getInstance().getLockMaps().get(ProductQueueLockFactoryTypeEnum.MESSAGE_ID_ONLY_KEY.getValue());
        // ������
        lockPojo.getLock().lock();
        try {
            // ��ȡ��������
            ConcurrentLinkedQueue<Integer> idQueue =
                    (ConcurrentLinkedQueue<Integer>) SystemIndexCacheManage.getInstance().getSystemIndexHashMapData().get(SystemIndexCacheManage.MESSAGE_NUMBER_ONLY_KEY);
            // �鿴�������Ƿ����id��Ϣ
            if (idQueue == null || idQueue.isEmpty()) {
                idQueue = new ConcurrentLinkedQueue<>();
                // ˵��û�ж�����Ϣ ��Ҫ��������
                for (int i = 0; i < 1000; i++) {
                    String s = new Date().getTime() + i + "";
                    String substring = s.substring(s.length() - 8);
                    idQueue.add(Integer.parseInt(substring));
                }

            }

            // ȡ��һ�������Ϣ
            Integer poll = idQueue.poll();
            // ����Ϣ���´��뻺������
            SystemIndexCacheManage.getInstance().getSystemIndexHashMapData().put
                    (SystemIndexCacheManage.MESSAGE_NUMBER_ONLY_KEY, idQueue);
            // ��������
            return new SystemResult(poll);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("��ϢΨһid��ȡ�쳣:" + e);
            LOGGER.error(GetErrorInfo.getTrace(e));
            String s = new Date().getTime() + "";
            return new SystemResult(Integer.parseInt(s.substring(s.length() - 8)));
        } finally {
            lockPojo.getLock().unlock();
        }

    }
}
