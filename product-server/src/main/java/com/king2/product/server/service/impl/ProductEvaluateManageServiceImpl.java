package com.king2.product.server.service.impl;

import com.king2.commons.mapper.K2MessageMapper;
import com.king2.commons.mapper.K2ProductEvaluateMapper;
import com.king2.commons.mapper.K2UserFeedbackMapper;
import com.king2.commons.pojo.*;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.GetErrorInfo;
import com.king2.product.server.appoint.UserMessageAppoint;
import com.king2.product.server.dto.LockPojo;
import com.king2.product.server.dto.ProductEvaluateIndexDto;
import com.king2.product.server.enmu.K2ProductEvaluateEnum;
import com.king2.product.server.enmu.ProductEvaluateReportEnum;
import com.king2.product.server.enmu.ProductQueueLockFactoryTypeEnum;
import com.king2.product.server.enmu.UserFeedbackEnum;
import com.king2.product.server.locks.ProductQueueLockFactory;
import com.king2.product.server.mapper.ProductEvaluateMapper;
import com.king2.product.server.pojo.ProductEvaluatePojo;
import com.king2.product.server.pojo.ProductEvaluatePortPojo;
import com.king2.product.server.pojo.ProductEvaluateRePortStatePojo;
import com.king2.product.server.service.ProductEvaluateManageService;
import com.king2.product.server.utlis.GetNumberByType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*=======================================================
	˵��:   ��Ʒ���۹���Serviceʵ����

	����		ʱ��					ע��
  	����		2019.08.29   			����
=======================================================*/
@Service
@SuppressWarnings("all")
public class ProductEvaluateManageServiceImpl implements ProductEvaluateManageService {

    // ע�����Ա��ʶ��
    @Value("${SYSTEM_ROLE_PROVE}")
    private String SYSTEM_ROLE_PROVE;

    // ע����Ʒ����Mapper
    @Autowired
    private ProductEvaluateMapper productEvaluateMapper;

    // ע��Զ�̵���Ʒ����Mapper
    @Autowired
    private K2ProductEvaluateMapper k2ProductEvaluateMapper;

    // ע���û�������ϢMapper
    @Autowired
    private K2UserFeedbackMapper k2UserFeedbackMapper;
    // ע����ϢMapper
    @Autowired
    private K2MessageMapper k2MessageMapper;
    // ע���Ź�����
    @Autowired
    private GetNumberByType getNumberByType;

    private static final String FEEDBACK_NUMBER_TYPE = "FEEDBACK_NUMBER_TYPE";

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductEvaluateManageServiceImpl.class);

    /**
     * -----------------------------------------------------
     * ����:  ��ʾ��Ʒ���۵���ҳ
     * <p>
     * ����:
     * k2MemberAndElseInfo         K2MemberAndElseInfo        �������û���Ϣ
     * dto              ProductEvaluateIndexDto ��ҳ����
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override

    public SystemResult index(ProductEvaluateIndexDto evaluateIndexDto, K2MemberAndElseInfo k2MemberAndElseInfo) {


        // ��ȡ�ٱ�����
        // �����ٱ����ͼ���
        List<ProductEvaluateRePortStatePojo> productEvaluateRePortStatePojos = new ArrayList<>();
        for (ProductEvaluateReportEnum value : ProductEvaluateReportEnum.values()) {
            ProductEvaluateRePortStatePojo productEvaluateRePortStatePojo = new ProductEvaluateRePortStatePojo();
            productEvaluateRePortStatePojo.setReportName(value.getKey());
            productEvaluateRePortStatePojo.setReportValue(value.getValue() + "");
            productEvaluateRePortStatePojos.add(productEvaluateRePortStatePojo);
        }

        evaluateIndexDto.setRePortStatePojos(productEvaluateRePortStatePojos);

        // �鿴�û��Ƿ��ǹ���Ա ����ǹ���Ա �Ͳ�ѯ��ϵͳ��������Ϣ
        Boolean adminRole = isAdminRole(SYSTEM_ROLE_PROVE, k2MemberAndElseInfo);

        // ��ʱ����У��
        SystemResult result = checkTimeData(evaluateIndexDto);
        if (result.getStatus() != 200) return result;

        // ����Id
        Integer stroeId = null;
        // У�鷵��ֵ
        if (adminRole) {
            //�ǹ���Ա �Ͳ�ѯ��ϵͳ��������Ϣ
            stroeId = null;
        } else {
            // ������ǹ���Ա �Ͳ�ѯ�õ��̵���Ϣ
            stroeId = Integer.parseInt(k2MemberAndElseInfo.getK2Member().getRetain1());
        }

        // ������
        int totalSize = productEvaluateMapper.getProductEvaluateSize
                (
                        StringUtils.isEmpty(evaluateIndexDto.getOrderNumber()) ? null : evaluateIndexDto.getOrderNumber(),
                        StringUtils.isEmpty(evaluateIndexDto.getUserName()) ? null : evaluateIndexDto.getUserName(),
                        evaluateIndexDto.getIsHZCState() == null ? null : evaluateIndexDto.getIsHZCState(),
                        evaluateIndexDto.getStartTime(), evaluateIndexDto.getEndTime(), stroeId
                );

        evaluateIndexDto.setTotalSize(totalSize);
        // �����ҳ��
        int totalPage = (totalSize + evaluateIndexDto.getCurrentSize() - 1) / evaluateIndexDto.getCurrentSize();
        evaluateIndexDto.setTotlaPage(totalPage);

        // �鿴��ǰҳ���Ƿ������ҳ��
        if (evaluateIndexDto.getCurrentPage() > totalPage) evaluateIndexDto.setCurrentPage(totalPage);

        // ���������ֵ
        int index = (evaluateIndexDto.getCurrentPage() - 1) < 0 ? 0 : (evaluateIndexDto.getCurrentPage() - 1) * evaluateIndexDto.getCurrentSize();

        // ��ѯ����ֵ
        List<ProductEvaluatePojo> productEvaluateList = productEvaluateMapper.getProductEvaluateList
                (
                        StringUtils.isEmpty(evaluateIndexDto.getOrderNumber()) ? null : evaluateIndexDto.getOrderNumber(),
                        StringUtils.isEmpty(evaluateIndexDto.getUserName()) ? null : evaluateIndexDto.getUserName(),
                        evaluateIndexDto.getIsHZCState() == null ? null : evaluateIndexDto.getIsHZCState(),
                        evaluateIndexDto.getStartTime(), evaluateIndexDto.getEndTime(), stroeId, index, evaluateIndexDto.getCurrentSize()
                );
        // ������Ʒ��ͼƬ
        productEvaluateList.forEach((e) -> {
            e.setpImage(StringUtils.isEmpty(e.getpImage()) ? "" : e.getpImage().split(",")[0]);
            e.setCreateTimeStr(UserMessageAppoint.sdf.format(e.getCreateTime()));
        });
        evaluateIndexDto.setProductEvaluateDatas(productEvaluateList);
        return new SystemResult(evaluateIndexDto);
    }

    /**
     * -----------------------------------------------------
     * ����:  �ظ���ҵ�����
     * <p>
     * ����:
     * k2MemberAndElseInfo         K2MemberAndElseInfo        �������û���Ϣ
     * evaId            Integer                 ���۵�id
     * content          String                  �ظ�������
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    public SystemResult replyContent(Integer evaId, K2MemberAndElseInfo k2MemberAndElseInfo, String content) {

        // ��ȡ��
        LockPojo lockPojo = ProductQueueLockFactory.getInstance().getLockMaps().get(ProductQueueLockFactoryTypeEnum.PRODUCT_EVALUATE_KEY.getValue());
        // ����
        lockPojo.getLock().lock();

        try {
            // У�������Ƿ����
            K2ProductEvaluateExample example = new K2ProductEvaluateExample();
            example.createCriteria()
                    .andProductEvaluateIdEqualTo(evaId)
                    .andProductEvaluateStateNotEqualTo(K2ProductEvaluateEnum.DEL.getValue())
                    .andRetain1IsNull();
            List<K2ProductEvaluateWithBLOBs> k2ProductEvaluates = k2ProductEvaluateMapper.selectByExampleWithBLOBs(example);

            if (CollectionUtils.isEmpty(k2ProductEvaluates)) return new SystemResult(100, "�������ѱ�ɾ�����Իظ�");
            K2ProductEvaluateWithBLOBs k2ProductEvaluate = k2ProductEvaluates.get(0);

            // ����ֵ
            k2ProductEvaluate.setIsRead(K2ProductEvaluateEnum.IS_READ_TRUE.getValue());
            k2ProductEvaluate.setRetain1(content);
            // �ظ�ʱ��
            k2ProductEvaluate.setRetain2(UserMessageAppoint.sdf.format(new Date()));
            // �޸�����
            k2ProductEvaluateMapper.updateByPrimaryKeySelective(k2ProductEvaluate);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockPojo.getLock().unlock();
        }


        return new SystemResult("�ظ��ɹ�");
    }

    /**
     * -----------------------------------------------------
     * ����:  �ٱ�����
     * <p>
     * ����:
     * productEvaluatePortPojo         ProductEvaluatePortPojo              ��Ʒ���۵ľٱ�POJO
     * k2MemberAndElseInfo             K2MemberAndElseInfo                  �������û���Ϣ
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public SystemResult reportEvaluate(ProductEvaluatePortPojo productEvaluatePortPojo, K2MemberAndElseInfo k2MemberAndElseInfo) {

        // У��״̬
        SystemResult result = checkReportState(productEvaluatePortPojo);
        if (result.getStatus() != 200) return result;

        // �鿴��Ʒ�����Ƿ����
        K2ProductEvaluateWithBLOBs k2ProductEvaluateWithBLOBs = k2ProductEvaluateMapper.selectByPrimaryKey(productEvaluatePortPojo.getReportEvId());
        if (k2ProductEvaluateWithBLOBs == null) return new SystemResult(100, "���۲�����,��ˢ��ҳ��");

        // �鿴�������Ƿ����ڸ��û�
        if (!k2ProductEvaluateWithBLOBs.getBelongStoreId().toString().equals(k2MemberAndElseInfo.getK2Member().getRetain1())) {
            return new SystemResult(100, "�����޸ı��˵�������Ϣ");
        }

        // ���뷴����Ϣ
        SystemResult result1 = insertUserFeedback(productEvaluatePortPojo, k2MemberAndElseInfo, result.getData() + "", k2ProductEvaluateWithBLOBs.getOrderNumber());

        // �ж��Ƿ����ɹ�
        if (result1.getStatus() != 200) return result1;

        // ����ɹ����û�������Ϣ
        try {
            UserMessageAppoint.addMessageGotoMysql
                    ("���ľٱ����ύ�ɹ�,�ٱ�������:'" + productEvaluatePortPojo.getReportContent() + "',�ٱ�����:'" + result.getData() + "' , ���ξٱ��ı��Ϊ:'" + result1.getData() + "',���к�����������ϵ����Ա��"
                            , k2MemberAndElseInfo.getK2Member().getMemberId(), k2MessageMapper);
        } catch (Exception e) {
            LOGGER.error("���û�������Ϣ����������Ϣ:" + e);
            LOGGER.error(GetErrorInfo.getTrace(e));
            throw new RuntimeException("ϵͳ�쳣");
        }

        // �޸�ԭ�������۵���Ϣ
        k2ProductEvaluateWithBLOBs.setRetain3(productEvaluatePortPojo.getReportContent());
        k2ProductEvaluateWithBLOBs.setRetain4(productEvaluatePortPojo.getReportState() + "");
        k2ProductEvaluateWithBLOBs.setRetain5(UserMessageAppoint.sdf.format(new Date()));
        k2ProductEvaluateMapper.updateByPrimaryKeySelective(k2ProductEvaluateWithBLOBs);

        return new SystemResult("ok");
    }

    /**
     * �����û���Ϣ
     *
     * @param productEvaluatePortPojo
     * @param k2MemberAndElseInfo
     * @param msg
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public SystemResult insertUserFeedback
    (ProductEvaluatePortPojo productEvaluatePortPojo, K2MemberAndElseInfo k2MemberAndElseInfo, String msg, String order) {
        // �����µ��û�������Ϣ
        K2UserFeedback userFeedback = new K2UserFeedback();
        userFeedback.setCreateTime(new Date());
        // ��ȡ�������
        String number = "";
        try {
            SystemResult fe = getNumberByType.getNumber(FEEDBACK_NUMBER_TYPE, 30, "FE");
            number = fe.getData() + "";
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("��ȡ������ų���,������Ϣ:" + e);
            LOGGER.error(GetErrorInfo.getTrace(e));
            return new SystemResult(100, "ϵͳ��æ,���Ժ�����");
        }

        userFeedback.setUserFeedbackNumber(number);
        userFeedback.setUserId(k2MemberAndElseInfo.getK2Member().getMemberId());
        userFeedback.setUserName(k2MemberAndElseInfo.getK2Member().getMemberAccount());
        userFeedback.setUserConnection(k2MemberAndElseInfo.getK2Member().getMemberEmail());
        userFeedback.setFeedbackContent(productEvaluatePortPojo.getReportContent() + "---�ٱ�����Ϊ:" + msg + "---�������Ϊ:" + order);
        userFeedback.setUserFeedbackState(UserFeedbackEnum.CLZ.getValue());

        // ���뷴����Ϣ
        k2UserFeedbackMapper.insert(userFeedback);
        return new SystemResult(number);
    }

    /**
     * У�������û��Ƿ��ǹ���Ա
     *
     * @param SYSTEM_ROLE_PROVE
     * @param k2MemberAndElseInfo
     * @return
     */
    public static Boolean isAdminRole(String SYSTEM_ROLE_PROVE, K2MemberAndElseInfo k2MemberAndElseInfo) {

        // �������û��Ľ�ɫ����Ϣ
        if (!CollectionUtils.isEmpty(k2MemberAndElseInfo.getK2Roles())) {
            for (K2Role k2Role : k2MemberAndElseInfo.getK2Roles()) {
                if (k2Role.getRetain1().equals(SYSTEM_ROLE_PROVE)) {
                    return true;
                }
            }
        }

        return false;
    }


    /**
     * У��ٱ���״̬�Ƿ���ȷ
     *
     * @param productEvaluatePortPojo
     * @return
     */
    public static SystemResult checkReportState(ProductEvaluatePortPojo productEvaluatePortPojo) {
        // У��״̬
        String msg = "";
        if (productEvaluatePortPojo.getReportState() == null) {
            return new SystemResult(100, "���۵�״̬Ϊ��");
        } else if (productEvaluatePortPojo.getReportState().toString().equals(ProductEvaluateReportEnum.EYCP.getValue() + "")) {
            msg = ProductEvaluateReportEnum.EYCP.getKey();
        } else if (productEvaluatePortPojo.getReportState().toString().equals(ProductEvaluateReportEnum.EYSD.getValue() + "")) {
            msg = ProductEvaluateReportEnum.EYSD.getKey();
        } else if (productEvaluatePortPojo.getReportState().toString().equals(ProductEvaluateReportEnum.THWX.getValue() + "")) {
            msg = ProductEvaluateReportEnum.THWX.getKey();
        } else {
            return new SystemResult(100, "����״̬����");
        }

        return new SystemResult(msg);
    }

    /**
     * У��ʱ���Ƿ���ȷ
     *
     * @param evaluateIndexDto
     * @return
     */
    public static SystemResult checkTimeData(ProductEvaluateIndexDto evaluateIndexDto) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (StringUtils.isEmpty(evaluateIndexDto.getStartTimeStr())) {
            evaluateIndexDto.setStartTime(null);
        } else if (!StringUtils.isEmpty(evaluateIndexDto.getStartTimeStr())) {
            evaluateIndexDto.setStartTimeStr(evaluateIndexDto.getStartTimeStr() + " 00:00:00");
            try {
                evaluateIndexDto.setStartTime(sdf.parse(evaluateIndexDto.getStartTimeStr()));
            } catch (Exception e) {
                e.printStackTrace();
                return new SystemResult(100, "��ѡ����ȷ��ʱ��");
            }
        }

        if (StringUtils.isEmpty(evaluateIndexDto.getEndTimeStr())) {
            evaluateIndexDto.setEndTime(null);
        } else if (!StringUtils.isEmpty(evaluateIndexDto.getEndTimeStr())) {
            evaluateIndexDto.setEndTimeStr(evaluateIndexDto.getEndTimeStr() + " 23:59:59");
            try {
                evaluateIndexDto.setEndTime(sdf.parse(evaluateIndexDto.getEndTimeStr()));
            } catch (Exception e) {
                e.printStackTrace();
                return new SystemResult(100, "��ѡ����ȷ��ʱ��");
            }
        }

        return new SystemResult(evaluateIndexDto);
    }
}
