package com.king2.product.server.service;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;

/*=======================================================
	˵��:    ϵͳ��ҳ����Service

	����		ʱ��					ע��
  	����		2019.08.24   			����
=======================================================*/
public interface SystemIndexManageService {

    /**
     * -----------------------------------------------------
     * ����:  �̳�ϵͳ����ҳ��Ϣ
     * <p>
     * ����:
     * k2MemberAndElseInfo      K2MemberAndElseInfo     ������û���Ϣ
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    SystemResult systemIndex(K2MemberAndElseInfo k2MemberAndElseInfo);

}
