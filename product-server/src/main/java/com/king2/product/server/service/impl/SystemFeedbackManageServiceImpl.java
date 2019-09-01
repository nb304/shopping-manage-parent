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
	说明:    系统通知管理Service实现类

	作者		时间					注释
  	俞烨		2019.09.01   			创建
=======================================================*/
@Service
@SuppressWarnings("all")
public class SystemFeedbackManageServiceImpl implements SystemFeedbackManageService {

    // 注入本地的系统通知Mapper
    @Autowired
    private SystemFeedbackMapper systemFeedbackMapper;

    // 注入远程的公共通知消息
    @Autowired
    private K2SystemCommonStateMapper k2SystemCommonStateMapper;

    /**
     * -----------------------------------------------------
     * 功能:  系统通知首页
     * <p>
     * 参数:
     * k2MemberAndElseInfo          K2MemberAndElseInfo         操作的用户
     * dto                          SystemFeedbackIndexDto      系统通知Dto
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult index(K2MemberAndElseInfo k2MemberAndElseInfo, SystemFeedbackIndexDto dto) {

        // 获取系统的状态
        SystemFeedbackAppoint.getFeedBackState(dto);

        //校验时间
        checkTime(dto);

        // 查询总数据
        List<K2SystemFeedback> systemFeedbackCount = systemFeedbackMapper.getSystemFeedbackCount(dto.getState(), dto.getStartTime());

        // 查询该用户对公共消息的状态信息
        K2SystemCommonStateExample example = new K2SystemCommonStateExample();
        K2SystemCommonStateExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(k2MemberAndElseInfo.getK2Member().getMemberId());
        if (dto.getState() != null) {
            criteria.andStateEqualTo(dto.getState());
        }
        List<K2SystemCommonState> k2SystemCommonStates = k2SystemCommonStateMapper.selectByExample(example);

        // 创建新的通知集合
        List<K2SystemFeedback> newSystemFeedback = new ArrayList<>();

        // 如果说用户对公共的通知没有操作的话  那就是说明 就是这些数据
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

        // 总数量
        dto.setTotalSize(newSystemFeedback.size());

        // 算出总页数
        int totalPage = (dto.getTotalSize() + dto.getCurrentSize() - 1) / dto.getCurrentSize();
        dto.setTotlaPage(totalPage);

        // 查看当前页数是否大于总页数
        if (dto.getCurrentPage() > totalPage) dto.setCurrentPage(totalPage);

        // 计算出索引值
        int index = (dto.getCurrentPage() - 1) < 0 ? 0 : (dto.getCurrentPage() - 1) * dto.getCurrentSize();

        // 计算出 本次需要的数据


        return null;
    }

    /**
     * 校验时间
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
