package com.nano.datastructure.面试.动态规划;

import java.util.Arrays;

/**
 * @author: nano
 * @time: 2020/8/28 15:26
 */
public class 一组整数对能够构成的最长链 {

	public int findLongestChain(int[][] nums) {
		if (nums == null || nums.length == 0) return 0;
		// 按照数组第一个元素排序
		Arrays.sort(nums, (a, b) -> (a[0] - b[0]));
		int len = nums.length;
		int[] dp = new int[len];
		// 全部初始化为1
		Arrays.fill(dp, 1);
		int res = Integer.MIN_VALUE;
		for (int i = 1; i < len; i++) {
			// 从之前的里面序列里面找看能不能更新
			for (int j = 0; j < i; j++) {
				if (nums[j][1] < nums[i][0]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				// 滚动更新res
				res = Math.max(res, dp[i]);
			}
		}
		return res;
	}

}
