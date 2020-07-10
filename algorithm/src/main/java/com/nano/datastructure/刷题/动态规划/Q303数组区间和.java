package com.nano.datastructure.刷题.动态规划;

/**
 * @author: nano
 * @time: 2020/7/7 16:47
 */
public class Q303数组区间和 {

	private int[] sums;

	public Q303数组区间和(int[] nums) {
		sums = new int[nums.length + 1];
		for (int i = 1; i <= nums.length; i++) {
			sums[i] = sums[i - 1] + nums[i - 1];
		}
	}

	public int sumRange(int i, int j) {
		return sums[j + 1] - sums[i];
	}

}
