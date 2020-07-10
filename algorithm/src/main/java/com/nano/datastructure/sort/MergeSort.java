package com.nano.datastructure.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author nano
 */
public class MergeSort {

    /**
     * 归并排序 对外暴露的接口
     *
     * @param array 数组
     */
    public static void mergeSort(int[] array) {
        // Base case
        if (array == null || array.length < 2) return;
        mergeSort(array, 0, array.length - 1);
    }

    /**
     * 归并排序 内部排序接口
     *
     * @param array 数组
     */
    private static void mergeSort(int[] array, int left, int right) {
        // Base case
        if (left == right) return;
        // 寻找当前数组中间值等价于mid = (left + right) / 2
        int mid = left + ((right - left) >> 1);
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        // 对左右两部分结果进行合并
        merge(array, left, mid, right);
    }

    /**
     * 使用外排的方式合并两个已经排序的数组
     *
     * @param array 整个数组
     * @param left 左
     * @param mid 中
     * @param right 右
     */
    private static void merge(int[] array, int left, int mid, int right) {
        // 定义一个辅助数组用于外排
        int[] temp = new int[right - left + 1];
        int i = 0;
        int pointerLeft = left;
        int pointerRight = mid + 1;
        // 不断复制左右两个数组中较小的元素到辅助数组中
        while (pointerLeft <= mid && pointerRight <= right) {
            temp[i++] = array[pointerLeft] < array[pointerRight] ? array[pointerLeft++] : array[pointerRight++];
        }
        // 此时说明已经其中有一个数组越界了则复制另一个即可
        while (pointerLeft <= mid) {
            temp[i++] = array[pointerLeft++];
        }
        while (pointerRight <= right) {
            temp[i++] = array[pointerRight++];
        }
        // 将辅助数组元素复制回原数组
        for (i = 0; i < temp.length; i++) {
            array[left + i] = temp[i];
        }
    }


    public static void main(String[] args) {
        int[] array = {3, 5, 2, 9, 10, 7, 4, 6, 8, 1, 1};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

}
