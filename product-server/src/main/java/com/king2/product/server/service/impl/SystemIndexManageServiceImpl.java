package com.king2.product.server.service.impl;

import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.SystemIndexManageAppiont;
import com.king2.product.server.service.SystemIndexManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/*=======================================================
	˵��:    ϵͳ��ҳ����Serviceʵ����

	����		ʱ��					ע��
  	����		2019.08.24   			����
=======================================================*/
@Service
public class SystemIndexManageServiceImpl implements SystemIndexManageService {


    // ע����ҳ����ί����
    @Autowired
    private SystemIndexManageAppiont systemIndexManageAppiont;

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
    @Override
    public SystemResult systemIndex(K2MemberAndElseInfo k2MemberAndElseInfo) {

        // ��ѯ��Ʒ��ҳ����Ϣ
        // ��������ϵͳ����Ա����������ɫ��Ϣ ��ѯ����Ϣ

        // ��ѯ���û�����Ϣ
        SystemResult userMeesageCacheById = systemIndexManageAppiont.getMessageByUserId(k2MemberAndElseInfo.getK2Member().getMemberId());
        return userMeesageCacheById;
    }

}
