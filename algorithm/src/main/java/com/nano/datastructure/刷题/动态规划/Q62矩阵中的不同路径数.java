package com.nano.datastructure.刷题.动态规划;

import java.util.Arrays;

/**
 * @author: nano
 * @time: 2020/7/7 16:17
 */
public class Q62矩阵中的不同路径数 {

	/**
	 * 普通DP
	 */
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		// 初始化第一行和第一列
		for (int i = 0; i < n; i++) dp[0][i] = 1;
		for (int i = 0; i < m; i++) dp[i][0] = 1;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}


	/**
	 * 优化dp
	 */
	public int uniquePaths2(int m, int n) {
		int[] pre = new int[n];
		int[] cur = new int[n];
		Arrays.fill(pre, 1);
		Arrays.fill(cur, 1);
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				cur[j] = cur[j - 1] + pre[j];
			}
			pre = cur.clone();
		}
		return pre[n - 1];
	}


	public int uniquePaths4(int m, int n) {

		int[] res = new int[n];
		Arrays.fill(res, 1);
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				res[j] = res[j] + res[j - 1];
			}
		}
		return res[n - 1];
	}


	public int uniquePaths3(int m, int n) {
		// 总共的移动次数
		int totalMove = m + n - 2;
		// 向下的移动次数
		int downMove = m - 1;
		long res = 1;
		for (int i = 1; i <= downMove; i++) {
			res = res * (totalMove - downMove + i) / i;
		}
		return (int) res;
	}

}
