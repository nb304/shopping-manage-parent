package com.king2.product.server.cache;

import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.JsonUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/*=======================================================
	说明:    商品管理的访问类

	作者		时间					注释
  	俞烨		2019.08.09   			创建
=======================================================*/
@RestController
public class NumberCacheManage {

    /**
     * -----------------------------------------------------
     * 功能:  添加缓存信息
     * <p>
     * 参数:
     * queueJson        String          编号的JSON
     * type             String          编号的类型
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @PostMapping("/cache/number/add")
    public SystemResult add(@NotBlank(message = "队列的JSON数据不能为空") String queueJson,
                            @NotBlank(message = "type类型不能为空") String type) throws Exception {

        // 创建缓存对象
        SystemCacheManage systemCacheManage = SystemCacheManage.getInstance();

        synchronized (systemCacheManage) {
            // 校验type
            if (!type.equals(systemCacheManage.NUMBER_TYPE_ORDER) && !type.equals(systemCacheManage.NUMBER_TYPE_PRODUCT)) {
                return new SystemResult(100, "类型筛选错误", null);
            }

            // 解析JSON数据
            ConcurrentLinkedQueue<String> concurrentLinkedQueue = JsonUtils.jsonToPojo(queueJson, ConcurrentLinkedQueue.class);
            // 将JSON数据存到缓存对象中去
            Map<String, ConcurrentLinkedQueue<String>> queueMap = systemCacheManage.getQueueMap();
            queueMap.put(type, concurrentLinkedQueue);
        }
        return new SystemResult("添加成功");
    }

    /**
     * -----------------------------------------------------
     * 功能:  拿出缓存信息
     * <p>
     * 参数:
     * type             String          编号的类型
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @PostMapping("/cache/number/get")
    public SystemResult get(@NotBlank(message = "type类型不能为空") String type) {

        // 创建缓存对象
        SystemCacheManage systemCacheManage = SystemCacheManage.getInstance();

        synchronized (systemCacheManage) {
            // 校验type
            if (!type.equals(systemCacheManage.NUMBER_TYPE_ORDER) && !type.equals(systemCacheManage.NUMBER_TYPE_PRODUCT)) {
                return new SystemResult(100, "类型筛选错误", null);
            }

            // 取出数据
            ConcurrentLinkedQueue<String> queue = systemCacheManage.getQueueMap().get(type);
            if (queue == null) return new SystemResult(205, "编号队列已经被取空", null);
            String data = queue.poll();
            // 重新写入缓存数据中
            systemCacheManage.getQueueMap().put(type, queue);
            // 将数据返回
            return new SystemResult(data);
        }
    }
}
