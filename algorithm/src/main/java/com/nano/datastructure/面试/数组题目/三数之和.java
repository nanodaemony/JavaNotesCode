package com.nano.datastructure.面试.数组题目;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/14 14:20
 */
public class 三数之和 {

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> resList = new ArrayList();
		// Base case
		int len = nums.length;
		if (len < 3) return resList;
		// 对原始数组排序
		Arrays.sort(nums);

		for (int i = 0; i < len; i++) {
			// 如果当前数字大于0，则三数之和一定大于0，所以结束循环
			if (nums[i] > 0) break;
			// 去重相同的数就判断一次即可
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			// 当前元素右边部分的左右指针
			int left = i + 1;
			int right = len - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					resList.add(Arrays.asList(nums[i], nums[left], nums[right]));
					while (left < right && nums[left] == nums[left + 1]) left++; // 去重
					while (left < right && nums[right] == nums[right - 1]) right--; // 去重
					left++;
					right--;
				} else if (sum < 0) {
					left++;
				} else if (sum > 0) {
					right--;
				}
			}
		}
		return resList;
	}
}
