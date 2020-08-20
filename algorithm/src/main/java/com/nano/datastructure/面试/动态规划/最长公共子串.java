package com.nano.datastructure.面试.动态规划;

/**
 * @author: nano
 * @time: 2020/8/20 22:46
 */
public class 最长公共子串 {

	public static int getMaxSubStr(String str1, String str2) {

		int len1 = str1.length();
		int len2 = str2.length();
		int[][] dp = new int[len1 + 1][len2 + 1];

		// 初始化dp数组
		for (int i = 0; i < len1 + 1; i++) dp[i][0] = 0;
		for (int i = 0; i < len2 + 1; i++) dp[0][i] = 0;

		int max = 0;
		for (int i = 1; i < len1 + 1; i++) {
			for (int j = 1; j < len2 + 1; j++) {
				// 如果两个字符相同
				if(str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					// 更新max字段
					max = Math.max(max, dp[i][j]);
					// 字符不同
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return max;
	}

}
