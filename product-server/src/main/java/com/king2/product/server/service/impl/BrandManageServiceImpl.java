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
	˵��:    ��ƷƷ�ƹ���Serviceʵ����

	����		ʱ��					ע��
  	����		2019.08.25   			����
=======================================================*/
@Service
@SuppressWarnings("all")
public class BrandManageServiceImpl implements BrandManageService {

    // ע����ƷƷ��Mapper
    @Autowired
    private BrandManageMapper brandManageMapper;

    // ע��Զ��Mapper
    @Autowired
    private K2ProductBrandMapper brandMapper;

    // ע������ͼƬ��·��
    @Value("${PRODUCT_IMAGE_NOT_DEFINITION}")
    private String PRODUCT_IMAGE_NOT_DEFINITION;

    // ע��ͼƬ������
    @Value("${PRODUCT_IMAGE_TYPE}")
    private String PRODUCT_IMAGE_TYPE;

    // ע��MinIo�Ĳ���
    @Value("${MINIO_SERVER_URL}")
    private String MINIO_SERVER_URL;
    @Value("${MINIO_USER_NAME}")
    private String MINIO_USER_NAME;
    @Value("${MINIO_PASS_WORD}")
    private String MINIO_PASS_WORD;
    @Value("${MINIO_BUCKET_NAME}")
    private String MINIO_BUCKET_NAME;
    // ע����ϢMapper
    @Autowired
    private K2MessageMapper k2MessageMapper;
    // ע���ϴ���ί����
    @Autowired
    private ProductUploadImageAppoint productUploadImageAppoint;
    // ע��ϵͳ��������Ա��ʶ
    @Value("${SYSTEM_ROLE_PROVE}")
    private String SYSTEM_ROLE_PROVE;
    // ע����ƷMapper
    @Autowired
    private K2ProductMapper k2ProductMapper;
    @Autowired
    private TransactionDefinition transactionDefinition;
    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    protected static final Logger logger = LoggerFactory.getLogger(BrandManageServiceImpl.class);

    /**
     * -----------------------------------------------------
     * ����:  ��ʾ��ƷƷ�Ƶ���ҳ
     * <p>
     * ����:
     * k2MemberAndElseInfo         K2MemberAndElseInfo        �������û���Ϣ
     * dto              BrandIndexManageDto ��ҳ����
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult index(K2MemberAndElseInfo k2MemberAndElseInfo, BrandIndexManageDto dto) {


        // ���ݵ��̲�ѯ�õ��������Ʒ����Ϣ
        Integer totalSize = brandManageMapper.selectCount(Integer.parseInt(k2MemberAndElseInfo.getK2Member().getRetain1()),
                StringUtils.isEmpty(dto.getBrandName()) ? null : "%" + dto.getBrandName().trim().replaceAll(" ", "") + "%");
        if (dto == null) dto = new BrandIndexManageDto();

        // ����ֵ
        dto.setTotalSize(totalSize);

        // �����ҳ��
        int totalPage = (totalSize + dto.getCurrentSize() - 1) / dto.getCurrentSize();
        dto.setTotlaPage(totalPage);

        // �鿴��ǰҳ���Ƿ������ҳ��
        if (dto.getCurrentPage() > totalPage) dto.setCurrentPage(totalPage);

        // ���������ֵ
        int index = (dto.getCurrentPage() - 1) * dto.getCurrentSize();


        // ��ѯ����
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
     * ����:  ���Ʒ��
     * <p>
     * ����:
     * brandName                String         Ʒ������
     * k2MemberAndElseInfo      K2MemberAndElseInfo �������û���Ϣ
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult addBrand(String brandName, K2MemberAndElseInfo k2MemberAndElseInfo) {

        // ����Ʒ�ƶ���
        K2ProductBrand k2ProductBrand = new K2ProductBrand();
        // ��ȫ����
        k2ProductBrand.setBrandName(brandName);
        // ��ȡһ��Ψһ���
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

        // ���Ʒ����Ϣ
        brandMapper.insert(k2ProductBrand);

        return new SystemResult(k2ProductBrand);
    }

    /**
     * -----------------------------------------------------
     * ����:  �ϴ�LOGOͼƬ
     * <p>
     * ����:
     * logoFile                MultipartFile         LOGO��ʽ
     * k2MemberAndElseInfo      K2MemberAndElseInfo �������û���Ϣ
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult uploadLogo(MultipartFile logoFile, K2MemberAndElseInfo k2MemberAndElseInfo, Integer brandId) throws Exception {

        // �ϴ�LOGOͼƬ У���ļ��Ƿ���ȷ
        SystemResult result = ProductUploadImageAppoint.checkImage(logoFile, PRODUCT_IMAGE_TYPE);
        if (result.getStatus() != 200) return result;

        // �鿴��ƷLOGO�Ƿ���� �����Ƿ����ڸ��û��ĵ���
        SystemResult result1 = checkBrandInfo(brandId, k2MemberAndElseInfo);
        if (result1.getStatus() != 200) return result;

        // ȡ��Ʒ����Ϣ
        K2ProductBrand k2ProductBrand = (K2ProductBrand) result1.getData();

        // ͼƬ��ȷ �ϴ�ͼƬ
        String url = "";
        try {
            MinioUtil util = new MinioUtil(MINIO_SERVER_URL, MINIO_USER_NAME, MINIO_PASS_WORD, MINIO_BUCKET_NAME);

            // �жϵ�ǰͼƬ�Ƿ���Ĭ�ϵ� ���������Ҫɾ��
            if (!k2ProductBrand.getBrandImage().equals(PRODUCT_IMAGE_NOT_DEFINITION)) {
                // ��Ҫɾ��
                String[] split = k2ProductBrand.getBrandImage().split(MINIO_BUCKET_NAME);
                if (split.length == 2) {
                    util.delFile(split[1].substring(1));
                }
            }
            // ��ȡ����
            SystemResult imageName = productUploadImageAppoint.getImageName("BRAND-LOGO", result.getData() + "");
            if (imageName.getStatus() != 200) return imageName;
            SystemResult uploadResult = util.uploadFile(logoFile, imageName.getData() + "", "image/jpg");
            if (uploadResult.getStatus() != 200) {
                throw new RuntimeException("�ϴ�ͼƬʱ�����쳣");
            }

            // ȡ��URL�������ý�Ʒ�Ƶ�LOGO·��ȥ
            k2ProductBrand.setBrandImage(uploadResult.getData() + "");
            // �޸�Ʒ����Ϣ
            url = uploadResult.getData() + "";
            brandMapper.updateByPrimaryKeySelective(k2ProductBrand);

        } catch (Exception e) {
            logger.error("�ϴ�ͼƬ��MINIO�������ϳ���,�뾡��������,������Ϣ:" + e);
            logger.error(GetErrorInfo.getTrace(e));
            e.printStackTrace();
            // �����쳣��Ҫ������Ա������Ϣ����
            UserMessageAppoint.addMessageGotoMysql("�ϴ�ͼƬ��MINIO�������ϳ���,�뾡��������", 1, k2MessageMapper);
            return new SystemResult(100, "�ϴ�ʧ��,����ϵ����Ա");
        }

        return new SystemResult(url);
    }

    /**
     * -----------------------------------------------------
     * ����:  �޸�Ʒ����Ϣ
     * <p>
     * ����:
     * brandId                Integer         Ʒ��id
     * k2MemberAndElseInfo      K2MemberAndElseInfo �������û���Ϣ
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult editBrandInfo(Integer brandId, String brandName, K2MemberAndElseInfo k2MemberAndElseInfo) {


        TransactionStatus transactionStatus = null;
        try {
            transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
            // У��Ʒ����Ϣ
            SystemResult result = checkBrandInfo(brandId, k2MemberAndElseInfo);
            if (result.getStatus() != 200) return result;

            // ȡ��Ʒ����Ϣ
            K2ProductBrand k2ProductBrand = (K2ProductBrand) result.getData();

            // ��ѯ�Ƿ�����޸���ƷƷ��
            SystemResult ifEditBrand = BrandManageAppoint.checkIfEditBrand(k2MemberAndElseInfo.getK2Member().getRetain1());
            if (ifEditBrand.getStatus() != 200) return ifEditBrand;

            // �޸���ƷƷ����Ϣ
            k2ProductBrand.setBrandName(brandName);
            brandMapper.updateByPrimaryKeySelective(k2ProductBrand);

            platformTransactionManager.commit(transactionStatus);//�ύ

            // �޸ĳɹ�  ��ѯ��Ʒ�����õ���Ʒ��Ϣ ��Ҫ�����ǵ����ݽ���ͬ��
            K2ProductExample example = new K2ProductExample();
            example.createCriteria().andProductBrandIdEqualTo(brandId);
            List<K2ProductWithBLOBs> k2ProductWithBLOBs = k2ProductMapper.selectByExampleWithBLOBs(example);
            // ����Ʒ������ӵ�������ȥ
            if (!CollectionUtils.isEmpty(k2ProductWithBLOBs))
                ProductBasicsAppoint.addSynchronizedProductsGotoCache(k2ProductWithBLOBs);

            // �����Ϣ�����û�
            UserMessageAppoint.addMessageGotoMysql("��ƷƷ����Ϣ�޸ĳɹ�,��Ʒ�ƹ�������Ʒ��Ϣ,����Ҫ�ȴ�ϵͳȷ�ϡ�", k2MemberAndElseInfo.getK2Member().getMemberId(), k2MessageMapper);
        } catch (Exception e) {
            e.printStackTrace();
            platformTransactionManager.rollback(transactionStatus);//�ع�����
        }


        return new SystemResult("ok");
    }

    /**
     * -----------------------------------------------------
     * ����:  �޸�Ʒ�Ƶ�״̬
     * <p>
     * ����:
     * state                Integer         Ʒ��״̬
     * k2MemberAndElseInfo      K2MemberAndElseInfo �������û���Ϣ
     * brandId              Integer         Ʒ��id
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult editBrandState(K2MemberAndElseInfo k2MemberAndElseInfo, Integer brandId, Integer state) {

        // У��Ʒ����Ϣ
        SystemResult result = checkBrandInfo(brandId, k2MemberAndElseInfo);
        if (result.getStatus() != 200) {
            return result;
        } else if (!state.toString().equals(K2ProductBrandEnum.ZC.getValue() + "") &&
                !state.toString().equals(K2ProductBrandEnum.DEL.getValue() + "")) { // У��״̬�Ƿ���ȷ
            return new SystemResult(100, "��������������");
        }

        // ��ѯ��Ʒ�Ƶ���Ϣ�Ƿ���Ʒ����
        K2ProductExample example = new K2ProductExample();
        example.createCriteria().andProductBrandIdEqualTo(brandId).andProductStateNotEqualTo(ProductStateEnum.DEL.getValue());
        List<K2ProductWithBLOBs> k2ProductWithBLOBs = k2ProductMapper.selectByExampleWithBLOBs(example);
        if (!CollectionUtils.isEmpty(k2ProductWithBLOBs)) return new SystemResult(100, "��Ʒ����ʱ����ɾ��,��Ϊ��Щ��Ʒʹ���˸�Ʒ�ơ�");

        // У��ɹ�ȡ��Ʒ����Ϣ
        K2ProductBrand k2ProductBrand = (K2ProductBrand) result.getData();

        // �޸�Ʒ����Ϣ
        k2ProductBrand.setBrandState(state);
        k2ProductBrand.setBrandUpdateTime(new Date());
        k2ProductBrand.setBrandUpdateUserid(k2MemberAndElseInfo.getK2Member().getMemberId());
        k2ProductBrand.setBrandUpdateUsername(k2MemberAndElseInfo.getK2Member().getMemberAccount());
        brandMapper.updateByPrimaryKeySelective(k2ProductBrand);
        return new SystemResult("ok");
    }

    /**
     * У��Ʒ�ƵĻ�����Ϣ
     *
     * @param brandId
     * @param k2MemberAndElseInfo
     * @return
     */
    public SystemResult checkBrandInfo(Integer brandId, K2MemberAndElseInfo k2MemberAndElseInfo) {
        // ��ѯƷ����Ϣ�Ƿ����
        K2ProductBrand k2ProductBrand = brandMapper.selectByPrimaryKey(brandId);
        if (k2ProductBrand == null) return new SystemResult(100, "Ʒ����ϢΪ��");

        // �ж��Ƿ���ϵͳ��������Ա
        for (int i = 0; i < k2MemberAndElseInfo.getK2Roles().size(); i++) {
            k2MemberAndElseInfo.getK2Roles().get(i).getRetain1().equals(SYSTEM_ROLE_PROVE);
            return new SystemResult(k2ProductBrand);
        }

        // �жϸ�Ʒ���Ƿ����ڸõ��
        if (!k2ProductBrand.getBrandStoreId().toString().equals(k2MemberAndElseInfo.getK2Member().getRetain1())) {
            return new SystemResult(100, "�����޸ı��˵Ķ���");
        }

        return new SystemResult(k2ProductBrand);
    }
}
