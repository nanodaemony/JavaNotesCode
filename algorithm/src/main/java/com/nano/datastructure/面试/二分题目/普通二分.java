package com.nano.datastructure.面试.二分题目;

/**
 * @author: nano
 * @time: 2020/8/27 12:40
 */
public class 普通二分 {

	public int binarySearch(int[] nums, int key) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			// 求中等索引
			int mid = left + (right - left) / 2;
			if (nums[mid] == key) {
				return mid;
				// 由于mid已经判断了所以下面不用考虑mid了
			} else if (nums[mid] > key) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

}
