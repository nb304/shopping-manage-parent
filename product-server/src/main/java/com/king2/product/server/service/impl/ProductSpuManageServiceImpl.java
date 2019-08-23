package com.king2.product.server.service.impl;

import com.king2.commons.mapper.K2ProductSpuMapper;
import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2ProductSpu;
import com.king2.commons.pojo.K2ProductSpuExample;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.ProductSpuAppoint;
import com.king2.product.server.enmu.ProductSpuEnum;
import com.king2.product.server.mapper.ProductSpuMapper;
import com.king2.product.server.service.ProductSpuManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/*=======================================================
	说明:    商品SPU管理Service实现类

	作者		时间					注释
  	俞烨		2019.08.20   			创建
=======================================================*/
@Service
public class ProductSpuManageServiceImpl implements ProductSpuManageService {

    // 注入商品SPUMapper
    @Autowired
    private K2ProductSpuMapper k2ProductSpuMapper;

    // 注入本地的商品SPUMapper
    @Autowired
    private ProductSpuMapper productSpuMapper;

    /**
     * -----------------------------------------------------
     * 功能:  查询商品的SPU操作
     * <p>
     * 参数:
     * productId        String          商品id
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult getSpuByPId(Integer productId) {

        List<K2ProductSpu> spuByProductId = productSpuMapper.getSpuByProductId(productId);
        return new SystemResult(spuByProductId);
    }

    /**
     * -----------------------------------------------------
     * 功能:  删除商品的SPU信息
     * <p>
     * 参数:
     * spuId        String          商品的SPUid
     * k2Member     K2Member        操作的用户信息
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult delSpuById(Integer spuId, K2Member k2Member) {

        // 创建对象
        K2ProductSpu spu = new K2ProductSpu();
        spu.setProductSpuId(spuId);
        spu.setProductSpuState(ProductSpuEnum.DEL.getValue());
        // 逻辑删除商品的SPU信息
        k2ProductSpuMapper.updateByPrimaryKeySelective(spu);
        return new SystemResult("ok");
    }

    /**
     * -----------------------------------------------------
     * 功能:  恢复SPU的信息
     * <p>
     * 参数:
     * spuId        String          商品的SPUid
     * k2Member     K2Member        操作的用户信息
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult recoverNormal(Integer spuId, K2Member k2Member) {

        // 创建对象
        K2ProductSpu spu = new K2ProductSpu();
        spu.setProductSpuId(spuId);
        spu.setProductSpuState(ProductSpuEnum.SYZ.getValue());
        // 恢复SPU的信息
        k2ProductSpuMapper.updateByPrimaryKeySelective(spu);
        return new SystemResult("ok");
    }

    /**
     * -----------------------------------------------------
     * 功能:  批量注销商品的SPU信息
     * <p>
     * 参数:
     * spuIds        String         商品的SPUIds
     * k2Member     K2Member        操作的用户信息
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult batchCancelSpu(String spuIds, K2Member k2Member) {

        // 创建需要批量注销的商品SPU信息
        List<Integer> cancelSpuIds = new ArrayList<>();
        String[] spuSplit = spuIds.split(",");
        // 遍历集合
        for (int i = 0; i < spuSplit.length; i++) {
            // 判断商品SPU的id时候正确
            if (StringUtils.isEmpty(spuSplit[i]) || !spuSplit[i].matches("[0-9]{1,}")) {
                // 商品SPUid有问题
                return new SystemResult(100, "商品SPUid错误,请刷新页面重试", null);
            }
            cancelSpuIds.add(Integer.parseInt(spuSplit[i]));
        }

        // 遍历完成 创建条件
        if (!CollectionUtils.isEmpty(cancelSpuIds)) {
            K2ProductSpu spu = new K2ProductSpu();
            spu.setProductSpuState(ProductSpuEnum.ZX.getValue());
            K2ProductSpuExample example = new K2ProductSpuExample();
            example.createCriteria().andProductSpuIdIn(cancelSpuIds);
            // 修改数据
            k2ProductSpuMapper.updateByExampleSelective(spu, example);
            return new SystemResult("ok");
        }
        return new SystemResult(100, "请勾选你要注销的商品SPU信息", null);
    }

    /**
     * -----------------------------------------------------
     * 功能:  修改商品参数的信息
     * <p>
     * 参数:
     * spuKey        String         商品的SPU的名称
     * skuValue      String         商品的参数值
     * productSpuId  String         商品参数的Id
     * k2Member     K2Member        操作的用户信息
     * order        Integer         排序
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult editSpuInfo(String spuKey, String skuValue, Integer order, Integer productSpuId, K2Member k2Member) {

        // 创建对象
        K2ProductSpu spu = new K2ProductSpu();
        spu.setProductSpuName(spuKey);
        spu.setProductSpuValue(skuValue);
        spu.setProductSpuId(productSpuId);
        spu.setProductSpuOrder(order);
        // 修改商品信息
        k2ProductSpuMapper.updateByPrimaryKeySelective(spu);
        return new SystemResult("ok");
    }


    /**
     * /**
     * -----------------------------------------------------
     * 功能:  添加商品的SPU信息
     * <p>
     * 参数:
     * productSpuJson         String            商品的SPU信息
     * productId              Integer           商品的id
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult addProductSpu(String productSpuJson, Integer productId, K2Member k2Member) {

        // 查询最大值
        Integer maxOrder = productSpuMapper.getMaxOrder(productId);

        // 校验商品的SPU是否正确
        SystemResult result = ProductSpuAppoint.checkProductSpuJsonInfo(productSpuJson, productId, k2Member, maxOrder);
        if (result.getStatus() != 200) return result;

        // 校验数据成功,添加spu
        productSpuMapper.batchInsertProductSpu((List<K2ProductSpu>) result.getData());
        return result;
    }
}
