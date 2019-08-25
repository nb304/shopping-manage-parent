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
	˵��:    ��ƷƷ�ƹ���Serviceʵ����

	����		ʱ��					ע��
  	����		2019.08.25   			����
=======================================================*/
@Service
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
        k2ProductBrand.setBrandState(K2ProductBrandEnmu.ZC.getValue());

        // ���Ʒ����Ϣ
        brandMapper.insert(k2ProductBrand);

        return new SystemResult(k2ProductBrand);
    }
}
