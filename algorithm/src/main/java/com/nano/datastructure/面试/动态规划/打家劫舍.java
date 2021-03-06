package com.nano.datastructure.面试.动态规划;

/**
 * @author: nano
 * @time: 2020/8/28 12:40
 */
public class 打家劫舍 {

	public int rob(int[] nums) {
		// Base case
		if (nums == null || nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		int[] dp = new int[nums.length];
		// 初始化DP
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for(int i = 2; i < nums.length; i++) {
			// 两种情况找最大的
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}
		return dp[dp.length - 1];
	}

	public int rob2(int[] nums) {
		int slow = 0, fast = 0;
		for (int i = 0; i < nums.length; i++) {
			int cur = Math.max(slow + nums[i], fast);
			slow = fast;
			fast = cur;
		}
		return fast;
	}

}
