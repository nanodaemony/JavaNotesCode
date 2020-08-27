package com.nano.datastructure.面试.双指针题目;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/23 19:10
 */
public class 最接近的三数之和 {

	public int threeSumClosest(int[] nums, int target) {
		// 排个序
		Arrays.sort(nums);
		int res = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length; i++) {
			// 每次找从当前位置的右边的数组中找
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				int sum = nums[left] + nums[right] + nums[i];
				// 更新res
				if (Math.abs(target - sum) < Math.abs(target - res)) {
					res = sum;
				}
				if (sum > target) {
					right--;
				} else if (sum < target) {
					left++;
				} else {
					// 说明就是结果
					return res;
				}
			}
		}
		return res;
	}

}
