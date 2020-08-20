package com.nano.datastructure.面试.数组题目;

/**
 * @author: nano
 * @time: 2020/8/19 14:10
 */
public class 有序数组查找目标值范围 {

	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		result[0] = findLeft(nums, target);
		result[1] = findRight(nums, target);
		return result;

	}
	public int findLeft(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (nums[mid] < target)  {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] == target) {
				right = mid - 1;
			}
		}
		if (left >= nums.length || nums[left] != target) return -1;
		return left;
	}
	public int findRight(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (nums[mid] < target)  {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] == target) {
				left = mid + 1;
			}
		}
		if (right < 0 || nums[right] != target) return -1;
		return right;
	}



}
