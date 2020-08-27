package com.nano.datastructure.面试.其他;

/**
 * @author: nano
 * @time: 2020/8/25 12:36
 */
public class 颜色分类 {

	public void sortColors(int[] nums) {
		// 左右指针
		int left = 0;
		int right = nums.length - 1;
		// 当前比较元素指针
		int cur = 0;

		while (cur <= right) {
			if (nums[cur] == 0) {
				swap(nums, left, cur);
				left++;
				cur++;
			} else if (nums[cur] == 2) {
				swap(nums, right, cur);
				right--;
				// 说明当前元素为1
			} else {
				cur++;
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}


}
