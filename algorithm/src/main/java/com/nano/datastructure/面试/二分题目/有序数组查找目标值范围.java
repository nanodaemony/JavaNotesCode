package com.nano.datastructure.面试.二分题目;

/**
 * @author: nano
 * @time: 2020/8/27 13:52
 */
public class 有序数组查找目标值范围 {

	public int[] searchRange(int[] nums, int target) {
		// 找目标元素的开始
		int start = binarySearch(nums, target);
		// 找到目标元素+1的数的开始再减去1就是目标元素的结尾
		int end = binarySearch(nums, target + 1) - 1;
		// 如果开始为数组长度或者这个值不对
		if (start == nums.length || nums[start] != target) {
			// 返回没找到
			return new int[]{-1, -1};
		} else {
			return new int[]{start, end};
		}
	}
	// 二分查找一个元素最左边的开始位置
	private int binarySearch(int[] nums, int target) {
		// 注意right的初始值
		int left = 0, right = nums.length;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] >= target) {
				// mid也可能是答案
				right = mid;
			} else {
				// 左边收缩时mid不能为答案
				left = mid + 1;
			}
		}
		// 最极端的情况返回的是left为数组长度表示找不到
		return left;
	}


}
