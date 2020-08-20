package com.nano.datastructure.面试.动态规划;

/**
 * @author: nano
 * @time: 2020/8/20 22:01
 */
public class 连续子数组最大乘积 {

	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int res = nums[0];
		int preMax = nums[0];
		int preMin = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int curMax = Math.max(Math.max(preMax * nums[i], preMin * nums[i]), nums[i]);
			int curMin = Math.min(Math.min(preMax * nums[i], preMin * nums[i]), nums[i]);
			res = Math.max(res, curMax);
			preMax = curMax;
			preMin = curMin;
		}
		return res;
	}


}
