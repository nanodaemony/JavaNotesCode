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
        if (array == null || array.length < 2) return;
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < array.length; i++) {
            // 记录当前要插入的数据
            int tmp = array[i];
            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            // 当j大于0且待交换元素小于之前的元素
            while (j > 0 && tmp < array[j - 1]) {
                // 将前一个元素后移
                array[j] = array[j - 1];
                j--;
            }

            // 说明存在比其小的数，插入
            if (j != i) {
                array[j] = tmp;
            }
        }
    }


    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
