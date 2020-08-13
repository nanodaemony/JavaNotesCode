package com.nano.datastructure.刷题.动态规划;

/**
 * @author: nano
 * @time: 2020/8/10 14:15
 */
public class Q376最长摆动子序列 {


	public int wiggleMaxLength(int[] nums) {
		if (nums.length < 2) return nums.length;
		// 两个dp数组
		int[] up = new int[nums.length];
		int[] down = new int[nums.length];

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					up[i] = Math.max(up[i], down[j] + 1);
				} else if (nums[i] < nums[j]) {
					down[i] = Math.max(down[i], up[j] + 1);
				}
			}
		}
		return 1 + Math.max(down[nums.length - 1], up[nums.length - 1]);
	}

	public int wiggleMaxLength2(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int up = 1, down = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				up = down + 1;
			} else if (nums[i] < nums[i - 1]) {
				down = up + 1;
			}
		}
		return Math.max(up, down);
	}

}
