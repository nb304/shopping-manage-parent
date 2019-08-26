package com.king2.product.server.service;

import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;

/*=======================================================
	˵��:    ��ƷSPU����Service

	����		ʱ��					ע��
  	����		2019.08.20   			����
=======================================================*/
public interface ProductSpuManageService {

    /**
     * -----------------------------------------------------
     * ����:  ��ѯ��Ʒ��SPU����
     * <p>
     * ����:
     * productId        String          ��Ʒid
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    SystemResult getSpuByPId(Integer productId);

    /**
     * -----------------------------------------------------
     * ����:  �߼�ɾ����Ʒ��SPU��Ϣ
     * <p>
     * ����:
     * spuId        String          ��Ʒ��SPUid
     * k2Member     K2Member        �������û���Ϣ
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    SystemResult delSpuById(Integer spuId, K2MemberAndElseInfo k2Member);

    /**
     * -----------------------------------------------------
     * ����:  �ָ�SPU����Ϣ
     * <p>
     * ����:
     * spuId        String          ��Ʒ��SPUid
     * k2Member     K2Member        �������û���Ϣ
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    SystemResult recoverNormal(Integer spuId, K2MemberAndElseInfo k2Member);

    /**
     * -----------------------------------------------------
     * ����:  ����ע����Ʒ��SPU��Ϣ
     * <p>
     * ����:
     * spuIds        String         ��Ʒ��SPUIds
     * k2Member     K2Member        �������û���Ϣ
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    SystemResult batchCancelSpu(String spuIds, K2MemberAndElseInfo k2Member);

    /**
     * -----------------------------------------------------
     * ����:  �޸���Ʒ��������Ϣ
     * <p>
     * ����:
     * spuKey        String         ��Ʒ��SPU������
     * skuValue      String         ��Ʒ�Ĳ���ֵ
     * productSpuId  String         ��Ʒ������Id
     * k2Member     K2Member        �������û���Ϣ
     * order        Integer         ����
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    SystemResult editSpuInfo(String spuKey, String skuValue, Integer order, Integer productSpuId, K2MemberAndElseInfo k2Member);

    /**
     * -----------------------------------------------------
     * ����:  �����Ʒ��SPU��Ϣ
     * <p>
     * ����:
     * productSpuJson         String            ��Ʒ��SPU��Ϣ
     * productId              Integer           ��Ʒ��id
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    SystemResult addProductSpu(String productSpuJson, Integer productId, K2MemberAndElseInfo k2Member);
}
