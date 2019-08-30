package com.king2.product.server.service.impl;

import com.king2.commons.mapper.K2CurrentDayHandleSqlSizeMapper;
import com.king2.commons.mapper.K2MessageMapper;
import com.king2.commons.mapper.K2ProductBrandMapper;
import com.king2.commons.mapper.K2ProductMapper;
import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.pojo.K2ProductBrand;
import com.king2.commons.pojo.K2ProductExample;
import com.king2.commons.pojo.K2ProductWithBLOBs;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.GetErrorInfo;
import com.king2.commons.utils.MinioUtil;
import com.king2.product.server.appoint.BrandManageAppoint;
import com.king2.product.server.appoint.ProductBasicsAppoint;
import com.king2.product.server.appoint.ProductUploadImageAppoint;
import com.king2.product.server.appoint.UserMessageAppoint;
import com.king2.product.server.controller.TestDemoController;
import com.king2.product.server.dto.BrandIndexManageDto;
import com.king2.product.server.enmu.K2ProductBrandEnum;
import com.king2.product.server.enmu.ProductStateEnum;
import com.king2.product.server.mapper.BrandManageMapper;
import com.king2.product.server.service.BrandManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.UUID;


/*=======================================================
	说明:    商品品牌管理Service实现类

	作者		时间					注释
  	俞烨		2019.08.25   			创建
=======================================================*/
@Service
@SuppressWarnings("all")
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

    // 注入图片的类型
    @Value("${PRODUCT_IMAGE_TYPE}")
    private String PRODUCT_IMAGE_TYPE;

    // 注入MinIo的操作
    @Value("${MINIO_SERVER_URL}")
    private String MINIO_SERVER_URL;
    @Value("${MINIO_USER_NAME}")
    private String MINIO_USER_NAME;
    @Value("${MINIO_PASS_WORD}")
    private String MINIO_PASS_WORD;
    @Value("${MINIO_BUCKET_NAME}")
    private String MINIO_BUCKET_NAME;
    // 注入消息Mapper
    @Autowired
    private K2MessageMapper k2MessageMapper;
    // 注入上传的委托类
    @Autowired
    private ProductUploadImageAppoint productUploadImageAppoint;
    // 注入系统超级管理员标识
    @Value("${SYSTEM_ROLE_PROVE}")
    private String SYSTEM_ROLE_PROVE;
    // 注入商品Mapper
    @Autowired
    private K2ProductMapper k2ProductMapper;
    @Autowired
    private TransactionDefinition transactionDefinition;
    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    protected static final Logger logger = LoggerFactory.getLogger(BrandManageServiceImpl.class);

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
        k2ProductBrand.setBrandState(K2ProductBrandEnum.ZC.getValue());

        // 添加品牌信息
        brandMapper.insert(k2ProductBrand);

        return new SystemResult(k2ProductBrand);
    }

    /**
     * -----------------------------------------------------
     * 功能:  上传LOGO图片
     * <p>
     * 参数:
     * logoFile                MultipartFile         LOGO样式
     * k2MemberAndElseInfo      K2MemberAndElseInfo 操作的用户信息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult uploadLogo(MultipartFile logoFile, K2MemberAndElseInfo k2MemberAndElseInfo, Integer brandId) throws Exception {

        // 上传LOGO图片 校验文件是否正确
        SystemResult result = ProductUploadImageAppoint.checkImage(logoFile, PRODUCT_IMAGE_TYPE);
        if (result.getStatus() != 200) return result;

        // 查看商品LOGO是否存在 并且是否属于该用户的店铺
        SystemResult result1 = checkBrandInfo(brandId, k2MemberAndElseInfo);
        if (result1.getStatus() != 200) return result;

        // 取出品牌信息
        K2ProductBrand k2ProductBrand = (K2ProductBrand) result1.getData();

        // 图片正确 上传图片
        String url = "";
        try {
            MinioUtil util = new MinioUtil(MINIO_SERVER_URL, MINIO_USER_NAME, MINIO_PASS_WORD, MINIO_BUCKET_NAME);

            // 判断当前图片是否是默认的 如果不是需要删除
            if (!k2ProductBrand.getBrandImage().equals(PRODUCT_IMAGE_NOT_DEFINITION)) {
                // 需要删除
                String[] split = k2ProductBrand.getBrandImage().split(MINIO_BUCKET_NAME);
                if (split.length == 2) {
                    util.delFile(split[1].substring(1));
                }
            }
            // 获取名称
            SystemResult imageName = productUploadImageAppoint.getImageName("BRAND-LOGO", result.getData() + "");
            if (imageName.getStatus() != 200) return imageName;
            SystemResult uploadResult = util.uploadFile(logoFile, imageName.getData() + "", "image/jpg");
            if (uploadResult.getStatus() != 200) {
                throw new RuntimeException("上传图片时发生异常");
            }

            // 取出URL重新设置进品牌的LOGO路径去
            k2ProductBrand.setBrandImage(uploadResult.getData() + "");
            // 修改品牌信息
            url = uploadResult.getData() + "";
            brandMapper.updateByPrimaryKeySelective(k2ProductBrand);

        } catch (Exception e) {
            logger.error("上传图片到MINIO服务器上出错,请尽快检查问题,报错信息:" + e);
            logger.error(GetErrorInfo.getTrace(e));
            e.printStackTrace();
            // 发生异常就要给管理员发送信息。。
            UserMessageAppoint.addMessageGotoMysql("上传图片到MINIO服务器上出错,请尽快检查问题", 1, k2MessageMapper);
            return new SystemResult(100, "上传失败,请联系管理员");
        }

        return new SystemResult(url);
    }

    /**
     * -----------------------------------------------------
     * 功能:  修改品牌信息
     * <p>
     * 参数:
     * brandId                Integer         品牌id
     * k2MemberAndElseInfo      K2MemberAndElseInfo 操作的用户信息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult editBrandInfo(Integer brandId, String brandName, K2MemberAndElseInfo k2MemberAndElseInfo) {


        TransactionStatus transactionStatus = null;
        try {
            transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
            // 校验品牌信息
            SystemResult result = checkBrandInfo(brandId, k2MemberAndElseInfo);
            if (result.getStatus() != 200) return result;

            // 取出品牌信息
            K2ProductBrand k2ProductBrand = (K2ProductBrand) result.getData();

            // 查询是否可以修改商品品牌
            SystemResult ifEditBrand = BrandManageAppoint.checkIfEditBrand(k2MemberAndElseInfo.getK2Member().getRetain1());
            if (ifEditBrand.getStatus() != 200) return ifEditBrand;

            // 修改商品品牌信息
            k2ProductBrand.setBrandName(brandName);
            brandMapper.updateByPrimaryKeySelective(k2ProductBrand);

            platformTransactionManager.commit(transactionStatus);//提交

            // 修改成功  查询该品牌引用的商品信息 需要将他们的数据进行同步
            K2ProductExample example = new K2ProductExample();
            example.createCriteria().andProductBrandIdEqualTo(brandId);
            List<K2ProductWithBLOBs> k2ProductWithBLOBs = k2ProductMapper.selectByExampleWithBLOBs(example);
            // 将商品数据添加到队列中去
            if (!CollectionUtils.isEmpty(k2ProductWithBLOBs))
                ProductBasicsAppoint.addSynchronizedProductsGotoCache(k2ProductWithBLOBs);

            // 添加消息给该用户
            UserMessageAppoint.addMessageGotoMysql("商品品牌信息修改成功,该品牌关联的商品信息,还需要等待系统确认。", k2MemberAndElseInfo.getK2Member().getMemberId(), k2MessageMapper);
        } catch (Exception e) {
            e.printStackTrace();
            platformTransactionManager.rollback(transactionStatus);//回滚事务
        }


        return new SystemResult("ok");
    }

    /**
     * -----------------------------------------------------
     * 功能:  修改品牌的状态
     * <p>
     * 参数:
     * state                Integer         品牌状态
     * k2MemberAndElseInfo      K2MemberAndElseInfo 操作的用户信息
     * brandId              Integer         品牌id
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult editBrandState(K2MemberAndElseInfo k2MemberAndElseInfo, Integer brandId, Integer state) {

        // 校验品牌信息
        SystemResult result = checkBrandInfo(brandId, k2MemberAndElseInfo);
        if (result.getStatus() != 200) {
            return result;
        } else if (!state.toString().equals(K2ProductBrandEnum.ZC.getValue() + "") &&
                !state.toString().equals(K2ProductBrandEnum.DEL.getValue() + "")) { // 校验状态是否正确
            return new SystemResult(100, "请勿跨浏览器操作");
        }

        // 查询该品牌的信息是否被商品引用
        K2ProductExample example = new K2ProductExample();
        example.createCriteria().andProductBrandIdEqualTo(brandId).andProductStateNotEqualTo(ProductStateEnum.DEL.getValue());
        List<K2ProductWithBLOBs> k2ProductWithBLOBs = k2ProductMapper.selectByExampleWithBLOBs(example);
        if (!CollectionUtils.isEmpty(k2ProductWithBLOBs)) return new SystemResult(100, "该品牌暂时不能删除,因为有些商品使用了该品牌。");

        // 校验成功取出品牌信息
        K2ProductBrand k2ProductBrand = (K2ProductBrand) result.getData();

        // 修改品牌信息
        k2ProductBrand.setBrandState(state);
        k2ProductBrand.setBrandUpdateTime(new Date());
        k2ProductBrand.setBrandUpdateUserid(k2MemberAndElseInfo.getK2Member().getMemberId());
        k2ProductBrand.setBrandUpdateUsername(k2MemberAndElseInfo.getK2Member().getMemberAccount());
        brandMapper.updateByPrimaryKeySelective(k2ProductBrand);
        return new SystemResult("ok");
    }

    /**
     * 校验品牌的基本信息
     *
     * @param brandId
     * @param k2MemberAndElseInfo
     * @return
     */
    public SystemResult checkBrandInfo(Integer brandId, K2MemberAndElseInfo k2MemberAndElseInfo) {
        // 查询品牌信息是否存在
        K2ProductBrand k2ProductBrand = brandMapper.selectByPrimaryKey(brandId);
        if (k2ProductBrand == null) return new SystemResult(100, "品牌信息为空");

        // 判断是否是系统超级管理员
        for (int i = 0; i < k2MemberAndElseInfo.getK2Roles().size(); i++) {
            k2MemberAndElseInfo.getK2Roles().get(i).getRetain1().equals(SYSTEM_ROLE_PROVE);
            return new SystemResult(k2ProductBrand);
        }

        // 判断该品牌是否属于该店家
        if (!k2ProductBrand.getBrandStoreId().toString().equals(k2MemberAndElseInfo.getK2Member().getRetain1())) {
            return new SystemResult(100, "请勿修改别人的东西");
        }

        return new SystemResult(k2ProductBrand);
    }
}
