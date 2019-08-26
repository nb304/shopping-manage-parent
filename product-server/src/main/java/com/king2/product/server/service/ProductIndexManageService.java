package com.king2.product.server.service;

import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.dto.ProductIndexDto;

/*=======================================================
	˵��:    ��Ʒ��ҳ����Service

	����		ʱ��					ע��
  	����		2019.08.11   			����
=======================================================*/
public interface ProductIndexManageService {

    /**
     * -----------------------------------------------------
     * ����:  ��ʾ��Ʒ����ҳ
     * <p>
     * ����:
     * k2MemberAndElseInfo         K2MemberAndElseInfo        �������û���Ϣ
     * dto              ProductIndexDto ��ҳ����
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    SystemResult index(K2MemberAndElseInfo k2MemberAndElseInfo, ProductIndexDto dto);
}
