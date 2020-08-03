package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/8/1 15:52
 */
public class Q11旋转数组的最小数字 {

	/**
	 * 不允许数字重复
	 */
	public int minNumberInRotateArray(int[] nums) {

		if (nums.length == 0) return 0;
		// 维护两个索引
		int low = 0, high = nums.length - 1;
		// 二分查找搜索
		while (low < high) {
			// 取中值
			int mid = low + (high - low) / 2;
			// 如果中值小于等于右索引的值，说明右边是非递减的
			if (nums[mid] <= nums[high]) {
				// 目标在左边，此时更新右索引到中间
				high = mid;
			} else {	// 说明左边是非递减的
				// 目标值在右边，更新左索引到中间
				low = mid + 1;
			}
		}
		// 指针相遇，返回这个值
		return nums[low];
	}


	/**
	 * 允许数字重复
	 */
	public int minNumberInRotateArray2(int[] nums) {
		if (nums.length == 0) return 0;
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			// 左右中值都一样
			if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
				// 此时从左到右顺序查找
				return minNumber(nums, left, right);
				// 中间小于右边
			} else if (nums[mid] <= nums[right]) {
				right = mid;
				// 中间小于左边
			} else {
				left = mid + 1;
			}
		}
		return nums[left];
	}

	private int minNumber(int[] nums, int left, int right) {
		for (int i = left; i < right; i++) {
			if (nums[i] > nums[i + 1]) {
				return nums[i + 1];
			}
		}
		return nums[left];
	}

	/**
	 * 一种简单的运行重复数字的解法
	 */
	public int minArray(int[] nums) {
		int left = 0, right = nums.length - 1;
		// 整体二分模板
		while (left < right) {
			// 找中值
			int mid = (left + right) / 2;
			// 中大于右
			if (nums[mid] > nums[right]) {
				left = mid + 1;
				// 中小于右
			} else if (nums[mid] < nums[right]) {
				right = mid;
			} else {
				right--;
			}
		}
		return nums[left];
	}
}
