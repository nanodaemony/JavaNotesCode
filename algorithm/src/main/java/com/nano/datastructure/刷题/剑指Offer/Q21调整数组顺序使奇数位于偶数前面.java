package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/1 16:53
 */
public class Q21调整数组顺序使奇数位于偶数前面 {


	public int[] exchange(int[] nums) {
		// 双指针
		int left = 0, right = nums.length - 1;
		// 两指针相遇
		while (left < right) {
			// 保证索引不越界的情况下从左找到一个偶数
			while (left < right && (nums[left] & 1) == 1) left++;
			// 保证索引不越界的情况下从右向左找到一个基数
			while (left < right && (nums[right] & 1) == 0) right--;
			swap(nums, left, right);
		}
		return nums;
	}

	private void swap(int[] nums, int left, int right) {
		int tmp = nums[left];
		nums[left] = nums[right];
		nums[right] = tmp;
	}


}
