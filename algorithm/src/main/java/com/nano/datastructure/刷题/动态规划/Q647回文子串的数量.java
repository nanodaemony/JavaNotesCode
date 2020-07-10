package com.nano.datastructure.刷题.动态规划;

/**
 * @author: nano
 * @time: 2020/7/7 19:37
 */
public class Q647回文子串的数量 {

	/**
	 * 中心拓展法
	 * @param str
	 * @return
	 */
	public int countSubstrings(String str) {
		int len = str.length(), res = 0;

		for (int center = 0; center <= 2 * len - 1; ++center) {
			// 计算左边界
			int left = center / 2;
			// 计算右边界
			int right = left + center % 2;
			while (left >= 0 && right < len && str.charAt(left) == str.charAt(right)) {
				res++;
				left--;
				right++;
			}
		}
		return res;
	}

	/**
	 * 动态规划法
	 */
	public int countSubstrings2(String str) {
		// 动态规划法
		boolean[][] dp = new boolean[str.length()][str.length()];
		int ans = 0;
		for (int j = 0; j < str.length(); j++) {
			for (int i = 0; i <= j; i++) {
				if (str.charAt(i) == str.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
					dp[i][j] = true;
					ans++;
				}
			}
		}
		return ans;
	}


}
