package com.nano.datastructure.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author nano
 */
public class BubbleSort {

    public static void bubbleSort(int[] array) {

        // Base case
        if (array == null || array.length < 2) {
            return;
        }
        // 从尾部开始遍历
        for (int end = array.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                // 不断比较前一个值大于后一个
                if (array[i] > array[i + 1]) {
                    // 如果前一个值大于后一个则交换两者位置
                    swap(array, i, i + 1);
                }
            }
        }
    }


    /**
     * 交互数组中的两个数的位置
     *
     * @param array 数组
     * @param i 元素1
     * @param j 元素2
     */
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
