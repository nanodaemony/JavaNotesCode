package com.nano.datastructure.面试.动态规划;

/**
 * @author: nano
 * @time: 2020/8/22 17:12
 */
public class 换钱的最大方法数 {


	public int change(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;

		for (int coin : coins) {
			for (int i = coin; i < amount + 1; i++) {
				dp[i] = dp[i] + dp[i - coin];
			}
		}
		return dp[amount];
	}


	public int change2(int amount, int[] coins) {
		int num = coins.length;
		int[] dp = new int[amount + 1];
		// dp[i][j]表示从前i个零钱里选择若干去兑换面额为j的整钞
		// 从0个零钱里去兑换面额为0的整钱是可兑换的,一个方案
		dp[0] = 1;
		// 面额>0的情况无法兑换,取方案数为默认值0
		// 对前i个零钱来说,其中第i个零钱是coin[i-1]
		for (int i = 1; i <= num; i++) {
			// 待兑换面额为j,只有j>=coins[i-1]时,才会新增兑换方案数
			for (int j = coins[i - 1]; j <= amount; j++) {
				// 根据背包九讲,完全背包问题正序更新一维数组
				dp[j] = dp[j] + dp[j - coins[i - 1]];
			}
		}
		return dp[amount];
	}


}
