package com.king2.product.server.appoint;

import com.king2.product.server.dto.SystemFeedbackIndexDto;
import com.king2.product.server.dto.SystemStateDto;
import com.king2.product.server.enmu.SystemFeedbackEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * ϵͳ֪ͨί����
 */
public class SystemFeedbackAppoint {

    /**
     * ��ȡϵͳ֪ͨ��״̬
     *
     * @param dto
     */
    public static void getFeedBackState(SystemFeedbackIndexDto dto) {

        List<SystemStateDto> dtos = new ArrayList<>();
        // ��ȡö����Ϣ
        for (SystemFeedbackEnum value : SystemFeedbackEnum.values()) {
            SystemStateDto stateDto = new SystemStateDto();
            stateDto.setKey(value.getKey());
            stateDto.setValue(value.getValue());
            dtos.add(stateDto);
        }
        dto.setSystemStateDtos(dtos);
    }
}
