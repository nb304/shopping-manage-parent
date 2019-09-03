package com.king2.product.server.appoint;

import com.king2.commons.mapper.K2MessageMapper;
import com.king2.commons.mapper.K2StoreCheckMapper;
import com.king2.commons.mapper.K2StroeMapper;
import com.king2.commons.pojo.K2MemberAndElseInfo;
import com.king2.commons.pojo.K2StoreCheck;
import com.king2.commons.pojo.K2Stroe;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.enmu.StoreEnterStateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * ������פί����
 */
@Component
public class StoreEnterAppoint {

    // ע�����Mapper
    @Autowired
    private K2StoreCheckMapper k2StoreCheckMapper;
    // ע���̨��ҳ����Ϣ
    @Value("${SHOP_SYSTEM_ADMIN_URL}")
    private String SHOP_SYSTEM_ADMIN_URL;
    // ע����ϢMapper
    @Autowired
    private K2MessageMapper k2MessageMapper;
    // ע�����Mapper
    @Autowired
    private K2StroeMapper k2StroeMapper;
    // ����ͼƬ
    @Value("${PRODUCT_IMAGE_NOT_DEFINITION}")
    private String PRODUCT_IMAGE_NOT_DEFINITION;

    /**
     * У�������Ϣ�����ض�Ӧ������
     *
     * @return
     */
    public SystemResult checkStoreInfoAndReturnResult(Integer state, Integer enterId, String content, K2MemberAndElseInfo k2MemberAndElseInfo) {

        // �ж�״̬
        if (!(state + "").equals(StoreEnterStateEnum.TG.getValue() + "") &&
                !(state + "").equals(StoreEnterStateEnum.WTG.getValue() + "")) {
            return new SystemResult(100, "״̬δͨ��");
        } else if ((state + "").equals(StoreEnterStateEnum.WTG.getValue() + "") &&
                StringUtils.isEmpty(content)) {
            return new SystemResult(100, "�ܾ����ɲ���Ϊ��");
        }

        // ��ѯ������Ϣ�Ƿ����
        K2StoreCheck k2StoreCheck = k2StoreCheckMapper.selectByPrimaryKey(enterId);
        if (k2StoreCheck == null) {
            return new SystemResult(100, "���̵���Ϣ������");
        } else if (!(k2StoreCheck.getStoreCheckState() + "").equals(StoreEnterStateEnum.WCL.getValue() + "")) {
            return new SystemResult(100, "����פ��Ϣ�Ѿ���������ˢ��ҳ������");
        }

        // ����״ֵ̬
        if ((state + "").equals(StoreEnterStateEnum.WTG.getValue() + "")) {
            k2StoreCheck.setRetain1(content);
        }
        k2StoreCheck.setStoreCheckDisposeName(k2MemberAndElseInfo.getK2Member().getMemberAccount());
        k2StoreCheck.setStoreCheckDisposeId(k2MemberAndElseInfo.getK2Member().getMemberId());
        k2StoreCheck.setStoreCheckState(state);
        return new SystemResult(k2StoreCheck);
    }


    /**
     * ͨ��״̬ �����õ��̵���Ϣ
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public SystemResult functionStoreByState(K2StoreCheck k2StoreCheck, String content) {

        // ���巢�͵���Ϣ
        StringBuffer msg = new StringBuffer();

        // У��״̬
        if (k2StoreCheck.getStoreCheckState().toString().equals(StoreEnterStateEnum.TG.getValue() + "")) {
            // ״̬Ϊͨ��

            // �����̵ı��в�������
            // ��ȡ���̵���Ϣ
            K2Stroe storeByStoreEnterInfo = getStoreByStoreEnterInfo(k2StoreCheck);
            // ������Ϣ
            k2StroeMapper.insert(storeByStoreEnterInfo);
            // �����û�������Ϣ ֪ͨ����Ѿ�ͨ��
            msg.append("������ס����Ѿ�ͨ��,��л�������ǵ�����,�����̨�̼�ϵͳ���ɶԵ��̽��й���,ϵͳ��ַΪ��");
            msg.append(SHOP_SYSTEM_ADMIN_URL);
            msg.append(",������������,����ϵϵͳ����Ա��---������ϵͳ����Ա");
        } else {
            // ��ͨ��
            // �����û�������Ϣ ֪ͨ��˲�ͨ��
            msg.append("���ź�������פ���û��ͨ��,�ܾ�����Ϊ:");
            msg.append(content);
            msg.append(",��л�������ǵ�����,����Ը��ݾܾ���Ϣ,������д���ϲ����·������롣---������ϵͳ����Ա");
        }

        // ���û�������Ϣ
        UserMessageAppoint.addMessageGotoMysql(msg.toString(), k2StoreCheck.getStoreCheckUserId(), k2MessageMapper);
        return new SystemResult("ok");
    }

    /**
     * ���ص��̵���Ϣ
     *
     * @param k2StoreCheck
     * @return
     */
    public K2Stroe getStoreByStoreEnterInfo(K2StoreCheck k2StoreCheck) {
        K2Stroe store = new K2Stroe();
        store.setStroeName(k2StoreCheck.getStoreCheckName());
        store.setStoreImage(PRODUCT_IMAGE_NOT_DEFINITION);
        store.setStoreLogoImage(PRODUCT_IMAGE_NOT_DEFINITION);
        store.setBelongUserId(k2StoreCheck.getStoreCheckUserId());
        store.setStoreProceedsZfb(k2StoreCheck.getStoreCheckZfb());
        store.setStoreDescribe("û��ǩ�����ҿ��Ը���");
        store.setStorePhone(k2StoreCheck.getStoreCheckPhone());
        store.setStoreState(1);
        store.setStoreLeven(1);
        store.setCreateTime(new Date());
        return store;
    }

}
