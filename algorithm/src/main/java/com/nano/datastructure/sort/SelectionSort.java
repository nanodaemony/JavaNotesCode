package com.nano.datastructure.sort;

import java.util.Arrays;

/**
 * 选择排序
 * @author nano
 */
public class SelectionSort {


    /**
     * 自己实现的选择排序
     *
     * @param array 数组
     */
    public static void selectionSort(int[] array) {
        // Base case
        if (array == null || array.length < 2) return;
        // 直接假设第一个是最小的元素，然后跟后面的逐一比较，如果更小则交换

        // 总共要经过 N-1 轮比较
        for (int i = 0; i < array.length - 1; i++) {
            // 假设当前位置为最小的元素
            int minValue = i;
            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < array.length; j++) {
                // 更新目前能找到的最小值元素的下标
                if (array[j] < array[minValue]) {
                    minValue = j;
                }
            }

            // 将找到的最小值和i位置所在的值进行交换
            if (i != minValue) {
                int tmp = array[i];
                array[i] = array[minValue];
                array[minValue] = tmp;
            }
        }
    }


    public static void main(String[] args) {
        int[] array = {3, 5, 2, 9, 9, 10, 7, 4, 6, 8, 1};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }




}
