package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/2 16:58
 */
public class Q42连续子数组的最大和 {


	public int maxSubArray(int[] nums) {
		// Base case
		if (nums == null || nums.length == 0) return 0;
		// 最大和初始化为最小值
		int maxSum = Integer.MIN_VALUE;
		// 求和
		int sum = 0;
		// 遍历数组
		for (int val : nums) {
			// 如果sum已经小于0则没有增益，此处开启新一轮计数
			if (sum <= 0) {
				sum = val;
			} else {
				// 如果sum大于0则更新sum
				sum = sum + val;
			}
			// 滚动更新
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}


	public int maxSubArray2(int[] nums) {
		// 初始化为
		int res = nums[0];
		for(int i = 1; i < nums.length; i++) {
			nums[i] = nums[i] + Math.max(nums[i - 1], 0);
			res = Math.max(res, nums[i]);
		}
		return res;
	}


}
