package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/1 14:39
 */
public class 旋转数组中的最小数字 {

	public int minNumberInRotateArray(int[] nums) {

		if (nums.length == 0) {
			return 0;
		}
		// 维护两个索引
		int low = 0, high = nums.length - 1;
		// 二分查找方式
		while (low < high) {
			// 中值
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

}
