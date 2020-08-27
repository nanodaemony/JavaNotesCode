package com.nano.datastructure.面试.其他;

/**
 * @author: nano
 * @time: 2020/8/14 14:13
 */
public class 数组中第K大的数 {



	public int findKthLargest(int[] nums, int k) {
		// 由于是第K大,所以需要减一下
		k = nums.length - k;
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int index = partition(nums, left, right);
			if (index == k) {
				break;
			} else if (index < k) {
				left = index + 1;
			} else {
				right = index - 1;
			}
		}
		return nums[k];
	}

	private int partition(int[] nums, int left, int right) {
		int i = left, j = right + 1;
		int pivotVal = nums[left];
		while (true) {
			// 找到左边
			while (nums[i] < pivotVal && i < right) i++;
			while (nums[j] > pivotVal && j > left) j--;
			if (i >= j) break;
			swap(nums, i, j);
		}
		swap(nums, left, j);
		return j;
	}

	private void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
}
