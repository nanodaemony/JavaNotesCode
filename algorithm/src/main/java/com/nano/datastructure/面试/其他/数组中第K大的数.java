package com.nano.datastructure.面试.其他;

/**
 * @author: nano
 * @time: 2020/8/14 14:13
 */
public class 数组中第K大的数 {

	public int findKthLargest(int[] nums, int k) {
		int len = nums.length;
		int left = 0;
		int right = len - 1;
		// 转换一下，第k大元素的索引是len-k
		int target = len - k;
		while (true) {
			int index = partition(nums, left, right);
			if (index == target) {
				return nums[index];
			} else if (index < target) {
				left = index + 1;
			} else {
				right = index - 1;
			}
		}
	}

	public int partition(int[] nums, int left, int right) {
		int pivot = nums[left];
		int j = left;
		for (int i = left + 1; i <= right; i++) {
			if (nums[i] < pivot) {
				j++;
				swap(nums, j, i);
			}
		}
		swap(nums, j, left);
		return j;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
