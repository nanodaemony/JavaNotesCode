package com.nano.datastructure.刷题.动态规划;

/**
 * @author: nano
 * @time: 2020/7/7 15:44
 */
public class Q198打家劫舍 {


	public int rob(int[] nums) {

		// Base case
		if (nums == null || nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		int[] dp = new int[nums.length];
		// 初始化DP
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);

		for(int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}
		return dp[dp.length - 1];
	}


	public int rob2(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int length = nums.length;
		if (length == 1) return nums[0];
		// 使用两个变量记录之前的位置
		int slow = nums[0], fast = Math.max(nums[0], nums[1]);
		for (int i = 2; i < length; i++) {
			int temp = fast;
			fast = Math.max(slow + nums[i], fast);
			slow = temp;
		}
		return fast;
	}

}
