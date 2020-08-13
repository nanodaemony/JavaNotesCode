package com.nano.datastructure.刷题.动态规划;

/**
 * 有重量分别为3，5，7公斤的三种货物，和一个载重量为X公斤的箱子（不考虑体积等其它因素，只计算重量）
 * 需要向箱子内装满X公斤的货物，要求使用的货物个数尽可能少（三种货物数量无限）
 */
public class 零钱兑换 {


	public static void main(String[] args) {
		int[] arr = {5, 2, 3, 1};
		int aim = 5;
		System.out.println(minCoins1(arr, aim));
		System.out.println(coinChange(arr, aim));
	}

	public static int minCoins1(int[] arr, int aim) {
		// Base case
		if (arr == null || arr.length == 0 || aim < 0) return -1;
		//dp数组
		int[][] dp = new int[arr.length][aim + 1];
		// 设置一个最大值
		int maxValue = Integer.MAX_VALUE;
		// 设置第一行
		for (int j = 1; j <= aim; j++) {
			dp[0][j] = maxValue;
			if (j - arr[0] >= 0 && dp[0][j - arr[0]] != maxValue) {
				dp[0][j] = dp[0][j - arr[0]] + 1;
			}
		}
		int left = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= aim; j++) {
				left = maxValue;
				if (j - arr[i] >= 0 && dp[i][j - arr[i]] != maxValue) {
					left = dp[i][j - arr[i]] + 1;
				}
				dp[i][j] = Math.min(left, dp[i - 1][j]);
			}
		}
		return dp[arr.length - 1][aim] != maxValue ? dp[arr.length - 1][aim] : -1;
	}


	public static int coinChange(int[] coins, int amount) {
		// 自底向上的动态规划
		if (coins.length == 0) return -1;

		// memo[n]的值:表示的凑成总金额为n所需的最少的硬币个数
		int[] dp = new int[amount + 1];
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			int min = Integer.MAX_VALUE;
			// 遍历找硬币的值
			for (int j = 0; j < coins.length; j++) {

				if (i - coins[j] >= 0 && dp[i - coins[j]] < min) {
					min = dp[i - coins[j]] + 1;
				}
			}
			// memo[i] = (min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min);
			dp[i] = min;
		}

		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}



	//-------------------记忆化搜索-----------------------------
	// dp[n]表示钱币n可以被换取的最少的硬币数，不能换取就为-1
	int[] dp;
	public int coinChange2(int[] coins, int amount) {
		if (coins.length == 0) return -1;
		dp = new int[amount];
		return process(coins, amount);
	}

	public int process(int[] coins, int amount) {
		if (amount < 0) return -1;
		if (amount == 0) return 0;
		// 记忆化的处理，dp[n]用赋予了值，就不用继续下面的循环
		// 直接返回dp[n]的最优值
		if (dp[amount - 1] != 0) return dp[amount - 1];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			int res = process(coins, amount - coins[i]);
			if (res >= 0 && res < min) {
                // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
				min = res + 1;
			}
		}
		dp[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
		return dp[amount - 1];
	}


}
