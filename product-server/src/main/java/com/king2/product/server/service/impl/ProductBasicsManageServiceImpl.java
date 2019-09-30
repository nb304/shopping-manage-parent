package com.king2.product.server.service.impl;

import com.king2.commons.mapper.*;
import com.king2.commons.pojo.*;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.*;
import com.king2.product.server.dto.*;
import com.king2.product.server.enmu.ProductEnum;
import com.king2.product.server.enmu.ProductStateEnum;
import com.king2.product.server.exception.CheckValueException;
import com.king2.product.server.mapper.ProductManageMapper;
import com.king2.product.server.mapper.ProductSkuMapper;
import com.king2.product.server.pojo.ProductSkuPojo;
import com.king2.product.server.service.ProductBasicsManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.JedisPool;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*=======================================================
	˵��:    ��Ʒ��������Serviceʵ����

	����		ʱ��					ע��
  	����		2019.08.06   			����
=======================================================*/
@Service
public class ProductBasicsManageServiceImpl implements ProductBasicsManageService {

    // ע��Jedis���ӳ�
    @Autowired
    private JedisPool jedisPool;

    // ��Ʒ��Ŵ���redis�е�key
    @Value("${PRODUCT_NUMBER_REDIS_KEY}")
    private String PRODUCT_NUMBER_REDIS_KEY;

    // ע����ƷMapper
    @Autowired
    private K2ProductMapper k2ProductMapper;

    // ע����Ʒsku-key��mapper
    @Autowired
    private ProductSkuMapper productSkuMapper;

    // ע��Զ�̷����sku-keyMapper
    @Autowired
    private K2ProductSkuKeyMapper k2ProductSkuKeyMapper;

    // ע����Ʒ����Mapper
    @Autowired
    private K2ProductSketchMapper k2ProductSketchMapper;

    // ע��Զ�̵���ģ�����
    @Autowired
    private RestTemplate restTemplate;

    // ע�뻺���������ַ
    @Value("${CACHE_SERVER_URL}")
    private String CACHE_SERVER_URL;

    // ע����Ʒ��Ŀί����
    @Autowired
    private ProductCategoryAppoint productCategoryAppoint;

    // ע����ƷƷ��
    @Autowired
    private K2ProductBrandMapper k2ProductBrandMapper;

    // ע����Ʒ��Ŀ��
    @Autowired
    private K2ProductCategoryMapper k2ProductCategoryMapper;
    // ע�뱾�ص���ƷMapper
    @Autowired
    private ProductManageMapper productManageMapper;

    // ע����Ʒ��ͼƬ�ĵ�ַ
    @Value("${PRODUCT_IMAGE_NOT_DEFINITION}")
    private String PRODUCT_IMAGE_NOT_DEFINITION;

    // ע����Ʒ���һ���޸ĵ�ʱ��
    @Autowired
    private K2ProductEditSizeMapper k2ProductEditSizeMapper;

    // ע�볬��ϵͳ����Ա��ʶ��
    @Value("${SYSTEM_ROLE_PROVE}")
    private String SYSTEM_ROLE_PROVE;

    // ע����ϢMapper
    @Autowired
    private K2MessageMapper k2MessageMapper;

    // ע����Ʒ���ί����
    @Autowired
    private ProductAddAppoint productAddAppoint;

    /**
     * -----------------------------------------------------
     * ����:  �����Ʒ
     * <p>
     * ����:
     * K2Member         K2MemberAndElseInfo        �������û���Ϣ
     * AddProductDto    dto                        ��ӵ���Ʒ��Ϣ
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public SystemResult addProduct(K2MemberAndElseInfo k2MemberAndElseInfo, AddProductDto dto) throws CheckValueException {

        SystemResult result = productAddAppoint.checkProductInfo(dto, k2MemberAndElseInfo);
        return result;
    }

    /**
     * -----------------------------------------------------
     * ����:  �����Ʒ��SKU
     * <p>
     * ����:
     * skuJson          String          SKU��JSON����
     * state            String          �����Ƿ���Ҫ���������Ʒ��Ϣ  1��Ҫ  2����Ҫ
     * productInfo      String          ��Ʒ��JSON����
     * k2Member         K2Member        �������û���Ϣ
     * <p>
     * ����: UserManageUtil              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public SystemResult addProductSku(String skuJson, String productInfo, String state, K2MemberAndElseInfo k2Member) throws Exception {

        /*
        �����Ʒ��Ϣ
        ���������������Ʒ��SKUΪ
            ��Ϊ��Ʒ��SKU�����ܴ� ������Ҫ����ʲô���������Ʒ��Ϣ�ķ��������أ��ݴ�ŵ����ݿ⵱��ȥ����ŵ�ʱ����Ҫָ����Ʒ��Ϣ
            �������Ǹ��ݴ��������state �жϱ����Ƿ���Ҫ�����Ʒ��Ϣ
         */
        SystemResult addProductResult = ProductBasicsAppoint.addProduct
                (jedisPool, productInfo, PRODUCT_NUMBER_REDIS_KEY, k2ProductMapper, k2Member.getK2Member(), state, k2ProductSketchMapper, restTemplate, CACHE_SERVER_URL, PRODUCT_IMAGE_NOT_DEFINITION);
        if (addProductResult.getStatus() != 200) return addProductResult;
        // ��ȡ��Ʒ������
        K2ProductWithBLOBs k2ProductWithBLOBs = (K2ProductWithBLOBs) addProductResult.getData();

        // ����У���� �鿴SkuJson�����Ƿ�����
        SystemResult skuResult = ProductBasicsAppoint.checkSkuJsonGotoLists(skuJson);
        if (skuResult.getStatus() != 200) {
            throw new RuntimeException("У����ƷSKU-keyʱ������,������Ϣ:" + skuResult.getMsg());
        }
        // ��ȡת��������Json����
        List<ProductSkuPojo> skuPojos = (List<ProductSkuPojo>) skuResult.getData();
        // �����Ʒsku-key����Ϣ
        SystemResult addSku_KeyResult = ProductSkuAppoint.addProductSkuKeyInfos(skuPojos, k2Member.getK2Member(), k2ProductWithBLOBs, productSkuMapper, k2ProductSkuKeyMapper);
        if (addSku_KeyResult.getStatus() != 200) {
            throw new RuntimeException("�����ƷSKU-keyʱ������");
        }

        // ���SKU-key�ɹ� �������SKU-Value
        List<K2ProductSkuValue> k2ProductSkuValues = (List<K2ProductSkuValue>) addSku_KeyResult.getData();
        if (!CollectionUtils.isEmpty(k2ProductSkuValues)) {
            productSkuMapper.batchInsertSkuValue(k2ProductSkuValues);
            // ��ӳɹ� ��ȡ��sku-value�Ŀ��ͼ۸���Ϣ
            SystemResult productSkuValueKcDatas = ProductSkuValueKcAppoint.getProductSkuValueKcDatas(k2ProductSkuValues, k2ProductWithBLOBs);
            // �ж��Ƿ��ȡ���۸��ids�ɹ�
            if (productSkuValueKcDatas.getStatus() != 200) return productSkuValueKcDatas;
            List<K2ProductSkuPriceandkc> kcs = (List<K2ProductSkuPriceandkc>) productSkuValueKcDatas.getData();
            // ��������SKU-Value�Ŀ��ͼ۸�
            productSkuMapper.batchInsertSkuValueKc(kcs);
        }

        // �����Ϣ ��ʾ�û� ��Ʒ�ύ����ɹ�
        StringBuilder sb = new StringBuilder();
        sb.append("������Ʒ��Ϣ:��Ʒ����- ");
        sb.append(k2ProductWithBLOBs.getProductName());
        sb.append(" :��Ʒ���:-");
        sb.append(k2ProductWithBLOBs.getProductNumber());
        sb.append(" �ύ�ɹ�,�����ĵȴ�ϵͳ���,�����ע��Ϣ,лл! ----����ϵͳ����Ա");
        UserMessageAppoint.addMessageGotoMysql(sb.toString() + k2ProductWithBLOBs.getProductName(), k2Member.getK2Member().getMemberId(), k2MessageMapper);

        // �����Ʒ�ɹ� �����з�����Ϣͬ��solr
        ProductBasicsAppoint.addProductInfoQueue(k2ProductWithBLOBs);
        ProductBasicsAppoint.addSynchronizedProductGotoCache(k2ProductWithBLOBs);

        return new SystemResult(200, "�����Ʒ��SKU�ɹ�������������Ʒ��Ϣ", k2ProductWithBLOBs);
    }

    /**
     * -----------------------------------------------------
     * ����:  �����Ʒҳ������Ҫ����Ϣ
     * <p>
     * ����:
     * K2Member         K2Member        �������û���Ϣ
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult addProductPageInfo(K2MemberAndElseInfo k2Member) throws Exception {

        // ��Ʒ��Ŀ����Ϣ
        SystemResult productCategoryInfo = productCategoryAppoint.getProductCategoryInfo();
        if (productCategoryInfo.getStatus() != 200) return productCategoryInfo;
        // ȡ������
        ShowProductAddPageDto showProductAddPageDto = (ShowProductAddPageDto) productCategoryInfo.getData();

        // ��ѯ��ƷƷ����Ϣ
        K2ProductBrandExample brandExample = new K2ProductBrandExample();
        brandExample.createCriteria().andBrandStoreIdEqualTo(Integer.parseInt(k2Member.getK2Member().getRetain1()))
                .andBrandStateEqualTo(ProductEnum.PRODUCT_BRAND_TYPE1);
        List<K2ProductBrand> k2ProductBrands = k2ProductBrandMapper.selectByExample(brandExample);
        showProductAddPageDto.setProductBrands(k2ProductBrands);

        return new SystemResult(showProductAddPageDto);
    }

    /**
     * -----------------------------------------------------
     * ����:  ͨ����Ŀid��ȡ��ƷSKUģ����Ϣ
     * <p>
     * ����:
     * cId         Integer          ��Ŀid
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult getSkuInfoByCId(Integer cId, K2MemberAndElseInfo k2MemberAndElseInfo) {

        // ��ѯ����Ʒ��Ŀ�Ƿ����
        K2ProductCategory k2ProductCategory = k2ProductCategoryMapper.selectByPrimaryKey(cId);
        if (k2ProductCategory == null) {
            return new SystemResult(100, "��ѡ�е���Ŀ������,��ˢ��ҳ������", null);
        } else if (k2ProductCategory.getCategoryIsParent() == 1) {
            return new SystemResult(100, "�뽫��Ŀ��ȷ��������Ŀ", null);
        }

        // �������ڸ���Ʒ��Ŀ��SKU��Ϣ
        List<K2ProductSkuKey> skuInfoByCid = productSkuMapper.getSkuInfoByCid(cId);
        List<K2ProductSkuKey> skuInfoByStoreId = productSkuMapper.getSkuInfoByStoreId(cId, Integer.parseInt(k2MemberAndElseInfo.getK2Member().getRetain1()));
        skuInfoByCid.addAll(skuInfoByStoreId);
        // ����ǰ����Ҫ��ģ������
        List<ProductSkuPojo> productSkuPojos = new ArrayList<>();
        for (K2ProductSkuKey productSkuKey : skuInfoByCid) {
            ProductSkuPojo productSkuPojo = new ProductSkuPojo();
            productSkuPojo.setSkuValue("");
            productSkuPojo.setProductSkuKeyName(productSkuKey.getProductSkuKeyName());
            productSkuPojo.setSkuKeyOrder(productSkuKey.getSkuKeyOrder() + "");
            productSkuPojo.setProductSkuKeyId(productSkuKey.getProductSkuKeyId() + "");
            productSkuPojo.setIsSystemCreate(productSkuKey.getIsSystemCreate());
            productSkuPojos.add(productSkuPojo);
        }
        return new SystemResult(productSkuPojos);
    }

    /**
     * -----------------------------------------------------
     * ����:  ��ʾ��Ʒ�޸�ҳ�沢��ѯ��Ʒ��Ϣ
     * <p>
     * ����:
     * productId         Integer          ��Ҫ��ѯ����Ʒid
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult showEditGetProInfo(Integer productId, K2MemberAndElseInfo k2Member) {

        // ��ѯ������Ʒ����Ϣ
        ShowEditProductInfoDto productInfoByPId = productManageMapper.getProductInfoByPId(productId);

        // �ж���Ʒ�Ƿ����
        if (productInfoByPId == null) return new SystemResult(100, "��Ʒ��Ϣ����,��ˢ��ҳ������", null);

        // ��ѯ�����̼ҵ�����Ʒ����Ϣ
        K2ProductBrandExample brandExample = new K2ProductBrandExample();
        brandExample.createCriteria().andBrandStoreIdEqualTo(Integer.parseInt(k2Member.getK2Member().getRetain1()));
        List<K2ProductBrand> k2ProductBrands = k2ProductBrandMapper.selectByExample(brandExample);

        // ��������ֵ
        ShowEditProductDto dto = new ShowEditProductDto();
        dto.setBrands(k2ProductBrands);

        // ����� �Ƿ�����޸�
        if (productInfoByPId.getNextUpdateTime() == null) {
            dto.setEditFlag(true);
        } else if (new Date().compareTo(productInfoByPId.getNextUpdateTime()) == -1) {
            dto.setEditFlag(false);
            // �任ʱ��ΪString
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
            productInfoByPId.setLastTimeStr(sdf.format(productInfoByPId.getLastUpdateTime()));
            productInfoByPId.setNextTimeStr(sdf.format(productInfoByPId.getNextUpdateTime()));
        } else if (new Date().compareTo(productInfoByPId.getNextUpdateTime()) == 1) {
            dto.setEditFlag(true);
        } else {
            dto.setEditFlag(false);
        }

        dto.setProductInfo(productInfoByPId);
        return new SystemResult(dto);
    }

    /**
     * -----------------------------------------------------
     * ����:  ��ѯ��Ʒ��ͼƬ��Ϣ
     * <p>
     * ����:
     * productId         Integer          ��Ҫ��ѯ����Ʒid
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult getProductImageByPId(Integer productId) {

        // ������Ʒ����
        List<ProductImageDto> productImages = new ArrayList<>();

        // ��ѯ��ƷͼƬ
        String productImageById = productManageMapper.getProductImageById(productId);
        // �ж���ƷͼƬ�Ƿ����
        if (StringUtils.isEmpty(productImageById)) {
            ProductImageDto dto = new ProductImageDto();
            dto.setImageUrl(PRODUCT_IMAGE_NOT_DEFINITION);
            dto.setOrder(1);
            dto.setProductId(1);
            productImages.add(dto);
        } else {
            // ��Ʒ��Ϊ�� ������Ʒ��Ϣ
            String[] imageSplit = productImageById.split(",");
            for (int i = 0; i < imageSplit.length; i++) {
                ProductImageDto dto = new ProductImageDto();
                dto.setImageUrl(imageSplit[i]);
                dto.setOrder(i);
                dto.setProductId(i);
                productImages.add(dto);
            }
        }
        return new SystemResult(productImages);
    }

    /**
     * -----------------------------------------------------
     * ����:  �޸���Ʒ��Ϣ
     * <p>
     * ����:
     * k2ProductWithBLOBs         K2ProductWithBLOBs          �޸ĵ���Ʒ��Ϣ
     * k2Member                   K2Member                    �������û���Ϣ
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public SystemResult editProductInfo(K2ProductWithBLOBs k2ProductWithBLOBs, K2MemberAndElseInfo k2Member) {

        // ��ѯ����Ʒ�Ƿ�����޸�
        ShowEditProductInfoDto productInfoByPId = productManageMapper.getProductInfoByPId(k2ProductWithBLOBs.getProductId());
        // ��ѯ��Ʒ������Ϣ
        K2ProductWithBLOBs productWithBLOBs = k2ProductMapper.selectByPrimaryKey(k2ProductWithBLOBs.getProductId());
        // ����У����Ʒ��Ϣ�ķ���ֵ
        SystemResult result = null;

        if (productInfoByPId == null || productWithBLOBs == null) return new SystemResult("��Ʒ��Ϣ������,��ˢ��ҳ������");
        if (productInfoByPId.getLastUpdateTime() != null &&
                productInfoByPId.getNextUpdateTime().compareTo(new Date()) == 1) {
            return new SystemResult("���ڻ������޸ĸ���Ʒ����Ϣ,Ԥ����:" + new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��").format(new Date()) + "�����Խ����޸�");
        } else if (productWithBLOBs.getProductState().toString().equals(ProductStateEnum.DEL.getValue() + "")) { // �ж���Ʒ��״̬�Ƿ���ȷ
            return new SystemResult(100, "��Ʒ��״̬Ϊɾ��,��ʱ�����޸���Ϣ", null);
        } else if ((result = ProductBasicsAppoint.checkProductIsUser(productWithBLOBs, k2Member, SYSTEM_ROLE_PROVE)).getStatus() != 200) { // У����Ϣ
            return result;
        }

        // ��ղ����޸ĵ�����
        k2ProductWithBLOBs.editClearValue();
        // ��ȫ������Ϣ
        k2ProductWithBLOBs.setProductUpdateUsername(k2Member.getK2Member().getMemberAccount());
        k2ProductWithBLOBs.setProductUpdateUserid(k2Member.getK2Member().getMemberId());
        k2ProductWithBLOBs.setProductUpdateTime(new Date());

        // �޸���Ʒ��Ϣ
        k2ProductMapper.updateByPrimaryKeySelective(k2ProductWithBLOBs);
        // �޸ĳɹ��� �޸ĸ���Ʒ���һ�ε��޸�ʱ��
        K2ProductEditSize editSize = new K2ProductEditSize();
        editSize.setEditProductId(k2ProductWithBLOBs.getProductId());
        Date date = new Date();
        editSize.setLastUpdateTime(date);
        editSize.setLastUpdateUserId(k2Member.getK2Member().getMemberId());
        editSize.setLastUpdateUserNaem(k2Member.getK2Member().getMemberAccount());
        // �����������ʱ��
        long l = date.getTime() + (1000 * 60 * 60 * 24 * 3);
        editSize.setNextUpdateTime(new Date(l));
        k2ProductEditSizeMapper.insert(editSize);

        // �޸���Ʒ��������Ϣ
        K2ProductSketch sketch = new K2ProductSketch();
        sketch.setProductSketchId(k2ProductWithBLOBs.getProductSketchId());
        sketch.setProductSketchValue(k2ProductWithBLOBs.getProductSketchContent());
        k2ProductSketchMapper.updateByPrimaryKeySelective(sketch);


        // ��ѯ��Ʒ��Ϣ
        k2ProductWithBLOBs = k2ProductMapper.selectByPrimaryKey(k2ProductWithBLOBs.getProductId());
        // ����ɹ� ������д������ ͬ����Ϣ
        ProductBasicsAppoint.addProductInfoQueue(k2ProductWithBLOBs);

        return new SystemResult(200, "������Ʒ��Ϣ�ύ�ɹ�,�����ĵȴ�ϵͳȷ��~~~~");
    }

    /**
     * -----------------------------------------------------
     * ����:  �߼�ɾ����Ʒ��Ϣ
     * <p>
     * ����:
     * productId                Integer          ��ɾ������Ʒid
     * k2Member                   K2Member       �������û���Ϣ
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult delProductInfo(Integer productId, K2MemberAndElseInfo k2Member, Integer state) {

        // У����Ʒ״̬�Ƿ���ȷ
        if (state != ProductStateEnum.SJ.getValue() && state != ProductStateEnum.DEL.getValue()
                && state != ProductStateEnum.XJ.getValue())
            return new SystemResult(100, "����������,��ˢ��ҳ������", null);

        // ��ѯ����Ʒ��Ϣ�Ƿ����
        K2ProductWithBLOBs productWithBLOBs = k2ProductMapper.selectByPrimaryKey(productId);
        if (productWithBLOBs == null) return new SystemResult(100, "����Ʒ��Ϣ�����Ѿ���ɾ����Ŷ,��ˢ��ҳ������", null);

        // У����Ʒ��Ϣ
        SystemResult result = ProductBasicsAppoint.checkProductIsUser(productWithBLOBs, k2Member, SYSTEM_ROLE_PROVE);
        if (result.getStatus() != 200) return result;

        // �޸���Ʒ�����ݿ��е�����
        productWithBLOBs.setProductState(state);
        productWithBLOBs.setProductUpdateTime(new Date());
        productWithBLOBs.setProductUpdateUserid(k2Member.getK2Member().getMemberId());
        productWithBLOBs.setProductUpdateUsername(k2Member.getK2Member().getMemberAccount());
        k2ProductMapper.updateByPrimaryKeySelective(productWithBLOBs);

        // �޸ĳɹ��� ����з���ͬ������
        ProductBasicsAppoint.addSynchronizedProductGotoCache(productWithBLOBs);
        // ����ǻָ���Ʒ�Ļ� ��Ҫ���ж������
        if (state == ProductStateEnum.SJ.getValue()) {
            ProductBasicsAppoint.addProductInfoQueue(productWithBLOBs);
        }

        String message = "";
        if (state == ProductStateEnum.DEL.getValue()) {
            message = "����Ҫɾ������Ʒ��Ϣ�Ѿ��ύ,��ȴ�ϵͳȷ��";
        } else if (state == ProductStateEnum.SJ.getValue()) {
            message = "����Ҫ�ָ�����Ʒ��Ϣ�Ѿ��ύ,��ȴ�ϵͳȷ�ϡ�";
        } else {
            message = "����Ҫ�¼ܵ���Ʒ��Ϣ�Ѿ��ύ,��ȴ�ϵͳȷ�ϡ�";
        }
        return new SystemResult(message);
    }
}
