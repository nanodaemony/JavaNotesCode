package com.nano.datastructure.面试.动态规划;

/**
 * @author: nano
 * @time: 2020/8/28 13:33
 */
public class 数组中等差递增子区间的个数 {

	public int numberOfArithmeticSlices(int[] A) {
		if (A == null || A.length == 0) return 0;

		int len = A.length;
		int[] dp = new int[len];
		for (int i = 2; i < len; i++) {
			// 如果满足转移方程条件
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				dp[i] = dp[i - 1] + 1;
			}
		}
		// 计算所有位置的累加和
		int total = 0;
		for (int cnt : dp) {
			total = total + cnt;
		}
		return total;
	}

}
