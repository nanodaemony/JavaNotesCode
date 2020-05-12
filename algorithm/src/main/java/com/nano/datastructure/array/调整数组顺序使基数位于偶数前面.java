package com.nano.datastructure.array;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class 调整数组顺序使基数位于偶数前面 {


    public static void main(String[] args) {

        int[] a = new int[]{1, 3, 4, 5, 6, 7, 8, 9, 10};
        reOrderArray(a);
        System.out.println(Arrays.toString(a));
    }


    public static void reOrderArray(int [] array) {
        if (array.length == 0 || array.length == 1) {
            return;
        }

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                count++;
            }
        }

        if (count == array.length || count == 0) {
            return;
        }

        int frontIndex = count - 1;
        int backIndex = count;

        while (frontIndex >= 0 && backIndex <= array.length - 1) {

            if (array[frontIndex] % 2 == 0 && array[backIndex] % 2 == 1) {
                swap(array, frontIndex, backIndex);
                frontIndex--;
                backIndex++;
                continue;
            }

            if (array[frontIndex] % 2 == 1) {
                frontIndex--;
                continue;
            }
            if (array[backIndex] % 2 == 0) {
                backIndex++;
            }
        }
    }

    private static void swap(int[] array, int m, int n) {
        int temp = array[m];
        array[m] = array[n];
        array[n] = temp;
    }
}
