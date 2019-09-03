package com.king2.product.server.service.impl;

import com.king2.commons.mapper.K2StoreCheckMapper;
import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.pojo.K2Role;
import com.king2.commons.pojo.K2StoreCheck;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.StoreEnterAppoint;
import com.king2.product.server.appoint.UserMessageAppoint;
import com.king2.product.server.dto.StoreEntryIndexDto;
import com.king2.product.server.dto.SystemStateDto;
import com.king2.product.server.enmu.StoreEnterStateEnum;
import com.king2.product.server.mapper.StoreEnterMapper;
import com.king2.product.server.service.StoreEnterManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/*=======================================================
	˵��:    ������פ����Serviceʵ����

	����		ʱ��					ע��
  	����		2019.09.02   		����
=======================================================*/
@Service
@SuppressWarnings("all")
public class StoreEnterManageServiceImpl implements StoreEnterManageService {

    // ע�����Ա��ʶ��
    @Value("${SYSTEM_ROLE_PROVE}")
    private String SYSTEM_ROLE_PROVE;
    // ע�뱾�ص�����ס��Mapper
    @Autowired
    private StoreEnterMapper storeEnterMapper;
    // ע��Զ�̵���Ʒ��סMapper
    @Autowired
    private StoreEnterAppoint storeEnterAppoint;
    // ע�����Mapper
    @Autowired
    private K2StoreCheckMapper k2StoreCheckMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(StoreEnterManageServiceImpl.class);


    /**
     * -----------------------------------------------------
     * ����:  ��ʾ��Ʒ��פ����ҳ��Ϣ
     * <p>
     * ����:
     * dto              StoreEntryIndexDto          ��ҳ��������Ϣ
     * k2MemberAndElseInfo  K2MemberAndElseInfo     ������û���Ϣ
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult index(StoreEntryIndexDto dto, K2MemberAndElseInfo k2MemberAndElseInfo) {


        // �жϵ�ǰ������û��Ƿ��ǳ�������Ա
        boolean isAdminRole = checkCurrentUserIsAdminRole(k2MemberAndElseInfo);
        if (!isAdminRole) return new SystemResult(100, "�ù�����ʱû�п��ŵ�����");

        // У��ʱ���������Ϣ
        checkTimeOrElseInfo(dto);

        // ��ȡ������
        int totalCount = storeEnterMapper.getStoreEnterCount(
                StringUtils.isEmpty(dto.getState()) ? null : Integer.parseInt(dto.getState()),
                dto.getStartTime(), dto.getEndTime()
        );
        dto.setTotalSize(totalCount);

        // �����ҳ��
        int totalPage = (totalCount + dto.getCurrentSize() - 1) / dto.getCurrentSize();
        dto.setTotlaPage(totalPage);

        // �鿴��ǰҳ���Ƿ������ҳ��
        if (dto.getCurrentPage() > totalPage) dto.setCurrentPage(totalPage);

        // ���������ֵ
        int index = (dto.getCurrentPage() - 1) < 0 ? 0 : (dto.getCurrentPage() - 1) * dto.getCurrentSize();

        // ��ѯֵ
        List<K2StoreCheck> storeEnterDatas = storeEnterMapper.getStoreEnterDatas(
                StringUtils.isEmpty(dto.getState()) ? null : Integer.parseInt(dto.getState()),
                dto.getStartTime(), dto.getEndTime(), index, dto.getCurrentSize()
        );
        storeEnterDatas.forEach((data) -> {
            data.setStoreCheckCreateTimeStr(UserMessageAppoint.sdf.format(data.getStoreCheckCreateTime()));
            data.setStoreCheckDisposeName(StringUtils.isEmpty(data.getStoreCheckDisposeName()) ? "��δ����" : data.getStoreCheckDisposeName());
        });
        dto.setStoreDatas(storeEnterDatas);

        // ��ȡ������פ��״̬��Ϣ
        List<SystemStateDto> dtos = new ArrayList<>();
        for (StoreEnterStateEnum value : StoreEnterStateEnum.values()) {
            SystemStateDto dto1 = new SystemStateDto();
            dto1.setKey(value.getKey());
            dto1.setValue(value.getValue());
            dtos.add(dto1);
        }
        dto.setDtos(dtos);
        return new SystemResult(dto);
    }

    /**
     * -----------------------------------------------------
     * ����:  ͨ��״̬�޸ĵ�����פ����Ϣ
     * <p>
     * ����:
     * k2MemberAndElseInfo  K2MemberAndElseInfo     ������û���Ϣ
     * storeEnterId         Integer                 ������פ��id
     * state                Integer                 ״̬
     * content              String                  ���״̬Ϊ�ܾ�  ��ô�ܾ���������ʲô
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public SystemResult editEnterState(K2MemberAndElseInfo k2MemberAndElseInfo, Integer storeEnterId, Integer state, String content) {

        // �жϵ�ǰ������û��Ƿ��ǳ�������Ա
        boolean isAdminRole = checkCurrentUserIsAdminRole(k2MemberAndElseInfo);
        if (!isAdminRole) return new SystemResult(100, "�ù�����ʱû�п��ŵ�����");

        // ������
        synchronized (LOGGER) {
            // У����Ϣ
            SystemResult checkResult = storeEnterAppoint
                    .checkStoreInfoAndReturnResult(state, storeEnterId, content , k2MemberAndElseInfo);
            if (checkResult.getStatus() != 200) return checkResult;
            // У��ͨ��ȡ����Ϣ
            K2StoreCheck k2StoreCheck = (K2StoreCheck) checkResult.getData();
            k2StoreCheckMapper.updateByPrimaryKeySelective(k2StoreCheck);

            // ����������Ϣ
            SystemResult result = storeEnterAppoint.functionStoreByState(k2StoreCheck, content);
        }
        return new SystemResult("ok");
    }

    /**
     * �жϵ�ǰ������û��Ƿ��ǳ�������Ա
     *
     * @param k2MemberAndElseInfo
     * @return
     */
    public boolean checkCurrentUserIsAdminRole(K2MemberAndElseInfo k2MemberAndElseInfo) {

        // �����Ƿ��ǳ�������Ա�ı�־
        boolean flag = false;
        for (K2Role k2Role : k2MemberAndElseInfo.getK2Roles()) {
            if (SYSTEM_ROLE_PROVE.equals(k2Role.getRetain1())) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * У��ʱ���������Ϣ
     *
     * @param dto
     */
    public static void checkTimeOrElseInfo(StoreEntryIndexDto dto) {
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

        if (StringUtils.isEmpty(dto.getEndTimeStr())) {
            dto.setEndTime(null);
        } else if (!StringUtils.isEmpty(dto.getEndTimeStr())) {
            dto.setEndTimeStr(dto.getEndTimeStr() + " 23:59:59");
            try {
                dto.setEndTime(sdf.parse(dto.getEndTimeStr()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // У��������Ϣ
        if (StringUtils.isEmpty(dto.getState())) {
            dto.setState(null);
        } else if (!dto.getState().equals(StoreEnterStateEnum.TG.getValue() + "") &&
                !dto.getState().equals(StoreEnterStateEnum.WCL.getValue() + "") &&
                !dto.getState().equals(StoreEnterStateEnum.WTG.getValue() + "")) {
            dto.setState(null);
        }
    }
}
