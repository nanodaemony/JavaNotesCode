package com.nano.datastructure.刷题.剑指Offer;

import java.util.Arrays;

/**
 * @author: nano
 * @time: 2020/7/30 13:26
 */
public class Q10_3变态跳台阶 {


	public int JumpFloorII(int target) {
		int[] dp = new int[target];
		Arrays.fill(dp, 1);
		for (int i = 1; i < target; i++)
			for (int j = 0; j < i; j++)
				dp[i] += dp[j];
		return dp[target - 1];
	}

	public int JumpFloorII2(int target) {
		return (int) Math.pow(2, target - 1);
	}




}
