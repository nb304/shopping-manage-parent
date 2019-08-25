package com.king2.product.server.service.impl;

import com.king2.commons.mapper.K2ProductMapper;
import com.king2.commons.mapper.K2ProductSkuPriceandkcMapper;
import com.king2.commons.pojo.K2ProductSkuPriceandkc;
import com.king2.commons.pojo.K2ProductSkuPriceandkcExample;
import com.king2.commons.pojo.K2ProductWithBLOBs;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.ProductBasicsAppoint;
import com.king2.product.server.appoint.ProductSkuValueKcAppoint;
import com.king2.product.server.mapper.ProductManageMapper;
import com.king2.product.server.service.ProductSkuManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*=======================================================
	说明:    商品SKU管理Service实现类

	作者		时间					注释
  	俞烨		2019.08.21   			创建
=======================================================*/
@Service
public class ProductSkuManageServiceImpl implements ProductSkuManageService {

    // 注入远程的商品库存Mapper
    @Autowired
    private K2ProductSkuPriceandkcMapper k2ProductSkuPriceandkcMapper;
    // 注入远程的商品Mapper
    @Autowired
    private K2ProductMapper k2ProductMapper;

    /**
     * -----------------------------------------------------
     * 功能:   根据商品id获取该商品的SKU信息集合
     * <p>
     * 参数:
     * productId          Integer         商品ID
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult getSkuByProductId(Integer productId) {

        // 根据商品id查询商品的SKU信息
        K2ProductSkuPriceandkcExample example = new K2ProductSkuPriceandkcExample();
        example.createCriteria().andBelongProductIdEqualTo(productId);
        List<K2ProductSkuPriceandkc> k2ProductSkuPriceandkcs = k2ProductSkuPriceandkcMapper.selectByExampleWithBLOBs(example);
        // 将数据返回给Controller
        return new SystemResult(k2ProductSkuPriceandkcs);
    }

    /**
     * -----------------------------------------------------
     * 功能:   修改商品SKU信息
     * <p>
     * 参数:
     * skuKcInfo          String         商品SKU的信息
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult editSkuInfo(String skuKcInfo) {

        // 校验修改的商品SKU库存信息是否正确
        SystemResult result = ProductSkuValueKcAppoint.checkEditProductSkuKcInfo(skuKcInfo);
        if (result.getStatus() != 200) return result;

        // 校验成功 取出值
        List<K2ProductSkuPriceandkc> kcs = (List<K2ProductSkuPriceandkc>) result.getData();
        // 取出一个商品信息的id
        Integer productId = kcs.get(0).getBelongProductId();
        // 将不需要修改的值取消，害怕有些人越过前端
        kcs.forEach((n) -> {
            n.clearValue();
            k2ProductSkuPriceandkcMapper.updateByPrimaryKeySelective(n);
        });

        // 修改成功 往队列写入信息
        // 查询一次数据库 取出信息
        K2ProductWithBLOBs k2ProductWithBLOBs = k2ProductMapper.selectByPrimaryKey(productId);
        ProductBasicsAppoint.addSynchronizedProductGotoCache(k2ProductWithBLOBs);

        return new SystemResult("ok");
    }
}
