package com.nano.datastructure.刷题.动态规划;

import java.util.ArrayList;

/**
 * 给定一个长度为N的数组，找出一个最长的单调自增子序列（不一定连续，但是顺序不能乱）。
 * 例如：给定一个长度为6的数组A{5， 6， 7， 1， 2， 8}，
 * 则其最长的单调递增子序列为{5，6，7，8}，长度为4.
 */
public class 最长递增子序列 {


    // 生成dp数组
    public int[] getDp(int[] array) {

        int[] dp = new int[array.length];
        for (int i = 0; i < dp.length; i++) {
            // 默认为1
            dp[i] = 1;
            // 当前的dp值跟之前的全部比他小的值得dp+1进行对比，选择最大的
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }


        return dp;
    }

    /**
     * 根据dp数组和原数组找最长递增子序列
     */
    public int[] generateLIS(int[] array, int[] dp) {
        // 最大递增序列长度
        int length = 0;
        // 最大dp值的索引，同时也是最长递增子序列的结尾值
        int index = 0;
        // 首先寻找上述两个值
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > length) {
                length = dp[i];
                index = i;
            }
        }
        int[] lis = new int[length];
        // 先把最后一个值填上
        lis[--length]  = array[index];
        for (int i = index; i >= 0; i--) {
            // 同时满足这两个条件才是前一个符合条件的数
            if (array[i] < array[index] && dp[index] == dp[i] + 1) {
                lis[--length] = array[i];
                index = i;
            }
        }
        return lis;
    }



}
