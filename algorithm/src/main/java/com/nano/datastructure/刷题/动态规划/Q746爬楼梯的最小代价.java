package com.nano.datastructure.刷题.动态规划;

/**
 * @author: nano
 * @time: 2020/7/7 17:48
 */
public class Q746爬楼梯的最小代价 {

	public int minCostClimbingStairs(int[] cost) {
		// dp[0] dp[1] 默认为0
		int[] dp = new int[cost.length + 1];
		for (int i = 2; i < dp.length; i++) {
			dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
		}
		return dp[dp.length - 1];
	}


	/**
	 * 优化空间解法
	 */
	public int minCostClimbingStairs2(int[] cost) {
		int f1 = 0, f2 = 0;
		for (int i = 0; i < cost.length; i++) {
			int minCost = cost[i] + Math.min(f1, f2);
			f1 = f2;
			f2 = minCost;
		}
		return Math.min(f1, f2);
	}

}
