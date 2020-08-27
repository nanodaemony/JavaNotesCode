package com.nano.datastructure.面试.二分题目;

/**
 * @author: nano
 * @time: 2020/8/27 13:49
 */
public class 旋转数组的最小数字 {

	public int findMin(int[] nums) {
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] <= nums[right]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return nums[left];
	}
}
