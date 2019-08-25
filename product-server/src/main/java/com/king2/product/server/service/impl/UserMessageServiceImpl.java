package com.king2.product.server.service.impl;

import com.king2.commons.mapper.K2MessageMapper;
import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.pojo.K2Message;
import com.king2.commons.pojo.K2MessageExample;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.SystemIndexManageAppiont;
import com.king2.product.server.appoint.UserMessageAppoint;
import com.king2.product.server.enmu.K2MessageEnum;
import com.king2.product.server.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*=======================================================
	˵��:    �û���ϢServiceʵ����

	����		ʱ��					ע��
  	����		2019.08.25   			����
=======================================================*/
@Service
public class UserMessageServiceImpl implements UserMessageService {

    // ע����ϢMapper
    @Autowired
    private K2MessageMapper k2MessageMapper;

    // ע����ҳ����ί����
    @Autowired
    private SystemIndexManageAppiont systemIndexManageAppiont;


    /**
     * -----------------------------------------------------
     * ����:  ���ݴ�������״̬������Ϣ��״̬
     * <p>
     * ����:
     * k2MemberAndElseInfo      K2MemberAndElseInfo     ������û���Ϣ
     * messageId                Integer                 ��Ϣ��id
     * statw                    String                  ��Ϣ��״̬
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult messageRead(Integer messageId, K2MemberAndElseInfo k2MemberAndElseInfo, String state) {

        // �ж���Ϣ״̬�Ƿ���ȷ
        if (!state.equals(K2MessageEnum.YD.getValue() + "") && !state.equals(K2MessageEnum.DEL.getValue() + "")) {
            return new SystemResult(100, "��Ϣ��״̬����", null);
        }

        // ��ѯ��Ϣ�Ƿ����
        K2Message k2Message = k2MessageMapper.selectByPrimaryKey(messageId);
        if (k2Message == null) return new SystemResult(100, "����Ϣ������", null);

        // �жϸ���Ϣ�Ƿ����ڸ��û�
        if (!k2Message.getUserId().toString().equals(k2MemberAndElseInfo.getK2Member().getMemberId().toString())) {
            return new SystemResult(100, "�����޸ı��˵�����", null);
        }

        // ��ȡ�޸�ǰ����Ϣ״̬
        Integer oldState = k2Message.getState();

        // �޸���Ϣ��״̬
        k2Message.setState(Integer.parseInt(state));
        // �޸���Ʒ������
        k2MessageMapper.updateByPrimaryKeySelective(k2Message);

        // ���Ļ�������
        SystemResult result = systemIndexManageAppiont.editUserMessageById(state, oldState.toString(), k2MemberAndElseInfo, messageId.toString());

        return result;
    }

    /**
     * -----------------------------------------------------
     * ����:  ��ջ�ɾ��������Ϣ
     * <p>
     * ����:
     * state      String     ״̬
     * userId     Integer    �����˵�id
     * <p>
     * ����: SystemResult               ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult clearOrReadMessage(String state, Integer userId) {

        // ������Ϣ״̬
        K2Message k2Message = new K2Message();

        // ����״̬������ͬ�Ĳ���
        if ("2".equals(state)) {
            // ����Ϣ����Ѷ�
            k2Message.setState(K2MessageEnum.YD.getValue());
        } else if ("3".equals(state)) {
            // ����Ϣȫ��ɾ��
            k2Message.setState(K2MessageEnum.DEL.getValue());
        }

        // ����״̬��ջ�ɾ�������е�����
        UserMessageAppoint.clearOrReadMessageByUserIdAndState(userId, state);

        // ��ѯ�Ƿ���Ҫ�޸����ݿ������
        if (k2Message.getState() != null && k2Message.getState() != 0) {
            K2MessageExample example = new K2MessageExample();
            example.createCriteria().andUserIdEqualTo(userId).andStateNotEqualTo(K2MessageEnum.DEL.getValue());
            k2MessageMapper.updateByExampleSelective(k2Message, example);
        }

        return new SystemResult("ok");
    }
}
