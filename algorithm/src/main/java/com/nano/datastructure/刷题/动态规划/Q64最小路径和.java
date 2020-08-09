package com.nano.datastructure.刷题.动态规划;

/**
 * @author: nano
 * @time: 2020/7/7 16:28
 */
public class Q64最小路径和 {

	public int minPathSum(int[][] nums) {
		int row = nums.length;
		int col = nums[0].length;
		if (row == 0 || col == 0) return 0;

		int[][] dp = new int[row][col];
		// 初始化第一行第一列
		dp[0][0] = nums[0][0];
		for (int i = 1; i < row; i++) {
			dp[i][0] = dp[i - 1][0] + nums[i][0];
		}
		for (int j = 1; j < col; j++) {
			dp[0][j] = dp[0][j - 1] + nums[0][j];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + nums[i][j];
			}
		}
		return dp[row - 1][col - 1];
	}


	/**
	 * 一维Dp
	 */
	public int minPathSum2(int[][] nums) {
		// Base case
		if (nums.length == 0 || nums[0].length == 0) return 0;
		int col = nums.length, row = nums[0].length;
		int[] dp = new int[row];
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				// 只能从上侧走到该位置
				if (j == 0) {
					dp[j] = dp[j];
				} else if (i == 0) {
					// 只能从左侧走到该位置
					dp[j] = dp[j - 1];
				} else {
					dp[j] = Math.min(dp[j - 1], dp[j]);
				}
				dp[j] = dp[j] + nums[i][j];
			}
		}
		return dp[row - 1];
	}

}
