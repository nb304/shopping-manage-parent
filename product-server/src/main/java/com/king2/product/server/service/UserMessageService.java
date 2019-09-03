package com.king2.product.server.service;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;

/*=======================================================
	˵��:    �û���ϢService

	����		ʱ��					ע��
  	����		2019.08.25   			����
=======================================================*/
public interface UserMessageService {

    /**
     * -----------------------------------------------------
     * ����:  ����״̬������Ϣ��״̬
     * <p>
     * ����:
     * k2MemberAndElseInfo      K2MemberAndElseInfo     ������û���Ϣ
     * messageId                Integer                 ��Ϣ��id
     * statw                    String                  ��Ϣ��״̬
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    SystemResult messageRead(Integer messageId, K2MemberAndElseInfo k2MemberAndElseInfo, String state);

    /**
     * -----------------------------------------------------
     * ����:  ��ջ�ɾ��������Ϣ
     * <p>
     * ����:
     * state      String     ״̬
     * userId     Integer    �����˵�id
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    SystemResult clearOrReadMessage(String state, Integer userId);

}
