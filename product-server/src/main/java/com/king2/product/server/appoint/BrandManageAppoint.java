package com.king2.product.server.appoint;

import com.king2.commons.pojo.K2CurrentDayHandleSqlSize;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.cache.CurrentDayHandleSqlSizeCache;
import com.king2.product.server.dto.LockPojo;
import com.king2.product.server.enmu.CurrentDayHandleSqlSizeEnum;
import com.king2.product.server.locks.ProductQueueLockFactoryTypeEnum;
import com.king2.product.server.locks.ProductQueueLockFactory;

import java.util.concurrent.ConcurrentHashMap;

/*=======================================================
	???:    ???????????

	????		???					???
  	????		2019.08.25   			????
=======================================================*/
public class BrandManageAppoint {


    /**
     * ???????????????????????
     *
     * @return
     */
    public static SystemResult checkIfEditBrand(String storeId) {

        // ????????
        LockPojo lockPojo = ProductQueueLockFactory.getInstance().getLockMaps().get(ProductQueueLockFactoryTypeEnum.DEFAULT_FUNCTION_MYSQL_SIZE_KEY.getValue());
        // ??????
        lockPojo.getLock().lock();
        try {
            // ????????????????????
            ConcurrentHashMap<String, K2CurrentDayHandleSqlSize> dataMaps = CurrentDayHandleSqlSizeCache.getInstance().getDataMaps();
            // ????????
            if (!dataMaps.containsKey(CurrentDayHandleSqlSizeEnum.EBRAND.getKey() + "_" + storeId)) {
                K2CurrentDayHandleSqlSize size = new K2CurrentDayHandleSqlSize();
                size.setEditBrandSize(0);
                // ????§Õ??????
                dataMaps.put(CurrentDayHandleSqlSizeEnum.EBRAND.getKey() + "_" + storeId, size);
                return new SystemResult("ok");
            }
            K2CurrentDayHandleSqlSize k2CurrentDayHandleSqlSize = dataMaps.get(CurrentDayHandleSqlSizeEnum.EBRAND.getKey() + "_" + storeId);
            if (k2CurrentDayHandleSqlSize == null) {
                K2CurrentDayHandleSqlSize size = new K2CurrentDayHandleSqlSize();
                size.setEditBrandSize(0);
                // ????§Õ??????
                dataMaps.put(CurrentDayHandleSqlSizeEnum.EBRAND.getKey() + "_" + storeId, size);
                return new SystemResult("ok");
            } else if (k2CurrentDayHandleSqlSize.getEditBrandSize() >= CurrentDayHandleSqlSizeEnum.EBRAND.getValue()) {
                return new SystemResult(202, "?????????????????????,????????????:" + CurrentDayHandleSqlSizeEnum.EBRAND.getValue() + "??");
            } else {
                // §³??????????+1 ????§Õ??????
                k2CurrentDayHandleSqlSize.setEditBrandSize(k2CurrentDayHandleSqlSize.getEditBrandSize() + 1);
                // ????§Õ??????
                dataMaps.put(CurrentDayHandleSqlSizeEnum.EBRAND.getKey() + "_" + storeId, k2CurrentDayHandleSqlSize);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // ????
            lockPojo.getLock().unlock();
        }

        return new SystemResult("ok");
    }
}
