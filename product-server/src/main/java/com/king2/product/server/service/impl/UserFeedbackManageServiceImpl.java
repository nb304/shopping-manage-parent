package com.king2.product.server.service.impl;

import com.king2.commons.mapper.K2FeedbackAccessoryMapper;
import com.king2.commons.mapper.K2FeedbackReplyMapper;
import com.king2.commons.mapper.K2MessageMapper;
import com.king2.commons.mapper.K2UserFeedbackMapper;
import com.king2.commons.pojo.*;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.UserFeedbackAppoint;
import com.king2.product.server.appoint.UserMessageAppoint;
import com.king2.product.server.dto.UserFeedbackIndexDto;
import com.king2.product.server.enmu.UserFeedbackEnum;
import com.king2.product.server.mapper.UserFeedbackMapper;
import com.king2.product.server.service.UserFeedbackManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.List;

/*=======================================================
	说明:     用户反馈时间Service实现类

	作者		时间					注释
  	俞烨		2019.08.31   			创建
=======================================================*/
@Service
@SuppressWarnings("all")
public class UserFeedbackManageServiceImpl implements UserFeedbackManageService {

    // 注入系统超级管理员标识
    @Value("${SYSTEM_ROLE_PROVE}")
    private String SYSTEM_ROLE_PROVE;
    // 注入本地的反馈编号Mapper
    @Autowired
    private UserFeedbackMapper userFeedbackMapper;
    // 注入反馈委托类
    @Autowired
    private UserFeedbackAppoint userFeedbackAppoint;
    // 注入反馈Mapper
    @Autowired
    private K2UserFeedbackMapper k2UserFeedbackMapper;
    // 注入反馈回复表
    @Autowired
    private K2FeedbackReplyMapper k2FeedbackReplyMapper;
    // 注入消息表
    @Autowired
    private K2MessageMapper k2MessageMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFeedbackManageServiceImpl.class);

    // 注入反馈附件表
    @Autowired
    private K2FeedbackAccessoryMapper k2FeedbackAccessoryMapper;

    /**
     * -----------------------------------------------------
     * 功能:  用户反馈的主页信息
     * <p>
     * 参数:
     * k2MemberAndElseInfo         K2MemberAndElseInfo        操作的用户信息
     * dto              UserFeedbackIndexDto 分页数据
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult index(K2MemberAndElseInfo k2MemberAndElseInfo, UserFeedbackIndexDto dto) {

        // 校验是否是超级管理员  因为这个界面暂时来说只能超级管理员进入 其他角色信息是无法进入的
        Boolean adminRole = isAdminRole(SYSTEM_ROLE_PROVE, k2MemberAndElseInfo);
        if (!adminRole) return new SystemResult(100, "该功能暂时没有开发到您");

        // 校验时间
        checkTime(dto);

        // 是超级管理员 我们就去查询反馈的数量
        String number = // 商品编号
                StringUtils.isEmpty(dto.getFeedNumber()) ? null : dto.getFeedNumber();
        String userName = // 反馈人的信息
                StringUtils.isEmpty(dto.getUserName()) ? null : dto.getUserName();
        String userFeedbackState =
                StringUtils.isEmpty(dto.getState()) ? null : dto.getState();
        int feedbackCount = userFeedbackMapper.getFeedbackCount(number, userName, userFeedbackState, dto.getStartTime(), dto.getEndTime());

        // 总数量
        dto.setTotalSize(feedbackCount);

        // 求出总页数
        int totalPage = (feedbackCount + dto.getCurrentSize() - 1) / dto.getCurrentSize();
        dto.setTotlaPage(totalPage);

        // 查看当前页数是否大于总页数
        if (dto.getCurrentPage() > totalPage) dto.setCurrentPage(totalPage);

        // 计算出索引值
        int index = (dto.getCurrentPage() - 1) < 0 ? 0 : (dto.getCurrentPage() - 1) * dto.getCurrentSize();


        // 查询值
        List<K2UserFeedback> feedbackDatas = userFeedbackMapper.getFeedbackDatas(
                number, userName, userFeedbackState, dto.getStartTime(), dto.getEndTime(), index, dto.getCurrentSize()
        );

        // 查询状态
        feedbackDatas.forEach((n) -> {
            if (n.getUserFeedbackState().toString().equals(UserFeedbackEnum.CLZ.getValue() + "")) {
                n.setStateStr(UserFeedbackEnum.CLZ.getKey());
            } else if (n.getUserFeedbackState().toString().equals(UserFeedbackEnum.DEL.getValue() + "")) {
                n.setStateStr(UserFeedbackEnum.DEL.getKey());
            } else if (n.getUserFeedbackState().toString().equals(UserFeedbackEnum.YCL.getValue() + "")) {
                n.setStateStr(UserFeedbackEnum.YCL.getKey());
            } else {
                n.setStateStr("未知状态");
            }
            n.setCreateTimeStr(UserMessageAppoint.sdf.format(n.getCreateTime()));
            n.setRetain1(StringUtils.isEmpty(n.getRetain1()) ? "暂未处理" : n.getRetain1());
            n.setUserConnection(StringUtils.isEmpty(n.getUserConnection()) ? "暂无" : n.getUserConnection());
        });

        dto.setFeedbackDatas(feedbackDatas);
        return new SystemResult(dto);
    }

    /**
     * -----------------------------------------------------
     * 功能:  回复用户的反馈
     * <p>
     * 参数:
     * feedBackId         Integer        反馈的信息id
     * k2MemberAndElseInfo              K2MemberAndElseInfo 操作的用户
     * content          String          回复的消息
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public SystemResult readUserFeedBack(Integer feedBackId, K2MemberAndElseInfo k2MemberAndElseInfo, String content) {

        // 校验是否是管理员
        Boolean adminRole = isAdminRole(SYSTEM_ROLE_PROVE, k2MemberAndElseInfo);
        if (!adminRole) return new SystemResult(100, "该功能暂时没有开发到您");
        synchronized (LOGGER) {
            // 查看反馈信息是否存在
            SystemResult result = userFeedbackAppoint.checkUserFeedbackInfo(feedBackId);
            if (result.getStatus() != 200) return result;
            K2UserFeedback userFeedback = (K2UserFeedback) result.getData();

            // 校验通过 校验本次信息是否正确 正确就返回正确数据
            SystemResult checkReplyResult = userFeedbackAppoint.checkReplyInfo(content, feedBackId);
            if (checkReplyResult.getStatus() != 200) return checkReplyResult;
            K2FeedbackReply reply = (K2FeedbackReply) checkReplyResult.getData();

            // 修改对应的信息
            userFeedback.setUserFeedbackState(UserFeedbackEnum.YCL.getValue());
            userFeedback.setUserFeedbackResult(k2MemberAndElseInfo.getK2Member().getMemberId());
            k2UserFeedbackMapper.updateByPrimaryKeySelective(userFeedback);

            // 插入对应的处理信息
            k2FeedbackReplyMapper.insert(reply);

            // 给用户发送信息
            UserMessageAppoint.addMessageGotoMysql("您的举报编号:" + userFeedback.getUserFeedbackNumber() + "已回复:<br />" + content, userFeedback.getUserId(), k2MessageMapper);
        }
        return new SystemResult("回复成功");
    }

    /**
     * -----------------------------------------------------
     * 功能:   查询反馈的回复信息
     * <p>
     * 参数:
     * feedBackId         Integer        反馈的信息id
     * k2MemberAndElseInfo              K2MemberAndElseInfo 操作的用户
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult getReplyInfo(Integer feedBackId, K2MemberAndElseInfo k2MemberAndElseInfo) {

        // 校验是否是管理员
        Boolean adminRole = isAdminRole(SYSTEM_ROLE_PROVE, k2MemberAndElseInfo);
        if (!adminRole) return new SystemResult(100, "该功能暂时没有开发到您");

        K2FeedbackReplyExample example = new K2FeedbackReplyExample();
        example.createCriteria().andFeedbackIdEqualTo(feedBackId);
        List<K2FeedbackReply> k2FeedbackReplies = k2FeedbackReplyMapper.selectByExampleWithBLOBs(example);
        // 校验数据是否存在
        if (CollectionUtils.isEmpty(k2FeedbackReplies)) {
            return new SystemResult(100, "加载失败,请刷新页面重试");
        }

        return new SystemResult(k2FeedbackReplies.get(0));
    }

    /**
     * -----------------------------------------------------
     * 功能:   查询反馈的附件信息
     * <p>
     * 参数:
     * feedBackId         Integer        反馈的信息id
     * k2MemberAndElseInfo              K2MemberAndElseInfo 操作的用户
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult getFeedbackAccessory(Integer feedBackId, K2MemberAndElseInfo k2MemberAndElseInfo) {

        // 校验是否是管理员
        Boolean adminRole = isAdminRole(SYSTEM_ROLE_PROVE, k2MemberAndElseInfo);
        if (!adminRole) return new SystemResult(100, "该功能暂时没有开发到您");

        K2FeedbackAccessoryExample example = new K2FeedbackAccessoryExample();
        example.createCriteria().andBelongUserBackIdEqualTo(feedBackId);
        List<K2FeedbackAccessory> k2FeedbackAccessories = k2FeedbackAccessoryMapper.selectByExampleWithBLOBs(example);

        return new SystemResult(k2FeedbackAccessories);
    }

    /**
     * -----------------------------------------------------
     * 功能:   删除用户反馈功能
     * <p>
     * 参数:
     * feedBackId         Integer        反馈的信息id
     * k2MemberAndElseInfo              K2MemberAndElseInfo 操作的用户
     * <p>
     * 返回: SystemResult              返回调用者的数据
     * -----------------------------------------------------
     */
    @Override
    public SystemResult delFeedback(Integer feedBackId, K2MemberAndElseInfo k2MemberAndElseInfo) {

        // 校验是否是管理员
        Boolean adminRole = isAdminRole(SYSTEM_ROLE_PROVE, k2MemberAndElseInfo);
        if (!adminRole) return new SystemResult(100, "该功能暂时没有开发到您");

        // 修改该反馈的信息
        K2UserFeedback feedback = new K2UserFeedback();
        feedback.setUserFeedbackState(UserFeedbackEnum.DEL.getValue());
        feedback.setUserFeedbackId(feedBackId);
        k2UserFeedbackMapper.updateByPrimaryKeySelective(feedback);
        return new SystemResult("ok");
    }

    /**
     * 校验时间
     *
     * @param dto
     */
    public static void checkTime(UserFeedbackIndexDto dto) {
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
    }

    /**
     * 校验登入的用户是否是超级管理员
     *
     * @param SYSTEM_ROLE_PROVE
     * @param k2MemberAndElseInfo
     * @return
     */
    public static Boolean isAdminRole(String SYSTEM_ROLE_PROVE, K2MemberAndElseInfo k2MemberAndElseInfo) {

        // 校验是否是超级管理员
        boolean flag = false;
        if (k2MemberAndElseInfo == null || CollectionUtils.isEmpty(k2MemberAndElseInfo.getK2Roles())) {
            return flag;
        } else {
            for (K2Role k2Role : k2MemberAndElseInfo.getK2Roles()) {
                if (SYSTEM_ROLE_PROVE.equals(k2Role.getRetain1())) {
                    flag = true;
                    break;
                }
            }
        }

        return flag;
    }
}
