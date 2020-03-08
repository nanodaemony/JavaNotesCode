package com.nano.datastructure.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author nano
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] array = {3, 5, 2, 9, 9, 10, 7, 4, 6, 8, 1};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }


    public static void quickSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            // 每次随即选一个数与最后一个数交换进行快排 随机快排
            swap(array, left + (int) (Math.random() * (right - left + 1)), right);
            int[] p = partition(array, left, right);
            quickSort(array, left, p[0] - 1);
            quickSort(array, p[1] + 1, right);
        }
    }

    /**
     * 对数组进行切分成三部分，最后返回等于
     * @param array 数组
     * @param left 左
     * @param right 右
     * @return 等于的范围
     */
    public static int[] partition(int[] array, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (array[left] < array[right]) {
                swap(array, ++less, left++);
            } else if (array[left] > array[right]) {
                swap(array, --more, left);
            } else {
                left++;
            }
        }
        // 交换pivot值与more的第一个元素
        swap(array, more, right);
        // 返回等于的范围
        return new int[] {less + 1, more};
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
