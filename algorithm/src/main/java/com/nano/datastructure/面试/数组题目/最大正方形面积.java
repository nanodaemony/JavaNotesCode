package com.nano.datastructure.面试.数组题目;

/**
 * @author: nano
 * @time: 2020/8/20 14:50
 */
public class 最大正方形面积 {


	public int maximalSquare(char[][] matrix) {
		// 记录最大边长
		int maxSide = 0;
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return maxSide;
		int rows = matrix.length, columns = matrix[0].length;
		int[][] dp = new int[rows][columns];
		// 初始化第一行和第一列,原数组值为多少就是多少
		for (int i = 0; i < rows; i++) {
			dp[i][0] = matrix[i][0] - '0';
			// 使用这一步是为了兼顾数组只有一个元素或者只有一行或一列的情况
			maxSide = Math.max(maxSide, dp[i][0]);
		}
		for (int i = 0; i < columns; i++) {
			dp[0][i] = matrix[0][i] - '0';
			maxSide = Math.max(maxSide, dp[0][i]);
		}

		// 从左到右,从上到下遍历
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < columns; j++) {
				if (matrix[i][j] == '1') {
					// 找其余三个位置的最小值+1
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
					maxSide = Math.max(maxSide, dp[i][j]);
				}
				// 否则默认数组为0,不用管了
			}
		}
		return maxSide * maxSide;
	}


}
