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
	˵��:     �û�����ʱ��Serviceʵ����

	����		ʱ��					ע��
  	����		2019.08.31   			����
=======================================================*/
@Service
@SuppressWarnings("all")
public class UserFeedbackManageServiceImpl implements UserFeedbackManageService {

    // ע��ϵͳ��������Ա��ʶ
    @Value("${SYSTEM_ROLE_PROVE}")
    private String SYSTEM_ROLE_PROVE;
    // ע�뱾�صķ������Mapper
    @Autowired
    private UserFeedbackMapper userFeedbackMapper;
    // ע�뷴��ί����
    @Autowired
    private UserFeedbackAppoint userFeedbackAppoint;
    // ע�뷴��Mapper
    @Autowired
    private K2UserFeedbackMapper k2UserFeedbackMapper;
    // ע�뷴���ظ���
    @Autowired
    private K2FeedbackReplyMapper k2FeedbackReplyMapper;
    // ע����Ϣ��
    @Autowired
    private K2MessageMapper k2MessageMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFeedbackManageServiceImpl.class);

    // ע�뷴��������
    @Autowired
    private K2FeedbackAccessoryMapper k2FeedbackAccessoryMapper;

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
    @Override
    public SystemResult index(K2MemberAndElseInfo k2MemberAndElseInfo, UserFeedbackIndexDto dto) {

        // У���Ƿ��ǳ�������Ա  ��Ϊ���������ʱ��˵ֻ�ܳ�������Ա���� ������ɫ��Ϣ���޷������
        Boolean adminRole = isAdminRole(SYSTEM_ROLE_PROVE, k2MemberAndElseInfo);
        if (!adminRole) return new SystemResult(100, "�ù�����ʱû�п�������");

        // У��ʱ��
        checkTime(dto);

        // �ǳ�������Ա ���Ǿ�ȥ��ѯ����������
        String number = // ��Ʒ���
                StringUtils.isEmpty(dto.getFeedNumber()) ? null : dto.getFeedNumber();
        String userName = // �����˵���Ϣ
                StringUtils.isEmpty(dto.getUserName()) ? null : dto.getUserName();
        String userFeedbackState =
                StringUtils.isEmpty(dto.getState()) ? null : dto.getState();
        int feedbackCount = userFeedbackMapper.getFeedbackCount(number, userName, userFeedbackState, dto.getStartTime(), dto.getEndTime());

        // ������
        dto.setTotalSize(feedbackCount);

        // �����ҳ��
        int totalPage = (feedbackCount + dto.getCurrentSize() - 1) / dto.getCurrentSize();
        dto.setTotlaPage(totalPage);

        // �鿴��ǰҳ���Ƿ������ҳ��
        if (dto.getCurrentPage() > totalPage) dto.setCurrentPage(totalPage);

        // ���������ֵ
        int index = (dto.getCurrentPage() - 1) < 0 ? 0 : (dto.getCurrentPage() - 1) * dto.getCurrentSize();


        // ��ѯֵ
        List<K2UserFeedback> feedbackDatas = userFeedbackMapper.getFeedbackDatas(
                number, userName, userFeedbackState, dto.getStartTime(), dto.getEndTime(), index, dto.getCurrentSize()
        );

        // ��ѯ״̬
        feedbackDatas.forEach((n) -> {
            if (n.getUserFeedbackState().toString().equals(UserFeedbackEnum.CLZ.getValue() + "")) {
                n.setStateStr(UserFeedbackEnum.CLZ.getKey());
            } else if (n.getUserFeedbackState().toString().equals(UserFeedbackEnum.DEL.getValue() + "")) {
                n.setStateStr(UserFeedbackEnum.DEL.getKey());
            } else if (n.getUserFeedbackState().toString().equals(UserFeedbackEnum.YCL.getValue() + "")) {
                n.setStateStr(UserFeedbackEnum.YCL.getKey());
            } else {
                n.setStateStr("δ֪״̬");
            }
            n.setCreateTimeStr(UserMessageAppoint.sdf.format(n.getCreateTime()));
            n.setRetain1(StringUtils.isEmpty(n.getRetain1()) ? "��δ����" : n.getRetain1());
            n.setUserConnection(StringUtils.isEmpty(n.getUserConnection()) ? "����" : n.getUserConnection());
        });

        dto.setFeedbackDatas(feedbackDatas);
        return new SystemResult(dto);
    }

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
    @Override
    @Transactional(rollbackFor = Exception.class)
    public SystemResult readUserFeedBack(Integer feedBackId, K2MemberAndElseInfo k2MemberAndElseInfo, String content) {

        // У���Ƿ��ǹ���Ա
        Boolean adminRole = isAdminRole(SYSTEM_ROLE_PROVE, k2MemberAndElseInfo);
        if (!adminRole) return new SystemResult(100, "�ù�����ʱû�п�������");
        synchronized (LOGGER) {
            // �鿴������Ϣ�Ƿ����
            SystemResult result = userFeedbackAppoint.checkUserFeedbackInfo(feedBackId);
            if (result.getStatus() != 200) return result;
            K2UserFeedback userFeedback = (K2UserFeedback) result.getData();

            // У��ͨ�� У�鱾����Ϣ�Ƿ���ȷ ��ȷ�ͷ�����ȷ����
            SystemResult checkReplyResult = userFeedbackAppoint.checkReplyInfo(content, feedBackId);
            if (checkReplyResult.getStatus() != 200) return checkReplyResult;
            K2FeedbackReply reply = (K2FeedbackReply) checkReplyResult.getData();

            // �޸Ķ�Ӧ����Ϣ
            userFeedback.setUserFeedbackState(UserFeedbackEnum.YCL.getValue());
            userFeedback.setUserFeedbackResult(k2MemberAndElseInfo.getK2Member().getMemberId());
            k2UserFeedbackMapper.updateByPrimaryKeySelective(userFeedback);

            // �����Ӧ�Ĵ�����Ϣ
            k2FeedbackReplyMapper.insert(reply);

            // ���û�������Ϣ
            UserMessageAppoint.addMessageGotoMysql("���ľٱ����:" + userFeedback.getUserFeedbackNumber() + "�ѻظ�:<br />" + content, userFeedback.getUserId(), k2MessageMapper);
        }
        return new SystemResult("�ظ��ɹ�");
    }

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
    @Override
    public SystemResult getReplyInfo(Integer feedBackId, K2MemberAndElseInfo k2MemberAndElseInfo) {

        // У���Ƿ��ǹ���Ա
        Boolean adminRole = isAdminRole(SYSTEM_ROLE_PROVE, k2MemberAndElseInfo);
        if (!adminRole) return new SystemResult(100, "�ù�����ʱû�п�������");

        K2FeedbackReplyExample example = new K2FeedbackReplyExample();
        example.createCriteria().andFeedbackIdEqualTo(feedBackId);
        List<K2FeedbackReply> k2FeedbackReplies = k2FeedbackReplyMapper.selectByExampleWithBLOBs(example);
        // У�������Ƿ����
        if (CollectionUtils.isEmpty(k2FeedbackReplies)) {
            return new SystemResult(100, "����ʧ��,��ˢ��ҳ������");
        }

        return new SystemResult(k2FeedbackReplies.get(0));
    }

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
    @Override
    public SystemResult getFeedbackAccessory(Integer feedBackId, K2MemberAndElseInfo k2MemberAndElseInfo) {

        // У���Ƿ��ǹ���Ա
        Boolean adminRole = isAdminRole(SYSTEM_ROLE_PROVE, k2MemberAndElseInfo);
        if (!adminRole) return new SystemResult(100, "�ù�����ʱû�п�������");

        K2FeedbackAccessoryExample example = new K2FeedbackAccessoryExample();
        example.createCriteria().andBelongUserBackIdEqualTo(feedBackId);
        List<K2FeedbackAccessory> k2FeedbackAccessories = k2FeedbackAccessoryMapper.selectByExampleWithBLOBs(example);

        return new SystemResult(k2FeedbackAccessories);
    }

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
    @Override
    public SystemResult delFeedback(Integer feedBackId, K2MemberAndElseInfo k2MemberAndElseInfo) {

        // У���Ƿ��ǹ���Ա
        Boolean adminRole = isAdminRole(SYSTEM_ROLE_PROVE, k2MemberAndElseInfo);
        if (!adminRole) return new SystemResult(100, "�ù�����ʱû�п�������");

        // �޸ĸ÷�������Ϣ
        K2UserFeedback feedback = new K2UserFeedback();
        feedback.setUserFeedbackState(UserFeedbackEnum.DEL.getValue());
        feedback.setUserFeedbackId(feedBackId);
        k2UserFeedbackMapper.updateByPrimaryKeySelective(feedback);
        return new SystemResult("ok");
    }

    /**
     * У��ʱ��
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
     * У�������û��Ƿ��ǳ�������Ա
     *
     * @param SYSTEM_ROLE_PROVE
     * @param k2MemberAndElseInfo
     * @return
     */
    public static Boolean isAdminRole(String SYSTEM_ROLE_PROVE, K2MemberAndElseInfo k2MemberAndElseInfo) {

        // У���Ƿ��ǳ�������Ա
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
