package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/3 21:07
 */
public class Q57和为S的两个数字I {

	public int[] twoSum(int[] nums, int target) {
		// 双指针
		int low = 0, high = nums.length - 1;
		while (low < high) {
			// 求和
			int sum = nums[low] + nums[high];
			// 如果sum较小
			if (sum < target) {
				// 增加low指针
				low++;
			} else if (sum > target) {
				high--;
			} else {
				// 找到
				return new int[]{nums[low], nums[high]};
			}
		}
		return new int[0];
	}


}
