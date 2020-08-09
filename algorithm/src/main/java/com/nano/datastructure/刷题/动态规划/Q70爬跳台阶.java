package com.nano.datastructure.刷题.动态规划;

import java.util.Arrays;

/**
 * @author: nano
 * @time: 2020/7/7 15:37
 */
public class Q70爬跳台阶 {

	public int JumpFloor(int n) {
		if (n <= 2) return n;
		int back = 1, front = 2;
		int res = 1;
		// 滚动计算
		for (int i = 2; i < n; i++) {
			res = back + front;
			back = front;
			front = res;
		}
		return res;
	}


	public int JumpFloorII(int target) {
		int[] dp = new int[target];
		Arrays.fill(dp, 1);
		for (int i = 1; i < target; i++) {
			// 当前值是前面所有值的和
			for (int j = 0; j < i; j++) {
				dp[i] = dp[i] + dp[j];
			}
		}
		return dp[target - 1];
	}

}
