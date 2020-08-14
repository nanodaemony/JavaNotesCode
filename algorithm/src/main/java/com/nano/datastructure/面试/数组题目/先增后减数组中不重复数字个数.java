package com.nano.datastructure.面试.数组题目;

/**
 * @author: nano
 * @time: 2020/8/14 14:26
 */
public class 先增后减数组中不重复数字个数 {

	public int diffnum(int[] nums) {
		int n = nums.length;
		if (n == 0 || nums == null) return 0;
		int left = 0;
		int right = n - 1;
		int sum = 0;
		while (left <= right) {
			if (nums[left] == nums[right]) {
				sum++;
				int temp = nums[left];
				while (left <= right && nums[right] == temp)
					right--;
				while (left <= right && nums[left] == temp)
					left++;
			} else if (nums[left] < nums[right]) {
				sum++;
				int temp = nums[left];
				while (left <= right && nums[left] == temp)
					left++;
			} else {
				sum++;
				int temp = nums[right];
				while (left <= right && nums[right] == temp)
					right--;
			}
		}
		return sum;
	}

}
