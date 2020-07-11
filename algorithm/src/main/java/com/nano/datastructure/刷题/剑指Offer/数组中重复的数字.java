package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/11 20:43
 */
public class 数组中重复的数字 {


	public int findRepeatNumber(int[] nums) {
		// Base case
		if (nums == null || nums.length <= 0) return -1;
		// 遍历一次数组
		for (int i = 0; i < nums.length; i++) {
			// 如果当前位置不等于索引则不断进行交换
			while (nums[i] != i) {
				// 如果已经有了
				if (nums[i] == nums[nums[i]]) {
					return nums[i];
				}
				// 交换
				swap(nums, i, nums[i]);
			}
		}
		return -1;
	}

	private void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}


}
