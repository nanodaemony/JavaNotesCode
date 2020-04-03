package com.nano.datastructure.sort;

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
        if (array == null || array.length < 2) {
            return;
        }
        mergeSort(array, 0, array.length - 1);
    }

    /**
     * 归并排序 内部排序接口
     *
     * @param array 数组
     */
    private static void mergeSort(int[] array, int left, int right) {
        if (left == right) {
            return;
        }
        // 寻找中间值等价于 mid = (left + right) / 2
        int mid = left + ((right - left) >> 1);
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        // 对两部分进行合并
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
        int pointer1 = left;
        int pointer2 = mid + 1;
        // 不断复制左右两个数组中较小的元素到辅助数组中
        while (pointer1 <= mid && pointer2 <= right) {
            temp[i++] = array[pointer1] < array[pointer2] ? array[pointer1++] : array[pointer2++];
        }
        // 此时说明已经其中有一个数组越界了
        while (pointer1 <= mid) {
            temp[i++] = array[pointer1++];
        }
        while (pointer2 <= right) {
            temp[i++] = array[pointer2++];
        }
        // 将辅助数组元素复制回原数组
        for (i = 0; i < temp.length; i++) {
            array[left + i] = temp[i];
        }
    }


}
