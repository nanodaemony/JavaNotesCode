package com.nano.datastructure.面试.动态规划;

/**
 * @author: nano
 * @time: 2020/8/17 17:06
 */
public class 最长回文子串 {

	// 最长回文串的起始指针
	private static int startIndex;
	// 最长回文串长度
	private static int maxLen;
	public static String longestPalindrome (String str) {
		if (str == null || str.length() < 2) return str;

		// 最多到长度-1
		for (int i = 0; i < str.length() - 1; i++) {
			// 奇数长度回文串
			findMaxByCenter(str, i, i);
			// 偶数长度回文串
			findMaxByCenter(str, i, i + 1);
		}
		return str.substring(startIndex, startIndex + maxLen);
	}
	// 指定中心
	private static void findMaxByCenter(String str, int left, int right) {
		// 中心扩展
		while (left >= 0 && right <= str.length() && str.charAt(left) == str.charAt(right)) {
			left--;
			right++;
		}
		// 如果找到更长的则更新结果
		if(maxLen < right - left + 1) {
			startIndex = left + 1;
			maxLen = right - left + 1;
		}
	}
}
