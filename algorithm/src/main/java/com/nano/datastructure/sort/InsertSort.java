package com.nano.datastructure.sort;

import java.util.Arrays;

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
        // 从下标为1的元素开始选择合适的位置插入,因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < array.length; i++) {
            // 记录当前要插入的数据
            int temp = array[i];
            // 从已经排序的序列最右边的开始比较,找到比其小的数
            int right = i;
            // 当j大于0且待交换元素小于之前的元素
            while (right > 0 && temp < array[right - 1]) {
                // 将前一个元素后移
                array[right] = array[right - 1];
                right--;
            }
            // 说明存在比其小的数,插入
            if (right != i) {
                array[right] = temp;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    private static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            while (j > 0 && nums[j] < nums[j - 1]) {
                swap(nums, j, j - 1);
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 2, 7, 3, 1, 8, 2, 100, 4, 2};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
