package com.nano.datastructure.面试.数组题目;

/**
 * @author: nano
 * @time: 2020/8/16 11:28
 */
public class 连续子数组最大和 {


	public int maxSubArray(int[] nums) {
		// 初始化
		int res = nums[0];
		for(int i = 1; i < nums.length; i++) {
			nums[i] = nums[i] + Math.max(nums[i - 1], 0);
			res = Math.max(res, nums[i]);
		}
		return res;
	}

	public int maxSubArray2(int[] nums) {
		// 最大数组自序和
		int res = nums[0];
		// 包含最后一个元素的最大自序和
		int end = nums[0];
		for (int i = 1; i < nums.length; i++) {
			end = Math.max(end + nums[i], nums[i]);
			res = Math.max(end, res);
		}
		return res;
	}


}
