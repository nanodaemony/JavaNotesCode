package com.nano.datastructure.刷题.字符串;

/**
 * @author: nano
 * @time: 2020/7/11 14:37
 */
public class Q5最长回文子串 {

	/**
	 * 动态规划法
	 */
	public static String longestPalindrome(String str) {
		int strLen = str.length();
		int maxLen = 0;
		String ans = "";
		boolean[][] dp = new boolean[strLen][strLen];
		// 遍历所有长度
		for (int len = 1; len <= strLen; len++) {
			for (int start = 0; start < strLen; start++) {
				int end = start + len - 1;
				// 下标越界，结束循环
				if (end >= strLen) {
					break;
				}
				dp[start][end] = (len == 1 || len == 2 || dp[start + 1][end - 1]) && str.charAt(start) == str.charAt(end);
				if (dp[start][end] && len > maxLen) {
					maxLen = len;
					ans = str.substring(start, end + 1);
				}
			}
		}
		return ans;
	}

	/**
	 * 动态规划2
	 */
	public String longestPalindrome3(String str) {
		if (str == null || str.length() < 2) return str;
		// 字符串长度
		int strLen = str.length();
		int maxStart = 0;  // 最长回文串的起点
		int maxEnd = 0;    // 最长回文串的终点
		int maxLen = 1;    // 最长回文串的长度
		// dp数组
		boolean[][] dp = new boolean[strLen][strLen];

		for (int right = 1; right < strLen; right++) {
			for (int left = 0; left < right; left++) {
				// 状态转移方程
				if (str.charAt(left) == str.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
					dp[left][right] = true;
					// 更新结果
					if (right - left + 1 > maxLen) {
						maxLen = right - left + 1;
						maxStart = left;
						maxEnd = right;
					}
				}
			}
		}
		// 根据索引找到最长回文字符串
		return str.substring(maxStart, maxEnd + 1);
	}


	/**
	 * 中心拓展法
	 */
	public String longestPalindrome1(String str) {

		if (str == null || str.length() == 0) return "";
		int strLen = str.length();
		int left = 0;
		int right = 0;
		int len = 1;
		int maxStart = 0;
		int maxLen = 0;

		// 从左到右以每个元素为中心判断
		for (int center = 0; center < strLen; center++) {
			left = center - 1;
			right = center + 1;
			// 首先是以当前位置及其左边或者右边同时为中心进行扩散
			while (left >= 0 && str.charAt(left) == str.charAt(center)) {
				len++;
				left--;
			}
			while (right < strLen && str.charAt(right) == str.charAt(center)) {
				len++;
				right++;
			}
			// 以当前center为中心扩散
			while (left >= 0 && right < strLen && str.charAt(right) == str.charAt(left)) {
				// 长度+2
				len = len + 2;
				left--;
				right++;
			}
			// 如果发现最大长度就更新
			if (len > maxLen) {
				maxLen = len;
				maxStart = left;
			}
			// 重置最大长度
			len = 1;
		}
		return str.substring(maxStart + 1, maxStart + maxLen + 1);
	}
}
