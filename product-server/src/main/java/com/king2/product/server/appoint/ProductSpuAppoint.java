package com.king2.product.server.appoint;

import com.king2.commons.pojo.K2Member;
import com.king2.commons.pojo.K2ProductSpu;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.JsonUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/*=======================================================
	˵��:    ��ƷSPUί����

	����		ʱ��					ע��
  	����		2019.08.10   			����
=======================================================*/
@Component
public class ProductSpuAppoint {


    /**
     * -----------------------------------------------------
     * ����:  У��SPU��Ϣ�Ƿ���ȷ ������SPU�ļ�������
     * <p>
     * ����:
     * productSpuJson         String            ��Ʒ��SPU��Ϣ
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public static SystemResult checkProductSpuJsonInfo(String productSpuJson, Integer productId, K2Member k2Member, Integer maxOrder) {
        // У����ƷSPU��Ϣ�Ƿ���ȷ
        if (StringUtils.isEmpty(productSpuJson)) return new SystemResult(100, "��Ʒ������Ϣ����Ϊ��", null);

        // ת������
        List<K2ProductSpu> lists = null;
        try {
            lists = JsonUtils.jsonToList(productSpuJson, K2ProductSpu.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new SystemResult(100, "��Ʒ������Ϣ��ʽ����", null);
        }
        if (CollectionUtils.isEmpty(lists)) return new SystemResult(100, "����д��Ʒ����", null);
        // У����ƷSPU��Ϣ�Ƿ���ȷ
        for (int i = 0; i < lists.size(); i++) {
            K2ProductSpu productSpu = lists.get(i);
            // У�������Ƿ���ȷ
            if (productSpu == null) return new SystemResult(100, "��Ʒ�Ĳ�����Ϣ����Ϊ��", null);
            if (StringUtils.isEmpty(productSpu.getProductSpuName()) || productSpu.getProductSpuName().length() > 20) {
                return new SystemResult(100, "���������������ַ�����Ϊ1-20��", null);
            } else if (StringUtils.isEmpty(productSpu.getProductSpuValue()) || productSpu.getProductSpuValue().length() > 100) {
                return new SystemResult(100, "��Ʒ������ֵ�ַ�����Ϊ1-100��", null);
            } else if (productSpu.getProductSpuOrder() != null && productSpu.getProductSpuOrder() > 9999999) {
                return new SystemResult(100, "��Ʒ�������������", null);
            }

            productSpu.setProductSpuOrder(productSpu.getProductSpuOrder() == null ? maxOrder == null ? 0 : maxOrder + (i + 1) : productSpu.getProductSpuOrder());
            productSpu.setBelongProductId(productId);
            productSpu.setCreateTime(new Date());
            productSpu.setProductSpuState(1);
        }
        return new SystemResult(lists);

    }
}
