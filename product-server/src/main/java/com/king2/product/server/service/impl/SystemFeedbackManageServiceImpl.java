package com.king2.product.server.service.impl;

import com.king2.commons.mapper.K2SystemCommonStateMapper;
import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.pojo.K2SystemCommonState;
import com.king2.commons.pojo.K2SystemCommonStateExample;
import com.king2.commons.pojo.K2SystemFeedback;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.SystemFeedbackAppoint;
import com.king2.product.server.dto.SystemFeedbackIndexDto;
import com.king2.product.server.enmu.SystemFeedbackEnum;
import com.king2.product.server.mapper.SystemFeedbackMapper;
import com.king2.product.server.service.SystemFeedbackManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/*=======================================================
	˵��:    ϵͳ֪ͨ����Serviceʵ����

	����		ʱ��					ע��
  	����		2019.09.01   			����
=======================================================*/
@Service
@SuppressWarnings("all")
public class SystemFeedbackManageServiceImpl implements SystemFeedbackManageService {

    // ע�뱾�ص�ϵͳ֪ͨMapper
    @Autowired
    private SystemFeedbackMapper systemFeedbackMapper;

    // ע��Զ�̵Ĺ���֪ͨ��Ϣ
    @Autowired
    private K2SystemCommonStateMapper k2SystemCommonStateMapper;

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
    @Override
    public SystemResult index(K2MemberAndElseInfo k2MemberAndElseInfo, SystemFeedbackIndexDto dto) {

        // ��ȡϵͳ��״̬
        SystemFeedbackAppoint.getFeedBackState(dto);

        //У��ʱ��
        checkTime(dto);

        // ��ѯ������
        List<K2SystemFeedback> systemFeedbackCount = systemFeedbackMapper.getSystemFeedbackCount(dto.getState(), dto.getStartTime());

        // ��ѯ���û��Թ�����Ϣ��״̬��Ϣ
        K2SystemCommonStateExample example = new K2SystemCommonStateExample();
        K2SystemCommonStateExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(k2MemberAndElseInfo.getK2Member().getMemberId());
        if (dto.getState() != null) {
            criteria.andStateEqualTo(dto.getState());
        }
        List<K2SystemCommonState> k2SystemCommonStates = k2SystemCommonStateMapper.selectByExample(example);

        // �����µ�֪ͨ����
        List<K2SystemFeedback> newSystemFeedback = new ArrayList<>();

        // ���˵�û��Թ�����֪ͨû�в����Ļ�  �Ǿ���˵�� ������Щ����
        if (CollectionUtils.isEmpty(k2SystemCommonStates)) {
            newSystemFeedback = CollectionUtils.isEmpty(systemFeedbackCount) ? new ArrayList<>() : systemFeedbackCount;
        } else {
            for (K2SystemFeedback systemFeedback : systemFeedbackCount) {
                if ((SystemFeedbackEnum.IS_COMMON_YES.getValue() + "").equals(systemFeedback.getIsCommon())) {
                    for (K2SystemCommonState k2SystemCommonState : k2SystemCommonStates) {
                        if (systemFeedback.getSystemFeedbackId().toString()
                                .equals(k2SystemCommonState.getBelongSystemId() + "") && !k2SystemCommonState.getState().toString().equals(3)) {
                            if (dto.getState() == null) {
                                newSystemFeedback.add(systemFeedback);
                                break;
                            } else if (k2SystemCommonState.getState().toString().equals(dto.getState())) {
                                newSystemFeedback.add(systemFeedback);
                                break;
                            }

                        }
                    }
                } else if (!(SystemFeedbackEnum.IS_COMMON_YES.getValue() + "").equals(systemFeedback.getIsCommon())) {
                    newSystemFeedback.add(systemFeedback);
                    break;
                }
            }
        }

        // ������
        dto.setTotalSize(newSystemFeedback.size());

        // �����ҳ��
        int totalPage = (dto.getTotalSize() + dto.getCurrentSize() - 1) / dto.getCurrentSize();
        dto.setTotlaPage(totalPage);

        // �鿴��ǰҳ���Ƿ������ҳ��
        if (dto.getCurrentPage() > totalPage) dto.setCurrentPage(totalPage);

        // ���������ֵ
        int index = (dto.getCurrentPage() - 1) < 0 ? 0 : (dto.getCurrentPage() - 1) * dto.getCurrentSize();

        // ����� ������Ҫ������


        return null;
    }

    /**
     * У��ʱ��
     *
     * @param dto
     */
    public static void checkTime(SystemFeedbackIndexDto dto) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (StringUtils.isEmpty(dto.getStartTimeStr())) {
            dto.setStartTime(null);
        } else if (!StringUtils.isEmpty(dto.getStartTimeStr())) {
            dto.setStartTimeStr(dto.getStartTimeStr() + " 00:00:00");
            try {
                dto.setStartTime(sdf.parse(dto.getStartTimeStr()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
