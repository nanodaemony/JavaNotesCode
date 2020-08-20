package com.nano.datastructure.面试.动态规划;

/**
 * @author: nano
 * @time: 2020/8/17 17:18
 */
public class 最长回文子序列 {

	public static int longestPalindromeSubseq(String str) {
		int len = str.length();
		int[][] dp = new int[len][len];
		// 初始化dp数组的对角线为1
		for (int i = 0; i < str.length(); i++) dp[i][i] = 1;
		// 从下往上
		for (int i = len - 1; i >= 0; i--) {
			// 从左往右遍历上三角形
			for (int j = i + 1; j < len; j++) {
				// 如果相等就+2
				if (str.charAt(i) == str.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					// 不相等就找左右最大的情况
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[0][len - 1];
	}

}
