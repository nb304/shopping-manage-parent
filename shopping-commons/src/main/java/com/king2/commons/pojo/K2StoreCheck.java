package com.king2.commons.pojo;

import java.util.Date;

public class K2StoreCheck {
    /**
     * �����������id
     */
    private Integer storeCheckId;

    /**
     * ������˵ı��
     */
    private String storeCheckNumber;

    /**
     * ����ĵ�������
     */
    private String storeCheckStorename;

    /**
     * ���֤���������
     */
    private String storeCheckName;

    /**
     * �ֻ���
     */
    private String storeCheckPhone;

    /**
     * ���֤��
     */
    private String storeCheckCard;

    /**
     * �����˵�֧�����˻�
     */
    private String storeCheckZfb;

    /**
     * ��˭����� ---ָ���û�������
     */
    private Integer storeCheckUserId;

    /**
     * �û���  ---�����ֶ�
     */
    private String storeCheckUsername;

    /**
     * �����״̬ ---1ͨ�� 2δͨ�� 3δ����
     */
    private Integer storeCheckState;

    /**
     * �����˵�id ---ָ���û�������
     */
    private Integer storeCheckDisposeId;

    /**
     * �����˵����� ---�����ֶ�
     */
    private String storeCheckDisposeName;

    /**
     * ����ʱ��
     */
    private Date storeCheckCreateTime;
    private String storeCheckCreateTimeStr;

    /**
     * ����ʱ��
     */
    private Date storeCheckHandleTime;

    /**
     * �����ֶ�1   �ܾ�������
     */
    private String retain1;

    /**
     * �����ֶ�2
     */
    private String retain2;

    /**
     * �����ֶ�3
     */
    private String retain3;

    /**
     * �����ֶ�4
     */
    private String retain4;

    /**
     * �����ֶ�5
     */
    private String retain5;

    /**
     * �����������id
     *
     * @return store_check_id �����������id
     */
    public Integer getStoreCheckId() {
        return storeCheckId;
    }

    /**
     * �����������id
     *
     * @param storeCheckId �����������id
     */
    public void setStoreCheckId(Integer storeCheckId) {
        this.storeCheckId = storeCheckId;
    }

    /**
     * ������˵ı��
     *
     * @return store_check_number ������˵ı��
     */
    public String getStoreCheckNumber() {
        return storeCheckNumber;
    }

    /**
     * ������˵ı��
     *
     * @param storeCheckNumber ������˵ı��
     */
    public void setStoreCheckNumber(String storeCheckNumber) {
        this.storeCheckNumber = storeCheckNumber == null ? null : storeCheckNumber.trim();
    }

    /**
     * ����ĵ�������
     *
     * @return store_check_storeName ����ĵ�������
     */
    public String getStoreCheckStorename() {
        return storeCheckStorename;
    }

    /**
     * ����ĵ�������
     *
     * @param storeCheckStorename ����ĵ�������
     */
    public void setStoreCheckStorename(String storeCheckStorename) {
        this.storeCheckStorename = storeCheckStorename == null ? null : storeCheckStorename.trim();
    }

    /**
     * ���֤���������
     *
     * @return store_check_name ���֤���������
     */
    public String getStoreCheckName() {
        return storeCheckName;
    }

    /**
     * ���֤���������
     *
     * @param storeCheckName ���֤���������
     */
    public void setStoreCheckName(String storeCheckName) {
        this.storeCheckName = storeCheckName == null ? null : storeCheckName.trim();
    }

    /**
     * �ֻ���
     *
     * @return store_check_phone �ֻ���
     */
    public String getStoreCheckPhone() {
        return storeCheckPhone;
    }

    /**
     * �ֻ���
     *
     * @param storeCheckPhone �ֻ���
     */
    public void setStoreCheckPhone(String storeCheckPhone) {
        this.storeCheckPhone = storeCheckPhone == null ? null : storeCheckPhone.trim();
    }

    /**
     * ���֤��
     *
     * @return store_check_card ���֤��
     */
    public String getStoreCheckCard() {
        return storeCheckCard;
    }

    /**
     * ���֤��
     *
     * @param storeCheckCard ���֤��
     */
    public void setStoreCheckCard(String storeCheckCard) {
        this.storeCheckCard = storeCheckCard == null ? null : storeCheckCard.trim();
    }

    /**
     * �����˵�֧�����˻�
     *
     * @return store_check_zfb �����˵�֧�����˻�
     */
    public String getStoreCheckZfb() {
        return storeCheckZfb;
    }

    /**
     * �����˵�֧�����˻�
     *
     * @param storeCheckZfb �����˵�֧�����˻�
     */
    public void setStoreCheckZfb(String storeCheckZfb) {
        this.storeCheckZfb = storeCheckZfb == null ? null : storeCheckZfb.trim();
    }

    /**
     * ��˭����� ---ָ���û�������
     *
     * @return store_check_user_id ��˭����� ---ָ���û�������
     */
    public Integer getStoreCheckUserId() {
        return storeCheckUserId;
    }

    /**
     * ��˭����� ---ָ���û�������
     *
     * @param storeCheckUserId ��˭����� ---ָ���û�������
     */
    public void setStoreCheckUserId(Integer storeCheckUserId) {
        this.storeCheckUserId = storeCheckUserId;
    }

    /**
     * �û���  ---�����ֶ�
     *
     * @return store_check_username �û���  ---�����ֶ�
     */
    public String getStoreCheckUsername() {
        return storeCheckUsername;
    }

    /**
     * �û���  ---�����ֶ�
     *
     * @param storeCheckUsername �û���  ---�����ֶ�
     */
    public void setStoreCheckUsername(String storeCheckUsername) {
        this.storeCheckUsername = storeCheckUsername == null ? null : storeCheckUsername.trim();
    }

    /**
     * �����״̬ ---1ͨ�� 2δͨ�� 3δ����
     *
     * @return store_check_state �����״̬ ---1ͨ�� 2δͨ�� 3δ����
     */
    public Integer getStoreCheckState() {
        return storeCheckState;
    }

    /**
     * �����״̬ ---1ͨ�� 2δͨ�� 3δ����
     *
     * @param storeCheckState �����״̬ ---1ͨ�� 2δͨ�� 3δ����
     */
    public void setStoreCheckState(Integer storeCheckState) {
        this.storeCheckState = storeCheckState;
    }

    /**
     * �����˵�id ---ָ���û�������
     *
     * @return store_check_dispose_id �����˵�id ---ָ���û�������
     */
    public Integer getStoreCheckDisposeId() {
        return storeCheckDisposeId;
    }

    /**
     * �����˵�id ---ָ���û�������
     *
     * @param storeCheckDisposeId �����˵�id ---ָ���û�������
     */
    public void setStoreCheckDisposeId(Integer storeCheckDisposeId) {
        this.storeCheckDisposeId = storeCheckDisposeId;
    }

    /**
     * �����˵����� ---�����ֶ�
     *
     * @return store_check_dispose_name �����˵����� ---�����ֶ�
     */
    public String getStoreCheckDisposeName() {
        return storeCheckDisposeName;
    }

    /**
     * �����˵����� ---�����ֶ�
     *
     * @param storeCheckDisposeName �����˵����� ---�����ֶ�
     */
    public void setStoreCheckDisposeName(String storeCheckDisposeName) {
        this.storeCheckDisposeName = storeCheckDisposeName == null ? null : storeCheckDisposeName.trim();
    }

    /**
     * ����ʱ��
     *
     * @return store_check_create_time ����ʱ��
     */
    public Date getStoreCheckCreateTime() {
        return storeCheckCreateTime;
    }

    public String getStoreCheckCreateTimeStr() {
        return storeCheckCreateTimeStr;
    }

    public void setStoreCheckCreateTimeStr(String storeCheckCreateTimeStr) {
        this.storeCheckCreateTimeStr = storeCheckCreateTimeStr;
    }

    /**
     * ����ʱ��
     *
     * @param storeCheckCreateTime ����ʱ��
     */
    public void setStoreCheckCreateTime(Date storeCheckCreateTime) {
        this.storeCheckCreateTime = storeCheckCreateTime;
    }

    /**
     * ����ʱ��
     *
     * @return store_check_handle_time ����ʱ��
     */
    public Date getStoreCheckHandleTime() {
        return storeCheckHandleTime;
    }

    /**
     * ����ʱ��
     *
     * @param storeCheckHandleTime ����ʱ��
     */
    public void setStoreCheckHandleTime(Date storeCheckHandleTime) {
        this.storeCheckHandleTime = storeCheckHandleTime;
    }

    /**
     * �����ֶ�1
     *
     * @return retain1 �����ֶ�1
     */
    public String getRetain1() {
        return retain1;
    }

    /**
     * �����ֶ�1
     *
     * @param retain1 �����ֶ�1
     */
    public void setRetain1(String retain1) {
        this.retain1 = retain1 == null ? null : retain1.trim();
    }

    /**
     * �����ֶ�2
     *
     * @return retain2 �����ֶ�2
     */
    public String getRetain2() {
        return retain2;
    }

    /**
     * �����ֶ�2
     *
     * @param retain2 �����ֶ�2
     */
    public void setRetain2(String retain2) {
        this.retain2 = retain2 == null ? null : retain2.trim();
    }

    /**
     * �����ֶ�3
     *
     * @return retain3 �����ֶ�3
     */
    public String getRetain3() {
        return retain3;
    }

    /**
     * �����ֶ�3
     *
     * @param retain3 �����ֶ�3
     */
    public void setRetain3(String retain3) {
        this.retain3 = retain3 == null ? null : retain3.trim();
    }

    /**
     * �����ֶ�4
     *
     * @return retain4 �����ֶ�4
     */
    public String getRetain4() {
        return retain4;
    }

    /**
     * �����ֶ�4
     *
     * @param retain4 �����ֶ�4
     */
    public void setRetain4(String retain4) {
        this.retain4 = retain4 == null ? null : retain4.trim();
    }

    /**
     * �����ֶ�5
     *
     * @return retain5 �����ֶ�5
     */
    public String getRetain5() {
        return retain5;
    }

    /**
     * �����ֶ�5
     *
     * @param retain5 �����ֶ�5
     */
    public void setRetain5(String retain5) {
        this.retain5 = retain5 == null ? null : retain5.trim();
    }
}
