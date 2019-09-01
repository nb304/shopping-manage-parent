package com.king2.product.server.service;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.dto.UserFeedbackIndexDto;

/*=======================================================
	˵��:     �û�����ʱ��Service

	����		ʱ��					ע��
  	����		2019.08.31   			����
=======================================================*/
public interface UserFeedbackManageService {

    /**
     * -----------------------------------------------------
     * ����:  �û���������ҳ��Ϣ
     * <p>
     * ����:
     * k2MemberAndElseInfo         K2MemberAndElseInfo        �������û���Ϣ
     * dto              UserFeedbackIndexDto ��ҳ����
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    SystemResult index(K2MemberAndElseInfo k2MemberAndElseInfo, UserFeedbackIndexDto dto);

    /**
     * -----------------------------------------------------
     * ����:  �ظ��û��ķ���
     * <p>
     * ����:
     * feedBackId         Integer        ��������Ϣid
     * k2MemberAndElseInfo              K2MemberAndElseInfo �������û�
     * content          String          �ظ�����Ϣ
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    SystemResult readUserFeedBack(Integer feedBackId, K2MemberAndElseInfo k2MemberAndElseInfo, String content);

    /**
     * -----------------------------------------------------
     * ����:   ��ѯ�����Ļظ���Ϣ
     * <p>
     * ����:
     * feedBackId         Integer        ��������Ϣid
     * k2MemberAndElseInfo              K2MemberAndElseInfo �������û�
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    SystemResult getReplyInfo(Integer feedBackId, K2MemberAndElseInfo k2MemberAndElseInfo);

    /**
     * -----------------------------------------------------
     * ����:   ��ѯ�����ĸ�����Ϣ
     * <p>
     * ����:
     * feedBackId         Integer        ��������Ϣid
     * k2MemberAndElseInfo              K2MemberAndElseInfo �������û�
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    SystemResult getFeedbackAccessory(Integer feedBackId, K2MemberAndElseInfo k2MemberAndElseInfo);

    /**
     * -----------------------------------------------------
     * ����:   ɾ���û���������
     * <p>
     * ����:
     * feedBackId         Integer        ��������Ϣid
     * k2MemberAndElseInfo              K2MemberAndElseInfo �������û�
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    SystemResult delFeedback(Integer feedBackId, K2MemberAndElseInfo k2MemberAndElseInfo);
}
