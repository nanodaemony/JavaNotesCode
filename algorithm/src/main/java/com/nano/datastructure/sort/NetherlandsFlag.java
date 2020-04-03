package com.nano.datastructure.sort;

/**
 * 荷兰国旗问题
 * @author nano
 */
public class NetherlandsFlag {

    /**
     * 对数组进行切分，分成小于等于大于num的三部分
     *
     * @param array 数组
     * @param left 左索引
     * @param right 右索引
     * @param num 切分值
     * @return 切分后的数组
     */
    public static int[] partition(int[] array, int left, int right, int num) {
        int less = left - 1;
        int more = right + 1;
        int cur = left;

        // 持续遍历当前指针直到与more指针相遇
        while (cur < more) {
            if (array[cur] < num) {
                // 交换less的后一个数与当前指针的数
                swap(array, ++less, cur++);
            } else if (array[cur] > num) {
                // 交换more的前一个数与当前指针的数
                swap(array, --more, cur);
            } else {
                // 相等则不动直接当前指针后移
                cur++;
            }
        }
        // 返回等于num元素的区间的范围
        return new int[] { less + 1, more - 1 };
    }

    // for test
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
