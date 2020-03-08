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
    public static void mySelectionSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        // 直接假设第一个是最小的元素，然后跟后面的逐一比较，如果更小则交换
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] array = {3, 5, 2, 9, 9, 10, 7, 4, 6, 8, 1};
        mySelectionSort(array);
        System.out.println(Arrays.toString(array));
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
