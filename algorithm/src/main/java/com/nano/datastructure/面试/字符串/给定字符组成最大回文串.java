package com.nano.datastructure.面试.字符串;

/**
 * @author: nano
 * @time: 2020/9/12 22:08
 */
public class 给定字符组成最大回文串 {


	public int longestPalindrome(String str) {
		// 统计每个字符出现次数
		int[] cnts = new int[256];
		for (char c : str.toCharArray()) {
			cnts[c]++;
		}
		int res = 0;
		for (int cnt : cnts) {
			// 排除掉奇数次的情况
			res = res + (cnt / 2) * 2;
		}
		// 这个条件下str中一定有单个未使用的字符存在，可以把这个字符放到回文的最中间
		if (res < str.length()) {
			res++;
		}
		return res;
	}


}
