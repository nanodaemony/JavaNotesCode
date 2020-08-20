package com.nano.datastructure.面试.数组题目;

/**
 * @author: nano
 * @time: 2020/8/19 19:59
 */
public class 最短需要升序的子数组 {

	public int findUnsortedSubarray(int[] nums) {
		int len = nums.length;
		// 左右指针
		int left = 0, right = -1;
		// 记录最大的数与最小的数
		int max = nums[0], min = nums[len - 1];

		// 从左往右找右边界
		for (int i = 0; i < len; i++) {
			if (nums[i] < max) {
				right = i;
			} else {
				max = nums[i];
			}
		}
		// 从右往左找左边界
		for (int i = len - 1; i >= 0; i--) {
			if (nums[i] > min) {
				left = i;
			} else {
				min = nums[i];
			}
		}
		// 求出边界范围
		return right - left + 1;
	}


}
