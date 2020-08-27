package com.nano.datastructure.面试.动态规划;

/**
 * @author: nano
 * @time: 2020/8/21 12:50
 */
public class 回文子串个数 {

	int counter = 0;

	public int countSubstrings(String s) {
		for (int i = 0; i < s.length(); i++) {
			// 回文串长度为奇数
			count(s, i, i);
			// 回文串长度为偶数
			count(s, i, i + 1);
		}
		return counter;
	}

	private void count(String str, int start, int end) {
		while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
			counter++;
			start--;
			end++;
		}
	}

}
