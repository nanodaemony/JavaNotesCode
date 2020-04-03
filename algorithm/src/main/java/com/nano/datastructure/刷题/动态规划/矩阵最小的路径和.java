package com.nano.datastructure.刷题.动态规划;

/**
 * 题目描述：给定一个 N * M 的矩阵 arr，从左上角
 * 开始每次只能向下或者向右走，最后到达右下角。
 * 路径上所有点的数字和为路径和，求最小的路径和。
 */
public class 矩阵最小的路径和 {

    public static int minSumPath(int[][] array) {
        // Base case
        if (array == null || array.length == 0 || array[0] == null
                || array[0].length == 0) {
            return 0;
        }
        int row = array.length;
        int col = array[0].length;
        // 以原数组的大小初始化动态数组
        int[][] dp = new int[row][col];
        // 初始化第一个元素
        dp[0][0] = array[0][0];
        // 分别初始化第一行和第一列
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + array[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + array[0][i];
        }
        // 进行持续计算
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 动态规划数组
                dp[i][j] = Math.min(dp[i - 1][j], dp[j - 1][i]) + array[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }


}
