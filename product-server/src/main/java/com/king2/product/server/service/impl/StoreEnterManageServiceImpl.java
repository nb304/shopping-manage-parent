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
	说明:    店铺入驻管理Service实现类

	作者		时间					注释
  	俞烨		2019.09.02   		创建
=======================================================*/
@Service
@SuppressWarnings("all")
public class StoreEnterManageServiceImpl implements StoreEnterManageService {

    // 注入管理员标识符
    @Value("${SYSTEM_ROLE_PROVE}")
    private String SYSTEM_ROLE_PROVE;
    // 注入本地店铺入住的Mapper
    @Autowired
    private StoreEnterMapper storeEnterMapper;
    // 注入远程的商品入住Mapper
    @Autowired
    private StoreEnterAppoint storeEnterAppoint;
    // 注入店铺Mapper
    @Autowired
    private K2StoreCheckMapper k2StoreCheckMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(StoreEnterManageServiceImpl.class);


    /**
     * -----------------------------------------------------
     * 功能:  显示商品入驻的主页信息
     * <p>
     * 参数:
     * dto              StoreEntryIndexDto          分页的数据信息
     * k2MemberAndElseInfo  K2MemberAndElseInfo     登入的用户信息
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult index(StoreEntryIndexDto dto, K2MemberAndElseInfo k2MemberAndElseInfo) {


        // 判断当前登入的用户是否是超级管理员
        boolean isAdminRole = checkCurrentUserIsAdminRole(k2MemberAndElseInfo);
        if (!isAdminRole) return new SystemResult(100, "该功能暂时没有开放到您。");

        // 校验时间和其他信息
        checkTimeOrElseInfo(dto);

        // 获取总条数
        int totalCount = storeEnterMapper.getStoreEnterCount(
                StringUtils.isEmpty(dto.getState()) ? null : Integer.parseInt(dto.getState()),
                dto.getStartTime(), dto.getEndTime()
        );
        dto.setTotalSize(totalCount);

        // 求出总页数
        int totalPage = (totalCount + dto.getCurrentSize() - 1) / dto.getCurrentSize();
        dto.setTotlaPage(totalPage);

        // 查看当前页数是否大于总页数
        if (dto.getCurrentPage() > totalPage) dto.setCurrentPage(totalPage);

        // 计算出索引值
        int index = (dto.getCurrentPage() - 1) < 0 ? 0 : (dto.getCurrentPage() - 1) * dto.getCurrentSize();

        // 查询值
        List<K2StoreCheck> storeEnterDatas = storeEnterMapper.getStoreEnterDatas(
                StringUtils.isEmpty(dto.getState()) ? null : Integer.parseInt(dto.getState()),
                dto.getStartTime(), dto.getEndTime(), index, dto.getCurrentSize()
        );
        storeEnterDatas.forEach((data) -> {
            data.setStoreCheckCreateTimeStr(UserMessageAppoint.sdf.format(data.getStoreCheckCreateTime()));
            data.setStoreCheckDisposeName(StringUtils.isEmpty(data.getStoreCheckDisposeName()) ? "暂未处理" : data.getStoreCheckDisposeName());
        });
        dto.setStoreDatas(storeEnterDatas);

        // 获取店铺入驻的状态信息
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
     * 功能:  通过状态修改店铺入驻的信息
     * <p>
     * 参数:
     * k2MemberAndElseInfo  K2MemberAndElseInfo     登入的用户信息
     * storeEnterId         Integer                 店铺入驻的id
     * state                Integer                 状态
     * content              String                  如果状态为拒绝  那么拒绝的理由是什么
     * <p>
     * 返回: SystemResult               返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public SystemResult editEnterState(K2MemberAndElseInfo k2MemberAndElseInfo, Integer storeEnterId, Integer state, String content) {

        // 判断当前登入的用户是否是超级管理员
        boolean isAdminRole = checkCurrentUserIsAdminRole(k2MemberAndElseInfo);
        if (!isAdminRole) return new SystemResult(100, "该功能暂时没有开放到您。");

        // 开启锁
        synchronized (LOGGER) {
            // 校验信息
            SystemResult checkResult = storeEnterAppoint
                    .checkStoreInfoAndReturnResult(state, storeEnterId, content , k2MemberAndElseInfo);
            if (checkResult.getStatus() != 200) return checkResult;
            // 校验通过取出信息
            K2StoreCheck k2StoreCheck = (K2StoreCheck) checkResult.getData();
            k2StoreCheckMapper.updateByPrimaryKeySelective(k2StoreCheck);

            // 操作其他信息
            SystemResult result = storeEnterAppoint.functionStoreByState(k2StoreCheck, content);
        }
        return new SystemResult("ok");
    }

    /**
     * 判断当前登入的用户是否是超级管理员
     *
     * @param k2MemberAndElseInfo
     * @return
     */
    public boolean checkCurrentUserIsAdminRole(K2MemberAndElseInfo k2MemberAndElseInfo) {

        // 定义是否是超级管理员的标志
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
     * 校验时间和其他信息
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

        // 校验其他信息
        if (StringUtils.isEmpty(dto.getState())) {
            dto.setState(null);
        } else if (!dto.getState().equals(StoreEnterStateEnum.TG.getValue() + "") &&
                !dto.getState().equals(StoreEnterStateEnum.WCL.getValue() + "") &&
                !dto.getState().equals(StoreEnterStateEnum.WTG.getValue() + "")) {
            dto.setState(null);
        }
    }
}
