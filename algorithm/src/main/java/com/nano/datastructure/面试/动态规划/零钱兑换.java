package com.nano.datastructure.面试.动态规划;

import java.util.Arrays;

/**
 * @author: nano
 * @time: 2020/8/22 16:25
 */
public class 零钱兑换 {

	//----------------------暴力递归法----------------超出时间-------------------

	int res = Integer.MAX_VALUE;

	public int coinChange(int[] coins, int amount) {
		if (coins.length == 0) return -1;

		findWay(coins, amount, 0);

		// 如果没有任何一种硬币组合能组成总金额，返回 -1。
		if (res == Integer.MAX_VALUE) return -1;
		return res;
	}

	public void findWay(int[] coins, int amount, int count) {
		// Base case
		if (amount < 0) return;
		// 刚好金额到0了,更新一下答案
		if (amount == 0) {
			res = Math.min(res, count);
		}
		// 每次选择coin里面的一个硬币
		for (int i = 0; i < coins.length; i++) {
			findWay(coins, amount - coins[i], count + 1);
		}
	}


	//-----------记忆化搜索---------------------------------

	int[] memo;

	public int coinChange2(int[] coins, int amount) {
		if (coins.length == 0) return -1;
		memo = new int[amount];
		return findWay(coins, amount);
	}

	// memo[n]表示钱币n可以被换取的最少的硬币数，不能换取就为-1
	// findWay函数的目的是为了找到amount数量的零钱可以兑换的最少硬币数量,返回其值int
	public int findWay(int[] coins, int amount) {
		if (amount < 0) return -1;
		if (amount == 0) return 0;
		// 记忆化的处理,如果memo已经有值就不用继续下面的循环,直接的返回memo[n]的最优值
		if (memo[amount - 1] != 0) {
			return memo[amount - 1];
		}
		// 维护一个换钱的最小值,下面遍历递归找最小值
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			// 递归求每种硬币需要多少
			int res = findWay(coins, amount - coins[i]);
			if (res >= 0 && res < min) {
				// 加1是为了加上得到res结果的那个步骤中，兑换的一个硬币
				min = res + 1;
			}
		}
		// 记录到备忘录中
		memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
		return memo[amount - 1];
	}


	//-----------------动态规划--------------------------------
	public int coinChange3(int[] coins, int amount) {
		// 自底向上的动态规划
		if (coins.length == 0) return -1;

		// memo[n]的值表示的凑成总金额为n所需的最少的硬币个数
		int[] memo = new int[amount + 1];
		// 给memo赋初值，最多的硬币数就是全部使用面值1的硬币进行换
		// amount+1是不可能达到的换取数量，于是使用其进行填充
		Arrays.fill(memo, amount + 1);
		memo[0] = 0;
		// 钱数从1到amout
		for (int i = 1; i <= amount; i++) {
			// 遍历每个coin
			for (int j = 0; j < coins.length; j++) {
				// 说明当前能换钱
				if (i - coins[j] >= 0) {
					// memo[i]有两种实现的方式，
					// 一种是包含当前的coins[i],那么剩余钱就是 i-coins[i],这种操作要兑换的硬币数是memo[i-coins[j]] + 1
					// 另一种就是不包含,要兑换的硬币数是memo[i]
					memo[i] = Math.min(memo[i], memo[i - coins[j]] + 1);
				}
			}
		}
		return memo[amount] == (amount + 1) ? -1 : memo[amount];
	}


}
