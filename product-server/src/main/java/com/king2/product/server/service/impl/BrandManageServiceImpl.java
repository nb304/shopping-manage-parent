package com.king2.product.server.service.impl;

import com.king2.commons.mapper.K2ProductBrandMapper;
import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.pojo.K2ProductBrand;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.UserMessageAppoint;
import com.king2.product.server.dto.BrandIndexManageDto;
import com.king2.product.server.enmu.K2ProductBrandEnmu;
import com.king2.product.server.mapper.BrandManageMapper;
import com.king2.product.server.service.BrandManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;


/*=======================================================
	说明:    商品品牌管理Service实现类

	作者		时间					注释
  	俞烨		2019.08.25   			创建
=======================================================*/
@Service
public class BrandManageServiceImpl implements BrandManageService {

    // 注入商品品牌Mapper
    @Autowired
    private BrandManageMapper brandManageMapper;

    // 注入远程Mapper
    @Autowired
    private K2ProductBrandMapper brandMapper;

    // 注入暂无图片的路径
    @Value("${PRODUCT_IMAGE_NOT_DEFINITION}")
    private String PRODUCT_IMAGE_NOT_DEFINITION;


    /**
     * -----------------------------------------------------
     * 功能:  显示商品品牌的首页
     * <p>
     * 参数:
     * k2MemberAndElseInfo         K2MemberAndElseInfo        操作的用户信息
     * dto              BrandIndexManageDto 分页数据
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult index(K2MemberAndElseInfo k2MemberAndElseInfo, BrandIndexManageDto dto) {


        // 根据店铺查询该店铺下面的品牌信息
        Integer totalSize = brandManageMapper.selectCount(Integer.parseInt(k2MemberAndElseInfo.getK2Member().getRetain1()),
                StringUtils.isEmpty(dto.getBrandName()) ? null : "%" + dto.getBrandName().trim().replaceAll(" ", "") + "%");
        if (dto == null) dto = new BrandIndexManageDto();

        // 设置值
        dto.setTotalSize(totalSize);

        // 求出总页数
        int totalPage = (totalSize + dto.getCurrentSize() - 1) / dto.getCurrentSize();
        dto.setTotlaPage(totalPage);

        // 查看当前页数是否大于总页数
        if (dto.getCurrentPage() > totalPage) dto.setCurrentPage(totalPage);

        // 计算出索引值
        int index = (dto.getCurrentPage() - 1) * dto.getCurrentSize();


        // 查询数据
        List<K2ProductBrand> brands = brandManageMapper.getBrands(Integer.parseInt(k2MemberAndElseInfo.getK2Member().getRetain1()),
                index, dto.getCurrentSize(), StringUtils.isEmpty(dto.getBrandName()) ? null : "%" +
                        dto.getBrandName().trim().replaceAll(" ", "") + "%");
        brands.forEach((n) -> {
            n.setCreateTimeStr(UserMessageAppoint.sdf.format(n.getBrandCreateTime()));
            n.setUpdateTimeStr(UserMessageAppoint.sdf.format(n.getBrandUpdateTime()));
        });
        dto.setBrandDatas(brands);

        return new SystemResult(dto);
    }

    /**
     * -----------------------------------------------------
     * 功能:  添加品牌
     * <p>
     * 参数:
     * brandName                String         品牌名称
     * k2MemberAndElseInfo      K2MemberAndElseInfo 操作的用户信息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult addBrand(String brandName, K2MemberAndElseInfo k2MemberAndElseInfo) {

        // 创建品牌对象
        K2ProductBrand k2ProductBrand = new K2ProductBrand();
        // 补全数据
        k2ProductBrand.setBrandName(brandName);
        // 获取一个唯一编号
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        uuid = uuid.substring(uuid.length() - 11);
        k2ProductBrand.setBrandNumber(uuid);
        k2ProductBrand.setBrandImage(PRODUCT_IMAGE_NOT_DEFINITION);
        k2ProductBrand.setBrandCreateUserid(k2MemberAndElseInfo.getK2Member().getMemberId());
        k2ProductBrand.setBrandCreateTime(new Date());
        k2ProductBrand.setBrandCreateUsername(k2MemberAndElseInfo.getK2Member().getMemberAccount());
        k2ProductBrand.setBrandUpdateUserid(k2MemberAndElseInfo.getK2Member().getMemberId());
        k2ProductBrand.setBrandUpdateTime(new Date());
        k2ProductBrand.setBrandUpdateUsername(k2MemberAndElseInfo.getK2Member().getMemberAccount());
        k2ProductBrand.setBrandStoreId(Integer.parseInt(k2MemberAndElseInfo.getK2Member().getRetain1()));
        k2ProductBrand.setBrandState(K2ProductBrandEnmu.ZC.getValue());

        // 添加品牌信息
        brandMapper.insert(k2ProductBrand);

        return new SystemResult(k2ProductBrand);
    }
}
