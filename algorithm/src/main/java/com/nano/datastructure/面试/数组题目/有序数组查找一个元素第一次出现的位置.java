package com.nano.datastructure.面试.数组题目;

/**
 * @author: nano
 * @time: 2020/8/19 20:24
 */
public class 有序数组查找一个元素第一次出现的位置 {


	public static int find(int[] nums, int target) {
		int len = nums.length;
		if (len == 0 || nums == null) return -1;
		if (nums[len - 1] < target) return -1;
		// 左右指针
		int left = 0;
		int right = len - 1;
		// 二分
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		// 找到
		if (nums[left] == target) {
			return left;
		} else {
			return -1;
		}
	}


}
