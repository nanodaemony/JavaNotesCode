package com.nano.datastructure.sort;

/**
 * 插入排序
 * @author nano
 */
public class InsertSort {

    /**
     * 插入排序
     * @param array 待排数组
     */
    public static void insertionSort(int[] array) {
        // Base case
        if (array == null || array.length < 2) {
            return;
        }
        // 从第一个开始遍历
        for (int i = 1; i < array.length; i++) {

            for (int j = i - 1; j >= 0 && array[j] > array[j + 1]; j--) {
                swap(array, j, j + 1);
            }
        }
    }


    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
