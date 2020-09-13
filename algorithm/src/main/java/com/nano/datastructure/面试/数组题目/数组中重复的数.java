package com.nano.datastructure.面试.数组题目;

/**
 * @author: nano
 * @time: 2020/9/13 16:40
 */
public class 数组中重复的数 {


	public int findDuplicate(int[] nums) {
		// Base case
		if (nums == null || nums.length <= 0) return -1;
		// 遍历一次数组
		for (int i = 0; i < nums.length; i++) {
			// 如果当前位置不等于索引则不断进行交换
			while (nums[i] != i) {
				// 如果目标索引处已经有了元素则说明重复
				if (nums[i] == nums[nums[i]]) {
					return nums[i];
				}
				// 否则进行交换
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
