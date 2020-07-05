package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/4 15:04
 */
public class 股票的最大利润 {

	public int maxProfit(int[] prices) {
		// Base case
		if (prices == null || prices.length == 0) return 0;
		// 截至目前的最小价格
		int soFarMin = prices[0];
		// 最大利润
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			// 不断更新最小的价格
			soFarMin = Math.min(soFarMin, prices[i]);
			// 用目前的价格减去截止目前最小的价格就是今天能够获得的最大利润
			int todayProfit = prices[i] - soFarMin;
			// 对比更新历史最大利润
			maxProfit = Math.max(maxProfit, todayProfit);
		}
		return maxProfit;
	}

}
