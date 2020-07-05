package com.nano.datastructure.刷题.剑指Offer;

import java.util.Arrays;

/**
 * @author: nano
 * @time: 2020/7/1 14:29
 */
public class 跳台阶 {

	/**
	 * 普通跳台阶
	 */
	public int JumpFloor(int n) {
		if (n <= 2) {
			return n;
		}
		int back = 1, front = 2;
		int result = 1;
		// 滚动计算
		for (int i = 2; i < n; i++) {
			result = back + front;
			back = front;
			front = result;
		}
		return result;
	}

	/**
	 * 变态跳台阶--动态规划
	 */
	public int JumpFloorIIDynamic(int target) {
		int[] dp = new int[target];
		// 全部初始化为1
		Arrays.fill(dp, 1);
		for (int i = 1; i < target; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j];
			}
		}
		return dp[target - 1];
	}


	/**
	 * 变态跳台阶-公式法
	 * f(n) = 2 * f(n-1)
	 */
	public int JumpFloorIIMath(int target) {
		return (int) Math.pow(2, target - 1);
	}

}
