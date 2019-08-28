package com.king2.product.server.service.impl;

import com.king2.commons.mapper.K2CategorySeasonMapper;
import com.king2.commons.mapper.K2ProductCategoryMapper;
import com.king2.commons.mapper.K2ProductSkuKeyMapper;
import com.king2.commons.pojo.*;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.ProductCategoryAppoint;
import com.king2.product.server.appoint.UserMessageAppoint;
import com.king2.product.server.dto.*;
import com.king2.product.server.enmu.K2ProductCategoryEnum;
import com.king2.product.server.enmu.K2ProductSkuKeyEnum;
import com.king2.product.server.mapper.CategoryManageMapper;
import com.king2.product.server.mapper.ProductSkuMapper;
import com.king2.product.server.service.ProductCategoryManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*=======================================================
	˵��:   ��Ʒ��Ŀ����Serviceʵ����

	����		ʱ��					ע��
  	����		2019.08.27   			����
=======================================================*/
@Service
@SuppressWarnings("all")
public class ProductCategoryManageServiceImpl implements ProductCategoryManageService {

    // ע�뱾����Ʒ��Ŀ��Mapper
    @Autowired
    private CategoryManageMapper categoryManageMapper;

    // ע��ϵͳ����Ա�ı�ʶ��
    @Value("${SYSTEM_ROLE_PROVE}")
    private String SYSTEM_ROLE_PROVE;

    // ע�뼾��Mapper
    @Autowired
    private K2CategorySeasonMapper k2CategorySeasonMapper;

    // ע��Զ�̵���Ʒ��ĿMapper
    @Autowired
    private K2ProductCategoryMapper k2ProductCategoryMapper;

    // ע����Ʒsku-key��mapper
    @Autowired
    private ProductSkuMapper productSkuMapper;

    // ע����Ʒ��Ŀί����
    @Autowired
    private ProductCategoryAppoint productCategoryAppoint;

    // ע��ϵͳ�ṩ���û���ע���������
    @Value("${SYSTEM_MAX_ADD_SKU_SIZE}")
    private Integer SYSTEM_MAX_ADD_SKU_SIZE;

    // ע��Զ�̵�SKU-keyMApper
    @Autowired
    private K2ProductSkuKeyMapper k2ProductSkuKeyMapper;

    /**
     * -----------------------------------------------------
     * ����:  ��ʾ��Ʒ��Ŀ����ҳ
     * <p>
     * ����:
     * k2MemberAndElseInfo         K2MemberAndElseInfo        �������û���Ϣ
     * dto              CategoryIndexManageDto              ��ҳ����
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult index(K2MemberAndElseInfo k2MemberAndElseInfo, CategoryIndexManageDto dto) {

        // �鿴���û��Ƿ�������Ӻͱ༭��Ʒ��Ŀ
        for (K2Role k2Role : k2MemberAndElseInfo.getK2Roles()) {
            if (k2Role.getRetain1().equals(SYSTEM_ROLE_PROVE)) {
                dto.setAddOrEdit(true);
                break;
            }
        }

        // ��ѯ��Ʒ��Ŀ������
        Integer totalSize = categoryManageMapper.selectCount(StringUtils.isEmpty(dto.getCategoryName()) ? null : "%" + dto.getCategoryName().trim().replaceAll(" ", "") + "%");
        dto.setTotalSize(totalSize);

        // ��ѯһ����Ŀ����Ϣ
        K2ProductCategoryExample example = new K2ProductCategoryExample();
        example.createCriteria().andCategoryIsParentEqualTo(1);
        List<K2ProductCategory> k2ProductCategories = k2ProductCategoryMapper.selectByExample(example);
        dto.setOneCategorDatas(k2ProductCategories);

        // ��ѯ�ʺϼ��ڵ���Ϣ
        List<K2CategorySeason> k2CategorySeasons = k2CategorySeasonMapper.selectByExample(null);
        List<ProductCatrgorySiJieDto> siJieDtos = new ArrayList<>();
        for (K2CategorySeason k2CategorySeason : k2CategorySeasons) {
            ProductCatrgorySiJieDto dto1 = new ProductCatrgorySiJieDto();
            dto1.setLabel(k2CategorySeason.getCategorySeasonValue());
            dto1.setValue(k2CategorySeason.getCategorySeasonId() + "");
            siJieDtos.add(dto1);
        }
        dto.setSiJieDatas(siJieDtos);

        // ����ֵ
        dto.setTotalSize(totalSize);

        // �����ҳ��
        int totalPage = (totalSize + dto.getCurrentSize() - 1) / dto.getCurrentSize();
        dto.setTotlaPage(totalPage);

        // �鿴��ǰҳ���Ƿ������ҳ��
        if (dto.getCurrentPage() > totalPage) dto.setCurrentPage(totalPage);

        // ���������ֵ
        int index = (dto.getCurrentPage() - 1) * dto.getCurrentSize();

        // ��ȡ��Ʒ��Ŀ����Ϣ
        List<K2ProductCategory> category = categoryManageMapper.getCategory(
                StringUtils.isEmpty(dto.getCategoryName()) ? null : "%" + dto.getCategoryName().trim().replaceAll(" ", "") + "%",
                index, dto.getCurrentSize()
        );

        if (!CollectionUtils.isEmpty(category)) {
            category.forEach((n) -> {
                n.setCreateTimeStr(UserMessageAppoint.sdf.format(n.getCategoryCreateTime()));
                n.setCategoryIsName(n.getCategoryIsParent() == 1 ? "һ����Ŀ" : "������Ŀ");
            });
        }

        dto.setCategoryDatas(category);

        return new SystemResult(dto);
    }

    /**
     * -----------------------------------------------------
     * ����:  ���ݸ���id��ѯ������Ϣ
     * <p>
     * ����:
     * parentId         Integer         �����id
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult loadCategoryById(Integer parentId) {

        // ��ѯ����
        List<K2ProductCategory> categoryById = categoryManageMapper.getCategoryById(parentId);
        if (!CollectionUtils.isEmpty(categoryById)) {
            categoryById.forEach((n) -> {
                n.setCreateTimeStr(UserMessageAppoint.sdf.format(n.getCategoryCreateTime()));
                n.setCategoryIsName(n.getCategoryIsParent() == 1 ? "һ����Ŀ" : "������Ŀ");
                n.setHasChildren(false);
            });
        }
        return new SystemResult(categoryById);
    }

    /**
     * -----------------------------------------------------
     * ����:   ������Ʒ��Ŀ��Ϣ
     * <p>
     * ����:
     * k2MemberAndElseInfo         K2MemberAndElseInfo         �������û���Ϣ
     * dto                       AddCategoryDto              �����ӵ���Ŀ��Ϣ
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult addCategory(K2MemberAndElseInfo k2MemberAndElseInfo, AddCategoryDto dto) {

        SystemResult result = checkCategory(k2MemberAndElseInfo, dto);
        if (result.getStatus() != 200) return result;
        // ������Ŀ����
        K2ProductCategory category = new K2ProductCategory();
        // ��ȫ��Ϣ
        category.setCategoryName(dto.getCategoryName());
        category.setCategorySeasonId(dto.getSiJie());
        category.setCategoryIsParent(Integer.parseInt(dto.getOneCateId()) == 0 ? K2ProductCategoryEnum.YES.getValue() :
                K2ProductCategoryEnum.NO.getValue());
        category.setCategoryParentId(Integer.parseInt(dto.getOneCateId()));
        category.setCategoryState(K2ProductCategoryEnum.ZC.getValue());
        category.setCategoryUserid(k2MemberAndElseInfo.getK2Member().getMemberId());
        category.setCategoryUpdateUserid(k2MemberAndElseInfo.getK2Member().getMemberId());
        category.setCategoryCreateTime(new Date());

        // ��������
        k2ProductCategoryMapper.insert(category);
        return new SystemResult(category);
    }

    /**
     * -----------------------------------------------------
     * ����:   �޸���Ʒ��Ŀ��Ϣ
     * <p>
     * ����:
     * k2MemberAndElseInfo         K2MemberAndElseInfo         �������û���Ϣ
     * dto                       AddCategoryDto              �޸����ӵ���Ŀ��Ϣ
     * categoryId               Integer                 �޸ĵ���Ŀid
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult editCategory(K2MemberAndElseInfo k2MemberAndElseInfo, AddCategoryDto dto, Integer categoryId) {

        SystemResult result = checkCategory(k2MemberAndElseInfo, dto);
        if (result.getStatus() != 200) return result;

        // ������Ŀ����
        K2ProductCategory category = new K2ProductCategory();
        // ��ȫ��Ϣ
        category.setCategoryName(dto.getCategoryName());
        category.setCategorySeasonId(dto.getSiJie());
        category.setCategoryUpdateUserid(k2MemberAndElseInfo.getK2Member().getMemberId());
        category.setCategoryId(categoryId);

        // �޸���Ϣ
        k2ProductCategoryMapper.updateByPrimaryKeySelective(category);

        return new SystemResult("ok");
    }

    /**
     * jiaoy��Ŀ����Ϣ
     *
     * @param k2MemberAndElseInfo
     * @param dto
     * @return
     */
    public SystemResult checkCategory(K2MemberAndElseInfo k2MemberAndElseInfo, AddCategoryDto dto) {
        // ��ѯ���û��Ƿ����ʸ�������Ʒ��Ŀ
        boolean flag = false;
        for (K2Role k2Role : k2MemberAndElseInfo.getK2Roles()) {
            if (SYSTEM_ROLE_PROVE.equals(k2Role.getRetain1())) {
                flag = true;
            }
        }

        if (!flag) return new SystemResult(100, "����ʱû��Ȩ��");

        // У���ļ��Ƿ���ȷ
        if (StringUtils.isEmpty(dto.getSiJie())) {
            return new SystemResult(100, "��ѡ����Ŀ����Ӧʱ��");
        } else {
            String[] split = dto.getSiJie().split(",");
            if (split.length > 4 || split.length < 1) return new SystemResult(100, "����ʧ��,��ˢ��ҳ������");
            for (int i = 0; i < split.length; i++) {
                if (!split[i].matches("[0-9]{1,}")) {
                    return new SystemResult(100, "����ʧ��,��ˢ��ҳ������");
                } else if (Integer.parseInt(split[i]) != 1 && Integer.parseInt(split[i]) != 2
                        && Integer.parseInt(split[i]) != 3 && Integer.parseInt(split[i]) != 4) {
                    return new SystemResult(100, "����ʧ��,��ˢ��ҳ������");

                }

            }
        }

        return new SystemResult("ok");
    }

    /**
     * -----------------------------------------------------
     * ����:    �޸���Ʒ��Ŀ��״̬
     * <p>
     * ����:
     * k2MemberAndElseInfo          K2MemberAndElseInfo         �������û���Ϣ
     * state                        String                      ��Ŀ״̬
     * categoryId                   Integer                     �޸ĵ���Ŀid
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult editCategoryState(K2MemberAndElseInfo k2MemberAndElseInfo, Integer categoryId, String state) {

        SystemResult result = editCheckCategoryInfo(k2MemberAndElseInfo, categoryId, state);
        if (result.getStatus() != 200) return result;

        // ˵��У��ͨ�� ��ȡ��Ŀ����Ϣ
        K2ProductCategory k2ProductCategory = (K2ProductCategory) result.getData();

        // ����SQL�޸���Ŀ��Ϣ
        k2ProductCategoryMapper.updateByPrimaryKeySelective(k2ProductCategory);
        return new SystemResult("ok");
    }

    /**
     * �޸���Ŀʱ���鿴��Ŀ��Ϣ�Ƿ����
     *
     * @param k2MemberAndElseInfo
     * @param categoryId
     * @param state
     * @return
     */
    public SystemResult editCheckCategoryInfo(K2MemberAndElseInfo k2MemberAndElseInfo, Integer categoryId, String state) {

        // У��ý�ɫ�Ƿ���Խ����޸���Ŀ��״̬
        boolean flag = false;
        for (K2Role k2Role : k2MemberAndElseInfo.getK2Roles()) {
            if (SYSTEM_ROLE_PROVE.equals(k2Role.getRetain1())) {
                flag = true;
            }
        }
        if (!flag) return new SystemResult(100, "����ʱû��Ȩ��");

        // У�����Ŀ�Ƿ����
        K2ProductCategory k2ProductCategory = k2ProductCategoryMapper.selectByPrimaryKey(categoryId);
        if (k2ProductCategory == null) return new SystemResult(100, "��Ŀ��Ϣ������");

        // �жϱ��ε�״̬�Ƿ�����
        if (!state.equals(K2ProductCategoryEnum.ZC.getValue() + "") && !state.equals(K2ProductCategoryEnum.TY.getValue() + "")) {
            return new SystemResult(100, "����״̬�����");
        }


        // ͨ��������ֵ
        k2ProductCategory.setCategoryState(Integer.parseInt(state));
        k2ProductCategory.setCategoryUpdateUserid(k2MemberAndElseInfo.getK2Member().getMemberId());

        return new SystemResult(k2ProductCategory);
    }

    /**
     * -----------------------------------------------------
     * ����:    ��ʾ��Ŀ��SKU��Ϣ
     * <p>
     * ����:
     * k2MemberAndElseInfo          K2MemberAndElseInfo         �������û���Ϣ
     * categoryId                   Integer                     �޸ĵ���Ŀid
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult showCategorySKUInfo(K2MemberAndElseInfo k2MemberAndElseInfo, Integer categoryId) {

        // �������ص�����
        ShowCategoryOfSkuInfo skuInfo = new ShowCategoryOfSkuInfo();

        // �����û��Ľ�ɫ�ж��Ƿ���Ҫ��ѯ���̵�SKU��Ϣ
        boolean flag = false;
        for (K2Role k2Role : k2MemberAndElseInfo.getK2Roles()) {
            if (SYSTEM_ROLE_PROVE.equals(k2Role.getRetain1())) {
                flag = true;
            }
        }

        // ��ѯϵͳ����õ�SKU��Ϣ
        List<K2ProductSkuKey> skuInfoByCid = productSkuMapper.getSkuInfoByCid(categoryId);
        skuInfo.setSystemSkuInfo(skuInfoByCid);

        if (flag) {
            // ��Ҫ��ѯ����+ϵͳ����õ�
            skuInfo.setEditSystemFlag(true);
            skuInfo.setShowUserInfoFlag(false);
        } else {
            // ����˵�� ������û����ǳ�������Ա ��Ҫ���Ⱪ¶ϵͳ+�����Լ������SKU��Ϣ ����ϵͳ����õ�SKU��Ϣ�ǲ���ɾ����
            skuInfo.setEditSystemFlag(false);
            skuInfo.setShowUserInfoFlag(true);
            // ��ѯ�û�����õ�SKU��Ϣ
            List<K2ProductSkuKey> skuInfoByStoreId = productSkuMapper.getSkuInfoByStoreId(categoryId, Integer.parseInt(k2MemberAndElseInfo.getK2Member().getRetain1()));
            skuInfo.setUserSkuInfo(skuInfoByStoreId);
        }
        // ���Ȳ�ѯϵͳ����õ�
        return new SystemResult(skuInfo);
    }

    /**
     * -----------------------------------------------------
     * ����:    ������������Ŀ��SKU��Ϣ
     * <p>
     * ����:
     * k2MemberAndElseInfo          K2MemberAndElseInfo         �������û���Ϣ
     * categoryId                   Integer                     �޸ĵ���Ŀid
     * skuInfoJson                  String                      �����ӵ�SKU��
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult manageAndAddCategoryOfSkuInfo(K2MemberAndElseInfo k2MemberAndElseInfo, Integer categoryId, String skuInfoJson) {

        // У���û��Ľ�ɫ�Ƿ�Ϊ��������Ա
        boolean flag = false;
        for (K2Role k2Role : k2MemberAndElseInfo.getK2Roles()) {
            if (SYSTEM_ROLE_PROVE.equals(k2Role.getRetain1())) {
                flag = true;
            }
        }

        // �鿴SKU��������
        Integer maxOrder = productSkuMapper.skuMaxOrder(categoryId);
        maxOrder = maxOrder == null ? 0 : maxOrder;
        // ���巵�ص�Result
        SystemResult result = null;
        if (flag) {
            // ����Ա
            // У��SKUJSON��Ϣ�Ƿ���ȷ,������SKUģ�����Ϣ�ļ���
            result = productCategoryAppoint.checkCategorySkuInfoAndReturnSkuLists
                    (skuInfoJson, flag, 0, categoryId, k2MemberAndElseInfo.getK2Member(), maxOrder + 1);
            if (result.getStatus() != 200) return result;
        } else {
            // ���ǹ���Ա

            // �鿴�õ����Լ������˶��ٸ�SKU��Ϣ
            K2ProductSkuKeyExample example = new K2ProductSkuKeyExample();
            example.createCriteria().andIsSystemCreateNotEqualTo(K2ProductSkuKeyEnum.SYSTEM_FLAG_NO.getValue())
                    .andBelongStoreIdEqualTo(Integer.parseInt(k2MemberAndElseInfo.getK2Member().getRetain1()))
                    .andRetain1EqualTo(K2ProductSkuKeyEnum.IS_TEMPLATE.getValue() + "")
                    .andSkuKeyStateEqualTo(K2ProductSkuKeyEnum.ZCSY.getValue());
            List<K2ProductSkuKey> skuKeys = k2ProductSkuKeyMapper.selectByExample(example);
            // ��ѯ�õ��̻��ж��ٴ�������ƷSKU�Ļ���
            if (CollectionUtils.isEmpty(skuKeys)) {
                // У��SKUJSON��Ϣ�Ƿ���ȷ,������SKUģ�����Ϣ�ļ���
                result = productCategoryAppoint.checkCategorySkuInfoAndReturnSkuLists
                        (skuInfoJson, flag, SYSTEM_MAX_ADD_SKU_SIZE, categoryId, k2MemberAndElseInfo.getK2Member(), maxOrder + 1);
            } else {
                if (SYSTEM_MAX_ADD_SKU_SIZE - skuKeys.size() <= 0) {
                    return new SystemResult(100, "ʣ���Լ�����Ĵ���Ϊ:0�Σ���������������Ҫ������ϵ����Ա");
                }
                // У��SKUJSON��Ϣ�Ƿ���ȷ,������SKUģ�����Ϣ�ļ���
                result = productCategoryAppoint.checkCategorySkuInfoAndReturnSkuLists
                        (skuInfoJson, flag, SYSTEM_MAX_ADD_SKU_SIZE - skuKeys.size(), categoryId, k2MemberAndElseInfo.getK2Member(), (maxOrder + skuKeys.size() + 1));
            }

            if (result.getStatus() != 200) return result;
        }

        // У��ɹ� ȡ��SKU������
        List<ProductSkuDto> skuSplit = (List<ProductSkuDto>) result.getData();

        // ������������
        if (!CollectionUtils.isEmpty(skuSplit)) productSkuMapper.batchInsertSkuKeyOrIsSystemCreate(skuSplit);

        return new SystemResult(skuSplit);
    }

    /**
     * -----------------------------------------------------
     * ����:    ɾ��SKU����Ϣ
     * <p>
     * ����:
     * k2MemberAndElseInfo          K2MemberAndElseInfo         �������û���Ϣ
     * skuId                        Integer                     ɾ����skuId
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult delSkuInfo(K2MemberAndElseInfo k2MemberAndElseInfo, Integer skuId) {

        // �鿴��ǰ�û��Ƿ��ǹ���Ա
        boolean flag = false;
        for (K2Role k2Role : k2MemberAndElseInfo.getK2Roles()) {
            if (SYSTEM_ROLE_PROVE.equals(k2Role.getRetain1())) {
                flag = true;
            }
        }

        // �鿴SKU����Ϣ�Ƿ����
        K2ProductSkuKey productSkuKey = k2ProductSkuKeyMapper.selectByPrimaryKey(skuId);
        if (productSkuKey == null) return new SystemResult(100, "��ɾ����SKU��Ϣ��δ����,����Ѿ�������ˢ��ҳ������");


        // �鿴��ǰ���û��Ƿ�ɾ��ϵͳ����õ� ����û����ǳ�������Ա ������ɾ��
        if (productSkuKey.getIsSystemCreate() == 1 && !flag) {
            return new SystemResult(100, "����ʱû��Ȩ��ɾ��ϵͳ����õ�ģ��");
        }

        // �޸���Ʒ��Ŀ��SKU״̬
        productSkuKey.setSkuKeyState(K2ProductSkuKeyEnum.DEL.getValue());
        k2ProductSkuKeyMapper.updateByPrimaryKeySelective(productSkuKey);

        // ������־
        return new SystemResult("ok");
    }
}