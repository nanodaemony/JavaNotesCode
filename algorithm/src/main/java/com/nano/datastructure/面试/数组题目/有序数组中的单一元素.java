package com.nano.datastructure.面试.数组题目;

/**
 * @author: nano
 * @time: 2020/8/20 13:55
 */
public class 有序数组中的单一元素 {


	public int singleNonDuplicate(int[] nums) {
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int mid = (right + left) / 2;
			// 中间索引为奇数
			if (mid % 2 == 1) {
				if (nums[mid] == nums[mid + 1]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
				 // 中间索引为偶数
			} else {
				if (nums[mid] == nums[mid + 1]) {
					left = mid + 2;
				} else {
					right = mid;
				}
			}
		}
		return nums[left];
	}


}
