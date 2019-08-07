package com.king2.product.server.appoint;

import com.king2.commons.pojo.K2ProductSkuPriceandkc;
import com.king2.commons.pojo.K2ProductSkuValue;
import com.king2.commons.result.SystemResult;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*=======================================================
	说明:    商品SKU库存价格委派类

	作者		时间					注释
  	俞烨		2019.08.07   			创建
=======================================================*/
public class ProductSkuValueKcAppoint {


    /**
     * -----------------------------------------------------
     * 功能:  获取商品Sku-Value的库存价格信息
     * <p>
     * 参数:
     * k2ProductSkuValues          List<K2ProductSkuValue>          SKU-Value的集合数据
     * <p>
     * 返回: UserManageUtil              返回调用者的数据
     * -----------------------------------------------------
     */
    public static SystemResult getProductSkuValueKcDatas(List<K2ProductSkuValue> k2ProductSkuValues) {


        // 对集合数据进行分组
        SystemResult orderResult = getProductValueGroupBySkuOrder(k2ProductSkuValues);
        if (orderResult.getStatus() != 200) return orderResult;

        // 创建SKU的价格库存信息
        List<K2ProductSkuPriceandkc> kcs = new ArrayList<>();
        // 进行笛卡尔积分类
        dlej((List<List<K2ProductSkuValue>>) orderResult.getData(), kcs);

        // 分类成功  返回给调用者
        return new SystemResult(kcs);
    }

    public static void main(String[] args) {
        List<K2ProductSkuValue> k2ProductSkuValues = new ArrayList<>();

        int id = 0;
        for (int i = 0; i < 10; i++) {
            K2ProductSkuValue value = new K2ProductSkuValue();

            value.setProductSkuValueId(i);
            if (i == 0) {
                id = i;
            } else if (i == 4) {
                id = i;
            } else if (i == 7) {
                id = i;
            }
            value.setSkuKeyId(id);
            k2ProductSkuValues.add(value);
        }


        SystemResult productSkuValueKcDatas = getProductSkuValueKcDatas(k2ProductSkuValues);
        System.out.println();
    }


    /**
     * -----------------------------------------------------
     * 功能:  根据商品id进行分组
     * <p>
     * 参数:
     * k2ProductSkuValues          List<K2ProductSkuValue>          SKU-Value的集合数据
     * <p>
     * 返回: UserManageUtil              返回调用者的数据
     * -----------------------------------------------------
     */
    public static SystemResult getProductValueGroupBySkuOrder(List<K2ProductSkuValue> k2ProductSkuValues) {
        Map<Integer, List<K2ProductSkuValue>> collect = k2ProductSkuValues.stream().collect(Collectors.groupingBy(K2ProductSkuValue::getSkuKeyId));

        // 创建返回的List
        List<List<K2ProductSkuValue>> lists = new ArrayList<>();
        for (Map.Entry<Integer, List<K2ProductSkuValue>> entry : collect.entrySet()) {
            lists.add(entry.getValue());
        }
        return new SystemResult(lists);
    }


    /**
     * -----------------------------------------------------
     * 功能:  笛卡尔积出商品SKU的参数
     * <p>
     * 参数:
     * valueLists          List<List<K2ProductSkuValue>>        SKU-Value的集合数据
     * k2ProductSkuPriceandkcs  List<K2ProductSkuPriceandkc>    商品库存价格的信息
     * <p>
     * 返回: UserManageUtil              返回调用者的数据
     * -----------------------------------------------------
     */
    public static void dlej(List<List<K2ProductSkuValue>> valueLists, List<K2ProductSkuPriceandkc> k2ProductSkuPriceandkcs) {
        // 数组
        K2ProductSkuValue[][] lqq = {};
        // 指针 数组的长度-1
        int counterIndex = lqq.length - 1;
        // 每次取二维数组的下标
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
            for (int j = 0; j < counter.length; j++) {
                if (StringUtils.isEmpty(kcIds)) {
                    kcIds = lqq[j][counter[j]].getProductSkuValueId().toString();
                } else {
                    kcIds += "," + lqq[j][counter[j]].getProductSkuValueId().toString();
                }
            }
            kc.setProductSkuValueIds(kcIds);
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


}
