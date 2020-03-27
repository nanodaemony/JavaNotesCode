package com.nano.datastructure.刷题.动态规划;

/**
 * 求两个字符串的最长公共子串
 * @author nano
 */
public class 最长公共子串 {





    // 获取DP数组 DP数组表示必须把str1[i] str2[j]当做公共子串的最后一个字符的情况下最长公共子串的长度
    public int[][] getDp(String string1, String string2) {

        char[] str1 = string1.toCharArray();
        char[] str2 = string2.toCharArray();

        // dp数组中的元素默认全部为0不用管
        int[][] dp = new int[str1.length][str2.length];
        // 根据base case初始化第一行
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] == str2[0]) {
                dp[i][0] = 1;
            }
        }
        // 根据base case初始化第一列
        for (int i = 0; i < str2.length; i++) {
            if (str2[i] == str1[0]) {
                dp[0][i] = 1;
            }
        }
        // 从位置1开始，如果字符相等则最长的子串长度 + 1
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp;
    }

}
