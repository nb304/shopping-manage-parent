package com.king2.product.server.appoint;

import com.king2.commons.pojo.K2ProductSkuPriceandkc;
import com.king2.commons.pojo.K2ProductSkuValue;
import com.king2.commons.pojo.K2ProductWithBLOBs;
import com.king2.commons.result.SystemResult;
import com.king2.commons.utils.JsonUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*=======================================================
	˵��:    ��ƷSKU���۸�ί����

	����		ʱ��					ע��
  	����		2019.08.07   			����
=======================================================*/
public class ProductSkuValueKcAppoint {


    /**
     * -----------------------------------------------------
     * ����:  ��ȡ��ƷSku-Value�Ŀ��۸���Ϣ
     * <p>
     * ����:
     * k2ProductSkuValues          List<K2ProductSkuValue>          SKU-Value�ļ�������
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public static SystemResult getProductSkuValueKcDatas(List<K2ProductSkuValue> k2ProductSkuValues, K2ProductWithBLOBs k2ProductWithBLOBs) {


        // �Լ������ݽ��з���
        SystemResult orderResult = getProductValueGroupBySkuOrder(k2ProductSkuValues);
        if (orderResult.getStatus() != 200) return orderResult;

        // ����SKU�ļ۸�����Ϣ
        List<K2ProductSkuPriceandkc> kcs = new ArrayList<>();
        // ���еѿ���������
        dkej((List<List<K2ProductSkuValue>>) orderResult.getData(), kcs);

        // ����ɹ�  ��������������Ϣ
        SystemResult systemResult = setSkuKcValues(kcs, k2ProductWithBLOBs);
        return systemResult;
    }

    /**
     * -----------------------------------------------------
     * ����:  ����SKUֵ���ͼ۸�
     * <p>
     * ����:
     * k2ProductSkuPriceandkcs          List<K2ProductSkuPriceandkc>          SKU-Value�Ŀ�漯������
     * k2ProductWithBLOBs               K2ProductWithBLOBs                    ��Ʒ����
     * <p>
     * ����: SystemResult              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public static SystemResult setSkuKcValues(List<K2ProductSkuPriceandkc> k2ProductSkuPriceandkcs, K2ProductWithBLOBs k2ProductWithBLOBs) {
        // ����bigDecimal
        BigDecimal bigDecimal = new BigDecimal(0);
        for (int i = 0; i < k2ProductSkuPriceandkcs.size(); i++) {
            k2ProductSkuPriceandkcs.get(i).setBelongProductId(k2ProductWithBLOBs.getProductId());
            k2ProductSkuPriceandkcs.get(i).setProductSkuKc(0);
            k2ProductSkuPriceandkcs.get(i).setProductSkuPrice(bigDecimal);
        }
        return new SystemResult(k2ProductSkuPriceandkcs);
    }

    /**
     * -----------------------------------------------------
     * ����:  ������Ʒid���з���
     * <p>
     * ����:
     * k2ProductSkuValues          List<K2ProductSkuValue>          SKU-Value�ļ�������
     * <p>
     * ����: UserManageUtil              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public static SystemResult getProductValueGroupBySkuOrder(List<K2ProductSkuValue> k2ProductSkuValues) {
        Map<Integer, List<K2ProductSkuValue>> collect = k2ProductSkuValues.stream().collect(Collectors.groupingBy(K2ProductSkuValue::getSkuKeyId));

        // �������ص�List
        List<List<K2ProductSkuValue>> lists = new ArrayList<>();
        for (Map.Entry<Integer, List<K2ProductSkuValue>> entry : collect.entrySet()) {
            lists.add(entry.getValue());
        }
        return new SystemResult(lists);
    }


    /**
     * -----------------------------------------------------
     * ����:  �ѿ���������ƷSKU�Ĳ���
     * <p>
     * ����:
     * valueLists          List<List<K2ProductSkuValue>>        SKU-Value�ļ�������
     * k2ProductSkuPriceandkcs  List<K2ProductSkuPriceandkc>    ��Ʒ���۸����Ϣ
     * <p>
     * ����: UserManageUtil              ���ص����ߵ�����
     * -----------------------------------------------------
     */
    public static void dkej(List<List<K2ProductSkuValue>> valueLists, List<K2ProductSkuPriceandkc> k2ProductSkuPriceandkcs) {
        // ����
        K2ProductSkuValue[][] lqq = {};
        // ָ�� ����ĳ���-1
        int counterIndex = lqq.length - 1;
        // ÿ��ȡ��ά������±�
        int[] counter = {};
        int forSize = 1;
        lqq = new K2ProductSkuValue[valueLists.size()][];
        counter = new int[valueLists.size()];
        counterIndex = lqq.length - 1;

        for (int i = 0; i <= valueLists.size() - 1; i++) {
            forSize *= valueLists.get(i).size();
            K2ProductSkuValue[] values = {};
            Object[] objects = valueLists.get(i).toArray();
            values = new K2ProductSkuValue[objects.length];
            for (int i1 = 0; i1 < objects.length; i1++) {
                values[i1] = (K2ProductSkuValue) objects[i1];
            }

            lqq[i] = values;
        }

        for (int i = 0; i < forSize; i++) {
            K2ProductSkuPriceandkc kc = new K2ProductSkuPriceandkc();
            String kcIds = "";
            String kcName = "";
            for (int j = 0; j < counter.length; j++) {
                if (StringUtils.isEmpty(kcIds)) {
                    kcIds = lqq[j][counter[j]].getProductSkuValueId().toString();
                    kcName = lqq[j][counter[j]].getSkuValue();
                } else {
                    kcIds += "," + lqq[j][counter[j]].getProductSkuValueId().toString();
                    kcName += "," + lqq[j][counter[j]].getSkuValue();
                }
            }
            kc.setSkuPriceandkcValuelistid(kcIds);
            kc.setProductSkuValueIds(kcName);
            k2ProductSkuPriceandkcs.add(kc);
            handle(counter, counterIndex, lqq);
        }
    }


    public static void handle(int[] counter, int counterIndex, K2ProductSkuValue[][] lqq) {

        counter[counterIndex]++;
        if (counter[counterIndex] >= lqq[counterIndex].length) {
            counter[counterIndex] = 0;
            counterIndex--;
            if (counterIndex >= 0) {
                handle(counter, counterIndex, lqq);
            }
            counterIndex = lqq.length - 1;
        }
    }


    /**
     * �鿴�޸���Ʒ��SKU�Ƿ���ȷ
     *
     * @param productSkuKcJson ��ƷSKU�����Ϣ
     * @return
     */
    public static SystemResult checkEditProductSkuKcInfo(String productSkuKcJson) {

        // У������
        if (StringUtils.isEmpty(productSkuKcJson)) {
            return new SystemResult(100, "��ƷSKU��Ϣ����Ϊ��", null);
        }
        try {
            List<K2ProductSkuPriceandkc> k2ProductSkuPriceandkcs = JsonUtils.jsonToList(productSkuKcJson, K2ProductSkuPriceandkc.class);
            if (CollectionUtils.isEmpty(k2ProductSkuPriceandkcs)) return new SystemResult(100, "��ƷSKU��Ϣ����Ϊ��", null);
            return new SystemResult(k2ProductSkuPriceandkcs);
        } catch (Exception e) {
            e.printStackTrace();
            return new SystemResult(100, "��Ϣת��ʧ��", null);
        }

    }
}
