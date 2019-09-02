package com.king2.commons.pojo;

import java.util.Date;

public class K2Stroe {
    /**
     * ���̱������id
     */
    private Integer stroeId;

    /**
     * ���̵�����
     */
    private String stroeName;

    /**
     * ���̵�ͷ��
     */
    private String storeImage;

    /**
     * ���̵�LOGOͼ��
     */
    private String storeLogoImage;

    /**
     * �õ��������ĸ��û�  ---ָ���û�������
     */
    private Integer belongUserId;

    /**
     * �õ��̵�֧�����˻�
     */
    private String storeProceedsZfb;

    /**
     * ���̵�����
     */
    private String storeDescribe;

    /**
     * �곤���ֻ�����
     */
    private String storePhone;

    /**
     * ���̵�״̬  ---1��ҵ�� 2�ر�
     */
    private Integer storeState;

    /**
     * �û��ĵȼ�����  ---ָ����̷��������
     */
    private Integer storeLeven;

    /**
     * ����ʱ��
     */
    private Date createTime;

    /**
     * ����ʱ��
     */
    private Date gointoTime;

    /**
     * ���̵�Ѻ��
     */
    private Integer storeCash;

    /**
     * �����ֶ�1
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
     * ���̱������id
     * @return stroe_id ���̱������id
     */
    public Integer getStroeId() {
        return stroeId;
    }

    /**
     * ���̱������id
     * @param stroeId ���̱������id
     */
    public void setStroeId(Integer stroeId) {
        this.stroeId = stroeId;
    }

    /**
     * ���̵�����
     * @return stroe_name ���̵�����
     */
    public String getStroeName() {
        return stroeName;
    }

    /**
     * ���̵�����
     * @param stroeName ���̵�����
     */
    public void setStroeName(String stroeName) {
        this.stroeName = stroeName == null ? null : stroeName.trim();
    }

    /**
     * ���̵�ͷ��
     * @return store_image ���̵�ͷ��
     */
    public String getStoreImage() {
        return storeImage;
    }

    /**
     * ���̵�ͷ��
     * @param storeImage ���̵�ͷ��
     */
    public void setStoreImage(String storeImage) {
        this.storeImage = storeImage == null ? null : storeImage.trim();
    }

    /**
     * ���̵�LOGOͼ��
     * @return store_logo_image ���̵�LOGOͼ��
     */
    public String getStoreLogoImage() {
        return storeLogoImage;
    }

    /**
     * ���̵�LOGOͼ��
     * @param storeLogoImage ���̵�LOGOͼ��
     */
    public void setStoreLogoImage(String storeLogoImage) {
        this.storeLogoImage = storeLogoImage == null ? null : storeLogoImage.trim();
    }

    /**
     * �õ��������ĸ��û�  ---ָ���û�������
     * @return belong_user_id �õ��������ĸ��û�  ---ָ���û�������
     */
    public Integer getBelongUserId() {
        return belongUserId;
    }

    /**
     * �õ��������ĸ��û�  ---ָ���û�������
     * @param belongUserId �õ��������ĸ��û�  ---ָ���û�������
     */
    public void setBelongUserId(Integer belongUserId) {
        this.belongUserId = belongUserId;
    }

    /**
     * �õ��̵�֧�����˻�
     * @return store_proceeds_zfb �õ��̵�֧�����˻�
     */
    public String getStoreProceedsZfb() {
        return storeProceedsZfb;
    }

    /**
     * �õ��̵�֧�����˻�
     * @param storeProceedsZfb �õ��̵�֧�����˻�
     */
    public void setStoreProceedsZfb(String storeProceedsZfb) {
        this.storeProceedsZfb = storeProceedsZfb == null ? null : storeProceedsZfb.trim();
    }

    /**
     * ���̵�����
     * @return store_describe ���̵�����
     */
    public String getStoreDescribe() {
        return storeDescribe;
    }

    /**
     * ���̵�����
     * @param storeDescribe ���̵�����
     */
    public void setStoreDescribe(String storeDescribe) {
        this.storeDescribe = storeDescribe == null ? null : storeDescribe.trim();
    }

    /**
     * �곤���ֻ�����
     * @return store_phone �곤���ֻ�����
     */
    public String getStorePhone() {
        return storePhone;
    }

    /**
     * �곤���ֻ�����
     * @param storePhone �곤���ֻ�����
     */
    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone == null ? null : storePhone.trim();
    }

    /**
     * ���̵�״̬  ---1��ҵ�� 2�ر�
     * @return store_state ���̵�״̬  ---1��ҵ�� 2�ر�
     */
    public Integer getStoreState() {
        return storeState;
    }

    /**
     * ���̵�״̬  ---1��ҵ�� 2�ر�
     * @param storeState ���̵�״̬  ---1��ҵ�� 2�ر�
     */
    public void setStoreState(Integer storeState) {
        this.storeState = storeState;
    }

    /**
     * �û��ĵȼ�����  ---ָ����̷��������
     * @return store_leven �û��ĵȼ�����  ---ָ����̷��������
     */
    public Integer getStoreLeven() {
        return storeLeven;
    }

    /**
     * �û��ĵȼ�����  ---ָ����̷��������
     * @param storeLeven �û��ĵȼ�����  ---ָ����̷��������
     */
    public void setStoreLeven(Integer storeLeven) {
        this.storeLeven = storeLeven;
    }

    /**
     * ����ʱ��
     * @return create_time ����ʱ��
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * ����ʱ��
     * @param createTime ����ʱ��
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * ����ʱ��
     * @return gointo_time ����ʱ��
     */
    public Date getGointoTime() {
        return gointoTime;
    }

    /**
     * ����ʱ��
     * @param gointoTime ����ʱ��
     */
    public void setGointoTime(Date gointoTime) {
        this.gointoTime = gointoTime;
    }

    /**
     * ���̵�Ѻ��
     * @return store_cash ���̵�Ѻ��
     */
    public Integer getStoreCash() {
        return storeCash;
    }

    /**
     * ���̵�Ѻ��
     * @param storeCash ���̵�Ѻ��
     */
    public void setStoreCash(Integer storeCash) {
        this.storeCash = storeCash;
    }

    /**
     * �����ֶ�1
     * @return retain1 �����ֶ�1
     */
    public String getRetain1() {
        return retain1;
    }

    /**
     * �����ֶ�1
     * @param retain1 �����ֶ�1
     */
    public void setRetain1(String retain1) {
        this.retain1 = retain1 == null ? null : retain1.trim();
    }

    /**
     * �����ֶ�2
     * @return retain2 �����ֶ�2
     */
    public String getRetain2() {
        return retain2;
    }

    /**
     * �����ֶ�2
     * @param retain2 �����ֶ�2
     */
    public void setRetain2(String retain2) {
        this.retain2 = retain2 == null ? null : retain2.trim();
    }

    /**
     * �����ֶ�3
     * @return retain3 �����ֶ�3
     */
    public String getRetain3() {
        return retain3;
    }

    /**
     * �����ֶ�3
     * @param retain3 �����ֶ�3
     */
    public void setRetain3(String retain3) {
        this.retain3 = retain3 == null ? null : retain3.trim();
    }

    /**
     * �����ֶ�4
     * @return retain4 �����ֶ�4
     */
    public String getRetain4() {
        return retain4;
    }

    /**
     * �����ֶ�4
     * @param retain4 �����ֶ�4
     */
    public void setRetain4(String retain4) {
        this.retain4 = retain4 == null ? null : retain4.trim();
    }

    /**
     * �����ֶ�5
     * @return retain5 �����ֶ�5
     */
    public String getRetain5() {
        return retain5;
    }

    /**
     * �����ֶ�5
     * @param retain5 �����ֶ�5
     */
    public void setRetain5(String retain5) {
        this.retain5 = retain5 == null ? null : retain5.trim();
    }
}