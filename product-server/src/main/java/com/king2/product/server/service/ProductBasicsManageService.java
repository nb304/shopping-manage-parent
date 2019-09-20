package com.king2.product.server.service;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.pojo.K2ProductWithBLOBs;
import com.king2.commons.result.SystemResult;

/*=======================================================
	˵��:    ��Ʒ��������Service

	����		ʱ��					ע��
  	����		2019.08.06   			����
=======================================================*/
public interface ProductBasicsManageService {

    /**
     * -----------------------------------------------------
     * ����:  �����Ʒ��SKU
     * <p>
     * ����:
     * skuJson          String          SKU��JSON����
     * state            String          �����Ƿ���Ҫ���������Ʒ��Ϣ  1��Ҫ  2����Ҫ
     * productInfo      String          ��Ʒ��JSON����
     * K2Member         K2Member        �������û���Ϣ
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    SystemResult addProductSku(String skuJson, String productInfo, String state, K2MemberAndElseInfo K2Member) throws Exception;


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
    SystemResult addProductPageInfo(K2MemberAndElseInfo k2Member) throws Exception;

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
    SystemResult getSkuInfoByCId(Integer cId , K2MemberAndElseInfo k2MemberAndElseInfo);

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
    SystemResult showEditGetProInfo(Integer productId, K2MemberAndElseInfo k2Member);

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
    SystemResult getProductImageByPId(Integer productId);

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
    SystemResult editProductInfo(K2ProductWithBLOBs k2ProductWithBLOBs, K2MemberAndElseInfo k2MemberAndElseInfo);

    /**
     * -----------------------------------------------------
     * ����:  �߼�ɾ����Ʒ��Ϣ
     * <p>
     * ����:
     * productId                Integer          ��ɾ������Ʒid
     * k2Member                   K2Member       �������û���Ϣ
     * state                    Integer          ��Ʒ״̬
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    SystemResult delProductInfo(Integer productId, K2MemberAndElseInfo k2MemberAndElseInfo, Integer state);



}
