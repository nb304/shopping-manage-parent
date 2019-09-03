package com.king2.product.server.appoint;

import com.king2.product.server.dto.SystemFeedbackIndexDto;
import com.king2.product.server.dto.SystemStateDto;
import com.king2.product.server.enmu.SystemFeedbackEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统通知委托类
 */
public class SystemFeedbackAppoint {

    /**
     * 获取系统通知的状态
     *
     * @param dto
     */
    public static void getFeedBackState(SystemFeedbackIndexDto dto) {

        List<SystemStateDto> dtos = new ArrayList<>();
        // 获取枚举信息
        for (SystemFeedbackEnum value : SystemFeedbackEnum.values()) {
            SystemStateDto stateDto = new SystemStateDto();
            stateDto.setKey(value.getKey());
            stateDto.setValue(value.getValue());
            dtos.add(stateDto);
        }
        dto.setSystemStateDtos(dtos);
    }
}
