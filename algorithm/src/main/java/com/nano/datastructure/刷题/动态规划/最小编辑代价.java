package com.nano.datastructure.刷题.动态规划;

/**
 * 给定两个字符串str1和str2，再给定三个整数ic，dc，rc，分别代表插入、删除、替换一个字符
 * 的代价，返回将str1编辑成str2的最小代价。
 * 举例：
 * str1="abc"   str2="adc"  ic=5    dc=3   rc=2，从"abc"编辑到"adc"把b替换成d代价最小，为2；
 * str1="abc"   str2="adc"  ic=5    dc=3   rc=10，从"abc"编辑到"adc"，先删除b再插入d代价最小，为8；
 */
public class 最小编辑代价 {


    public int findMinCost(String str1, String str2, int ic, int dc, int rc) {
        if (str1 == null || str2 == null) {
            return 0;
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        // dp数组长宽为字符串长度+1，因为需要考虑空串的情况
        int row = chs1.length + 1;
        int col = chs2.length + 1;
        int[][] dp = new int[row][col];
        // 初始化第一行和第一列
        for (int i = 1; i < row; i++) {
            dp[i][0] = dc + i;
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = ic * j;
        }
        // 四种普通情况取最小的
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (chs1[i - 1] == chs2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + rc;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc);
            }
        }
        return dp[row - 1][col - 1];
    }


}
