package com.nano.datastructure.面试.动态规划;

/**
 * @author: nano
 * @time: 2020/8/18 19:48
 */
public class 股票买卖问题 {


	/**
	 * k == 1
	 */
	int maxProfitK1(int[] prices) {
		int n = prices.length;
		// base case: dp[-1][0] = 0, dp[-1][1] = -infinity
		int dpi0 = 0, dpi1 = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			// dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
			dpi0 = Math.max(dpi0, dpi1 + prices[i]);
			// dp[i][1] = max(dp[i-1][1], -prices[i])
			dpi1 = Math.max(dpi1, -prices[i]);
		}
		return dpi0;
	}


}
