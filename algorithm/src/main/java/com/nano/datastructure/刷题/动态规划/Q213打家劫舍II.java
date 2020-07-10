package com.nano.datastructure.刷题.动态规划;

/**
 * @author: nano
 * @time: 2020/7/7 15:56
 */
public class Q213打家劫舍II {


	public int rob(int[] nums) {
		// Base case
		if (nums == null || nums.length == 0) return 0;
		int len = nums.length;
		if (len == 1) return nums[0];
		// 不偷窃第一个房子和不偷窃最后一个房子取较大值
		return Math.max(normalRob(nums, 0, len - 2), normalRob(nums, 1, len - 1));
	}


	// 指定范围的打家劫舍
	private int normalRob(int[] nums, int firstRob, int lastRob) {
		int pre2 = 0, pre1 = 0;
		for (int i = firstRob; i <= lastRob; i++) {
			int cur = Math.max(pre1, pre2 + nums[i]);
			pre2 = pre1;
			pre1 = cur;
		}
		return pre1;
	}

}
