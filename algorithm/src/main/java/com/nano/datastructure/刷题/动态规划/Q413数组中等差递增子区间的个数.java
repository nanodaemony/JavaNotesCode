package com.nano.datastructure.刷题.动态规划;

/**
 * @author: nano
 * @time: 2020/8/10 14:57
 */
public class Q413数组中等差递增子区间的个数 {

	public int numberOfArithmeticSlices(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int n = nums.length;
		int[] dp = new int[n];
		for (int i = 2; i < n; i++) {
			if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
				dp[i] = dp[i - 1] + 1;
			}
		}
		int total = 0;
		for (int cnt : dp) {
			total = total + cnt;
		}
		return total;
	}

}
