package com.nano.datastructure.刷题.数组与矩阵;

/**
 * https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode/
 *
 * @author: nano
 * @time: 2020/8/13 11:42
 */
public class 下一个排列 {


	public void nextPermutation(int[] nums) {
		// 从右往左找第一个降序的位置
		int i = nums.length - 2;
		while (i >= 0 && nums[i + 1] <= nums[i]) {
			i--;
		}
		// 从右往左找第一个大于i位置的元素
		if (i >= 0) {
			int j = nums.length - 1;
			while (j >= i && nums[j] <= nums[i]) {
				j--;
			}
			// 交换两个
			swap(nums, i, j);
		}
		// 逆序i后面的全部元素
		reverse(nums, i + 1);
	}

	private void reverse(int[] nums, int start) {
		int i = start, j = nums.length - 1;
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}




}
