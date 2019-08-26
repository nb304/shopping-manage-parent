package com.king2.product.server.sort;

import com.king2.product.server.dto.ProductInfoToRedisDataDto;

import java.util.List;

public class ProductInfoSort {

    public static void speedinessSortByState(List<ProductInfoToRedisDataDto> arr) {
        // 快速排序 从小到大 根据商品的状态排序
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

        // 获取第一个比较的值
        ProductInfoToRedisDataDto data = arr.get(start);
        while (start < end) {
            // 从后往前查询比index小和等于的值
            while (start < end) {
                if (arr.get(end).getProductState() <= data.getProductState()) {
                    // 找到就替换
                    arr.set(start, arr.get(end));
                    break;
                }
                // 没有找到就继续往前找
                end--;
            }

            // 从前往后查询比index大的值
            while (start < end) {
                if (arr.get(start).getProductState() > data.getProductState()) {
                    // 找到就替换
                    arr.set(end, arr.get(start));
                    break;
                }
                // 没有找到就继续往前找
                start++;
            }
        }

        arr.set(start, data);
        return start;
    }
}
