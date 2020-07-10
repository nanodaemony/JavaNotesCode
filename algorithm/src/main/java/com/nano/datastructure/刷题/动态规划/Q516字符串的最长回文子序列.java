package com.nano.datastructure.刷题.动态规划;

/**
 * @author: nano
 * @time: 2020/7/8 20:38
 */
public class Q516字符串的最长回文子序列 {


	/**
	 * 动态规划法
	 */
	public int longestPalindromeSubseq(String str) {
		int len = str.length();
		int[][] dp = new int[len][len];
		// 从后往前dp
		for (int i = len - 1; i >= 0; i--) {
			// 初始化
			dp[i][i] = 1;
			for (int j = i + 1; j < len; j++) {
				// 状态转移方程
				if (str.charAt(i) == str.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[0][len - 1];
	}
}