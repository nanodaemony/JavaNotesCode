package com.nano.datastructure.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author nano
 */
public class BubbleSort {

    public static void bubbleSort(int[] array) {
        // Base case
        if (array == null || array.length < 2) return;
        // 从尾部开始遍历
        for (int end = array.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                // 一轮之后将最大的值放到最后
                if (array[i] > array[i + 1]) {
                    // 如果前一个值大于后一个则交换两者位置
                    swap(array, i, i + 1);
                }
            }
        }
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        int[] array = {3, 5, 2, 9, 10, 7, 4, 6, 8, 1};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

}
