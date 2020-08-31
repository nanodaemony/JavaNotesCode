package com.nano.datastructure.面试.动态规划;

/**
 * @author: nano
 * @time: 2020/8/28 15:43
 */
public class 最长摆动序列 {

	public int wiggleMaxLength(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		// 记录上升与下降
		int up = 1, down = 1;
		for (int i = 1; i < nums.length; i++) {
			// 当前在上升
			if (nums[i] > nums[i - 1]) {
				up = down + 1;
				// 当前在下降
			} else if (nums[i] < nums[i - 1]) {
				down = up + 1;
			}
		}
		return Math.max(up, down);
	}


	
}
