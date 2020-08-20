package com.nano.datastructure.面试.动态规划;

/**
 * @author: nano
 * @time: 2020/8/18 16:58
 */
public class 编辑距离 {

	public int minDistance(String s1, String s2) {
		int m = s1.length(), n = s2.length();
		int[][] dp = new int[m + 1][n + 1];
		// base case
		for (int i = 1; i <= m; i++) dp[i][0] = i;
		for (int j = 1; j <= n; j++) dp[0][j] = j;
		// 从左到右,从上到下执行dp操作
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				// 相同则什么都不做,直接跳过
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					// 三种操作中取最小的
					dp[i][j] = min(
							dp[i - 1][j] + 1,	// 插入
							dp[i][j - 1] + 1,	// 删除
							dp[i - 1][j - 1] + 1	// 替换
					);
				}
			}
		}
		// 储存着整个 s1 和 s2 的最小编辑距离
		return dp[m][n];
	}

	private int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

}
