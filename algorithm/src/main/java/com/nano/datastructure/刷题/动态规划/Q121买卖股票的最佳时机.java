package com.nano.datastructure.刷题.动态规划;

/**
 * @author: nano
 * @time: 2020/7/7 17:19
 */
public class Q121买卖股票的最佳时机 {


	public int maxProfit(int prices[]) {
		// 最小价格
		int minPrice = Integer.MAX_VALUE;
		// 记录最大利润
		int maxProfit = 0;
		// 遍历更新这个值
		for (int i = 0; i < prices.length; i++) {
			// 更新最小价格
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			}
			else if (prices[i] - minPrice > maxProfit) {
				// 更新最大利润
				maxProfit = prices[i] - minPrice;
			}
		}
		return maxProfit;
	}

}
