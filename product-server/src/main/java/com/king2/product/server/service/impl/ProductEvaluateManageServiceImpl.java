package com.king2.product.server.service.impl;

import com.king2.commons.mapper.K2ProductEvaluateMapper;
import com.king2.commons.pojo.*;
import com.king2.commons.result.SystemResult;
import com.king2.product.server.appoint.UserMessageAppoint;
import com.king2.product.server.dto.LockPojo;
import com.king2.product.server.dto.ProductEvaluateIndexDto;
import com.king2.product.server.enmu.K2ProductEvaluateEnum;
import com.king2.product.server.enmu.ProductQueueLockFactoryTypeEnum;
import com.king2.product.server.locks.ProductQueueLockFactory;
import com.king2.product.server.mapper.ProductEvaluateMapper;
import com.king2.product.server.pojo.ProductEvaluatePojo;
import com.king2.product.server.service.ProductEvaluateManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
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

            if (CollectionUtils.isEmpty(k2ProductEvaluates)) return new SystemResult(100,"�������ѱ�ɾ�����Իظ�");
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
