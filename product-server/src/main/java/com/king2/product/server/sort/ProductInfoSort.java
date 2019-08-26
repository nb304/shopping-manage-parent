package com.king2.product.server.sort;

import com.king2.product.server.dto.ProductInfoToRedisDataDto;

import java.util.List;

public class ProductInfoSort {

    public static void speedinessSortByState(List<ProductInfoToRedisDataDto> arr) {
        // �������� ��С���� ������Ʒ��״̬����
        speedinessSortByState1(arr, 0, arr.size() - 1);
    }

    private static void speedinessSortByState1(List<ProductInfoToRedisDataDto> arr, int start, int end) {

        if (start < end) {
            int index = speedinessSortByState12(arr, start, end);
            speedinessSortByState1(arr, start, index - 1);
            speedinessSortByState1(arr, index + 1, end);
        }
    }

    private static int speedinessSortByState12(List<ProductInfoToRedisDataDto> arr, int start, int end) {

        // ��ȡ��һ���Ƚϵ�ֵ
        ProductInfoToRedisDataDto data = arr.get(start);
        while (start < end) {
            // �Ӻ���ǰ��ѯ��indexС�͵��ڵ�ֵ
            while (start < end) {
                if (arr.get(end).getProductState() <= data.getProductState()) {
                    // �ҵ����滻
                    arr.set(start, arr.get(end));
                    break;
                }
                // û���ҵ��ͼ�����ǰ��
                end--;
            }

            // ��ǰ�����ѯ��index���ֵ
            while (start < end) {
                if (arr.get(start).getProductState() > data.getProductState()) {
                    // �ҵ����滻
                    arr.set(end, arr.get(start));
                    break;
                }
                // û���ҵ��ͼ�����ǰ��
                start++;
            }
        }

        arr.set(start, data);
        return start;
    }
}
