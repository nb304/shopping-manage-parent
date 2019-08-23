package com.king2.product.server.appoint;

import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2ProductSpu;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.JsonUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/*=======================================================
	说明:    商品SPU委派类

	作者		时间					注释
  	俞烨		2019.08.10   			创建
=======================================================*/
@Component
public class ProductSpuAppoint {


    /**
     * -----------------------------------------------------
     * 功能:  校验SPU信息是否正确 并返回SPU的集合数据
     * <p>
     * 参数:
     * productSpuJson         String            商品的SPU信息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    public static SystemResult checkProductSpuJsonInfo(String productSpuJson, Integer productId, K2Member k2Member, Integer maxOrder) {
        // 校验商品SPU信息是否正确
        if (StringUtils.isEmpty(productSpuJson)) return new SystemResult(100, "商品描述信息不能为空", null);

        // 转成数据
        List<K2ProductSpu> lists = null;
        try {
            lists = JsonUtils.jsonToList(productSpuJson, K2ProductSpu.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new SystemResult(100, "商品描述信息格式错误", null);
        }
        if (CollectionUtils.isEmpty(lists)) return new SystemResult(100, "请填写商品参数", null);
        // 校验商品SPU信息是否正确
        for (int i = 0; i < lists.size(); i++) {
            K2ProductSpu productSpu = lists.get(i);
            // 校验数据是否正确
            if (productSpu == null) return new SystemResult(100, "商品的参数信息不能为空", null);
            if (StringUtils.isEmpty(productSpu.getProductSpuName()) || productSpu.getProductSpuName().length() > 20) {
                return new SystemResult(100, "描述参数的名称字符长度为1-20个", null);
            } else if (StringUtils.isEmpty(productSpu.getProductSpuValue()) || productSpu.getProductSpuValue().length() > 100) {
                return new SystemResult(100, "商品参数的值字符长度为1-100个", null);
            } else if (productSpu.getProductSpuOrder() != null && productSpu.getProductSpuOrder() > 9999999) {
                return new SystemResult(100, "商品参数的排序过长", null);
            }

            productSpu.setProductSpuOrder(productSpu.getProductSpuOrder() == null ? maxOrder == null ? 0 : maxOrder + (i + 1) : productSpu.getProductSpuOrder());
            productSpu.setBelongProductId(productId);
            productSpu.setCreateTime(new Date());
            productSpu.setProductSpuState(1);
        }
        return new SystemResult(lists);

    }
}
