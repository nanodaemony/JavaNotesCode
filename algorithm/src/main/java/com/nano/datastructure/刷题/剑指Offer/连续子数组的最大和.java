package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/2 16:58
 */
public class 连续子数组的最大和 {


	public int FindGreatestSumOfSubArray(int[] nums) {
		// Base case
		if (nums == null || nums.length == 0) return 0;
		// 最大和初始化为最小值
		int greatestSum = Integer.MIN_VALUE;
		// 求和
		int sum = 0;
		// 遍历数组
		for (int val : nums) {
			if (sum <= 0) {
				sum = val;
			} else {
				// 如果sum大于0则更新sum
				sum = sum + val;
			}
			greatestSum = Math.max(greatestSum, sum);
		}
		return greatestSum;
	}

	/**
	 * 动态规划版本
	 */
	public int FindGreatestSumOfSubArray2(int[] nums) {
		// max就是上面的dp[i]
		int max = nums[0];
		// 因为这个dp[i]老是变，所以比如你dp[4]是8 dp[5]就变成-7了，所以需要res保存一下
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			max = Math.max(max + nums[i], nums[i]);
			res = Math.max(res, max);
		}
		return res;
	}

}
