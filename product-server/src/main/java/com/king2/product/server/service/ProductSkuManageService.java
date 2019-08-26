package com.king2.product.server.service;

import com.king2.commons.result.SystemResult;

/*=======================================================
	˵��:    ��ƷSKU����Service

	����		ʱ��					ע��
  	����		2019.08.21   			����
=======================================================*/
public interface ProductSkuManageService {


    /**
     * -----------------------------------------------------
     * ����:   ������Ʒid��ȡ����Ʒ��SKU��Ϣ����
     * <p>
     * ����:
     * productId          Integer         ��ƷID
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    SystemResult getSkuByProductId(Integer productId);

    /**
     * -----------------------------------------------------
     * ����:   �޸���ƷSKU��Ϣ
     * <p>
     * ����:
     * skuKcInfo          String         ��ƷSKU����Ϣ
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    SystemResult editSkuInfo(String skuKcInfo);
}
