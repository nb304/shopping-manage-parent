package com.king2.product.server.service;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.dto.SystemFeedbackIndexDto;

/*=======================================================
	˵��:    ϵͳ֪ͨ����Service

	����		ʱ��					ע��
  	����		2019.09.01   			����
=======================================================*/
public interface SystemFeedbackManageService {

    /**
     * -----------------------------------------------------
     * ����:  ϵͳ֪ͨ��ҳ
     * <p>
     * ����:
     * k2MemberAndElseInfo          K2MemberAndElseInfo         �������û�
     * dto                          SystemFeedbackIndexDto      ϵͳ֪ͨDto
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    SystemResult index(K2MemberAndElseInfo k2MemberAndElseInfo, SystemFeedbackIndexDto dto);
}
