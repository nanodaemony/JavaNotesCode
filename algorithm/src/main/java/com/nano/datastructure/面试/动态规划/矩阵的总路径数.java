package com.nano.datastructure.面试.动态规划;

import java.util.Arrays;

/**
 * @author: nano
 * @time: 2020/8/28 13:20
 */
public class 矩阵的总路径数 {


	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < n; i++) dp[0][i] = 1;
		for (int i = 0; i < m; i++) dp[i][0] = 1;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				// 等于上方加左边的和
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}


	public int uniquePaths2(int m, int n) {
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[j] = dp[j] + dp[j - 1];
			}
		}
		return dp[n - 1];
	}

}
