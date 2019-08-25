package com.king2.product.server.service;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.dto.BrandIndexManageDto;

/*=======================================================
	˵��:    ��ƷƷ�ƹ���Service

	����		ʱ��					ע��
  	����		2019.08.25   			����
=======================================================*/
public interface BrandManageService {


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
    SystemResult index(K2MemberAndElseInfo k2MemberAndElseInfo, BrandIndexManageDto dto);

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
    SystemResult addBrand(String brandName, K2MemberAndElseInfo k2MemberAndElseInfo);
}
