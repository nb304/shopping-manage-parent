package com.king2.product.server.locks;

import com.king2.product.server.dto.LockPojo;
import com.king2.product.server.enmu.ProductQueueLockFactoryTypeEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/*=======================================================
	˵��:   ��Ʒģ���������

	����		ʱ��					ע��
  	����		2019.08.14   			����
=======================================================*/
public class ProductQueueLockFactory {

    // ����ģʽ
    private ProductQueueLockFactory() {
    }

    private static ProductQueueLockFactory productInfoQueueLock = new ProductQueueLockFactory();

    public static ProductQueueLockFactory getInstance() {
        // ��ʼ����
        refreshLock();
        return productInfoQueueLock;
    }

    /**
     * ���ļ���,��һ���̰߳�ȫ��HashMap
     * key����һ���������� ����ͨ��key��ȡ���ǰѵ�������
     * value��һ������ʵ�� ��װ���������condition����
     * condition�����þ͸�synchronized��wait��notifyЧ��һ��
     */
    private static ConcurrentHashMap<String, LockPojo> lockMaps = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, LockPojo> getLockMaps() {
        return lockMaps;
    }


    // ��Ʒģ�����������ͼ���
    private static List<String> keys = new ArrayList<>();

    // �ṩGet���� �����ñ���Ҳ����������Ϣ
    public List<String> getKeys() {
        return keys;
    }

    // ˢ����
    private static void refreshLock() {
        // ˫��У��
        if (lockMaps.isEmpty()) {
            synchronized (ProductQueueLockFactory.class) {
                if (lockMaps.isEmpty()) {

                    // ��̬�������������Ϣ
                    for (int i = 0; i < ProductQueueLockFactoryTypeEnum.values().length; i++) {
                        keys.add(ProductQueueLockFactoryTypeEnum.values()[i].getValue());
                    }
                    for (int i = 0; i < keys.size(); i++) {
                        // ��̬����������
                        LockPojo lockPojo = new LockPojo();
                        lockPojo.setLock(new ReentrantLock());
                        lockMaps.put(keys.get(i), lockPojo);
                    }
                }
            }
        }
    }
}

