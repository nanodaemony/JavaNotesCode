package com.nano.datastructure.search;

/**
 * 二分查找
 * @author nano
 */
public class BinarySearch {


    public static void main(String[] args) {

        int[] arr = new int[]{2, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySearch(arr, 0, arr.length, 7));
    }


    /**
     * 二分查找算法 递归实现
     *
     * @param array 数组
     * @param leftIndex 左边的索引
     * @param rightIndex 右边的索引
     * @param target 要查找的值
     * @return 如果找到就返回下标，如果没有找到就返回 -1
     */
    public static int binarySearch(int[] array, int leftIndex, int rightIndex, int target) {

        if (array == null || array.length == 0) {
            return -1;
        }

        // 当 left > right 时，说明已经递归整个数组，但是没有找到，必须要此处，不然会无限递归下去
        if (leftIndex > rightIndex) {
            return -1;
        }

        // 找中间值
        int midIndex = (leftIndex + rightIndex) / 2;
        int midValue = array[midIndex];

        // 向右递归
        if (target > midValue) {
            return binarySearch(array, midIndex + 1, rightIndex, target);
            // 向左递归
        } else if (target < midValue) {
            return binarySearch(array, leftIndex, midIndex - 1, target);
        } else {
            // 等于时直接返回
            return midIndex;
        }
    }


    /**
     * 二分查找的非递归实现
     *
     * @param array 待查找的数组, arr是升序排序
     * @param target 需要查找的数
     * @return 返回对应下标，-1表示没有找到
     */
    public static int binarySearch(int[] array, int target) {

        int leftIndex = 0;
        int rightIndex = array.length - 1;
        // 说明继续查找
        while(leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            if(array[midIndex] == target) {
                return midIndex;
            } else if ( array[midIndex] > target) {
                // 需要向左边查找
                rightIndex = midIndex - 1;
            } else {
                // 需要向右边查找
                leftIndex = midIndex + 1;
            }
        }
        return -1;
    }

}
