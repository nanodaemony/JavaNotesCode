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
        // Base case
        if (array == null || array.length < 2) {
            return;
        }
        // 传入待排数组和两个边界
        quickSort(array, 0, array.length - 1);
    }


    private static void quickSort(int[] array, int left, int right) {
        // 仅在没有越界的情况下进行
        if (left < right) {
            // 将pivot放到最末尾的位置
            // 每次随即选一个数与最后一个数交换进行快排 随机快排
            swap(array, left + (int) (Math.random() * (right - left + 1)), right);
            // //此数组长度永远为2,p[0]为等于区的左边界，p[1]为等于区的右边界
            int[] p = partition(array, left, right);
            // 将分出来的小于区重复上面的动作
            quickSort(array, left, p[0] - 1);
            // 将分出来的大于区重复上面的动作
            quickSort(array, p[1] + 1, right);
        }
    }

    /**
     * 对数组进行切分成三部分，最后返回等于的范围
     *
     * @param array 数组
     * @param left 左
     * @param right 右
     * @return 等于的范围
     * 总有一个等于pivot的位置，就是等于pivot自身
     * 返回等于区域(左边界，右边界), 所以返回一个长度为2的数组res, res[0] res[1]
     */
    public static int[] partition(int[] array, int left, int right) {
        // 声明一个小于区的索引
        int less = left - 1;
        // 声明一个大于区的索引
        int more = right;
        // left 表示当前数的位置   arr[R]->划分值
        while (left < more) {
            // 小于pivot值
            if (array[left] < array[right]) {
                swap(array, ++less, left++);
                // 大于pivot值
            } else if (array[left] > array[right]) {
                swap(array, --more, left);
            } else {
                left++;
            }
        }
        // 如果index索引与more相遇，则退出循环，并且right位置数与more位置数交换
        swap(array, more, right);
        // 用来记录等于区的左边界和右边界对应的索引
        return new int[] {less + 1, more};
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


}
