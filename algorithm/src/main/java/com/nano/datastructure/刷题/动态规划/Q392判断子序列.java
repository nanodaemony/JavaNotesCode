package com.nano.datastructure.刷题.动态规划;

/**
 * @author: nano
 * @time: 2020/7/7 17:55
 */
public class Q392判断子序列 {

	/**
	 * 是否是子序列
	 */
	public boolean isSubsequence(String sub, String origin) {
		int index = 0;
		for (char ch : sub.toCharArray()) {
			while (index < origin.length() && origin.charAt(index) != ch) {
				index++;
			}
			index++;
		}
		return index <= origin.length();
	}


	public boolean isSubsequence2(String sub, String origin) {
		// Base case
		if (sub == null || origin == null) return true;
		int alreadyUseIndex = 0, location = 0;
		for (int i = 0; i < sub.length(); i++) {
			// 找到当前字符在origin字符串中第一次出现的索引
			location = origin.indexOf(sub.charAt(i), alreadyUseIndex);
			// 说明没找到直接返回
			if (location < 0) {
				return false;
			}
			// 更新已经找过的索引
			alreadyUseIndex = location + 1;
		}
		return true;
	}


	public boolean isSubsequence3(String sub, String origin) {
		// 预处理,开头加一个空字符作为匹配入口
		origin = " " + origin;
		int len = origin.length();
		// 记录每个位置的下一个ch的位置
		int[][] dp = new int[len][26];
		for (char ch = 0; ch < 26; ch++) {
			int position = -1;
			// 从后往前记录dp
			for (int i = len - 1; i >= 0; i--) {
				dp[i][ch] = position;
				if (origin.charAt(i) == ch + 'a') {
					position = i;
				}
			}
		}
		// 匹配
		int i = 0;
		// 跳跃遍历
		for (char ch : sub.toCharArray()) {
			i = dp[i][ch - 'a'];
			if (i == -1) return false;
		}
		return true;
	}


}
