package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/3 14:20
 */
public class 把数字翻译成字符串 {




	public int numDecodings(String s) {
		// Base case
		if (s == null || s.length() == 0) return 0;

		int n = s.length();
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;
		for (int i = 2; i <= n; i++) {
			int one = Integer.parseInt(s.substring(i - 1, i));
			if (one != 0)
				dp[i] += dp[i - 1];
			if (s.charAt(i - 2) == '0')
				continue;
			int two = Integer.parseInt(s.substring(i - 2, i));
			if (two <= 26)
				dp[i] += dp[i - 2];
		}
		return dp[n];
	}

}
