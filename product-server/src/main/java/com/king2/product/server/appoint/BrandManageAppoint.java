package com.king2.product.server.appoint;

import com.king2.commons.pojo.K2CurrentDayHandleSqlSize;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.cache.CurrentDayHandleSqlSizeCache;
import com.king2.product.server.dto.LockPojo;
import com.king2.product.server.enmu.CurrentDayHandleSqlSizeEnum;
import com.king2.product.server.enmu.ProductQueueLockFactoryTypeEnum;
import com.king2.product.server.locks.ProductQueueLockFactory;

import java.util.concurrent.ConcurrentHashMap;

/*=======================================================
	说明:    商品品牌委托类

	作者		时间					注释
  	俞烨		2019.08.25   			创建
=======================================================*/
public class BrandManageAppoint {


    /**
     * 检查是否可以修改商品品牌的数据
     *
     * @return
     */
    public static SystemResult checkIfEditBrand(String storeId) {

        // 获取锁资源
        LockPojo lockPojo = ProductQueueLockFactory.getInstance().getLockMaps().get(ProductQueueLockFactoryTypeEnum.DEFAULT_FUNCTION_MYSQL_SIZE_KEY.getValue());
        // 开启锁
        lockPojo.getLock().lock();
        try {
            // 获取操作次数的数据信息
            ConcurrentHashMap<String, K2CurrentDayHandleSqlSize> dataMaps = CurrentDayHandleSqlSizeCache.getInstance().getDataMaps();
            // 查看是否包含
            if (!dataMaps.containsKey(CurrentDayHandleSqlSizeEnum.EBRAND.getKey() + "_" + storeId)) {
                K2CurrentDayHandleSqlSize size = new K2CurrentDayHandleSqlSize();
                size.setEditBrandSize(0);
                // 重新写入缓存中
                dataMaps.put(CurrentDayHandleSqlSizeEnum.EBRAND.getKey() + "_" + storeId, size);
                return new SystemResult("ok");
            }
            K2CurrentDayHandleSqlSize k2CurrentDayHandleSqlSize = dataMaps.get(CurrentDayHandleSqlSizeEnum.EBRAND.getKey() + "_" + storeId);
            if (k2CurrentDayHandleSqlSize == null) {
                K2CurrentDayHandleSqlSize size = new K2CurrentDayHandleSqlSize();
                size.setEditBrandSize(0);
                // 重新写入缓存中
                dataMaps.put(CurrentDayHandleSqlSizeEnum.EBRAND.getKey() + "_" + storeId, size);
                return new SystemResult("ok");
            } else if (k2CurrentDayHandleSqlSize.getEditBrandSize() >= CurrentDayHandleSqlSizeEnum.EBRAND.getValue()) {
                return new SystemResult(202, "您当天修改商品的次数上限,每天最多可以修改:" + CurrentDayHandleSqlSizeEnum.EBRAND.getValue() + "次");
            } else {
                // 小于就取出数据+1 重新写入缓存中
                k2CurrentDayHandleSqlSize.setEditBrandSize(k2CurrentDayHandleSqlSize.getEditBrandSize() + 1);
                // 重新写入缓存中
                dataMaps.put(CurrentDayHandleSqlSizeEnum.EBRAND.getKey() + "_" + storeId, k2CurrentDayHandleSqlSize);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 解锁
            lockPojo.getLock().unlock();
        }

        return new SystemResult("ok");
    }
}
