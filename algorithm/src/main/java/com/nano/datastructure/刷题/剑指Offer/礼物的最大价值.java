package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/3 15:09
 */
public class 礼物的最大价值 {

	public static void main(String[] args) {
		int[][] arr = {{1, 10, 3, 8},
				{12, 2, 9, 6},
				{5, 7, 4, 11},
				{3, 7, 16, 5}};
		System.out.println(getMaxValue1(arr));
		System.out.println(getMaxValue2(arr));
	}

	// 利用循环的动态规划实现
	public static int getMaxValue1(int[][] array) {
		// Base case
		if (array == null || array.length == 0) return 0;

		int rows = array.length; 		// 行数
		int cols = array[0].length; 	// 列数
		// dp[m][n]表示到这个坐标最大的礼物值之和
		int[][] dp = new int[rows][cols];
		// 初始化第一行和第一列
		dp[0][0] = array[0][0];
		for (int i = 1; i < cols; i++) {
			dp[0][i] = array[0][i] + dp[0][i - 1];
		}
		for (int j = 1; j < rows; j++) {
			dp[j][0] = array[j][0] + dp[j - 1][0];
		}
		// 然后递推即可
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + array[i][j];
			}
		}
		// 返回mn位置处的值
		return dp[rows - 1][cols - 1];
	}


	/**
	 * 使用一维数组实现
	 */
	public static int getMaxValue2(int[][] arr) {
		// Base case
		if (arr == null || arr.length == 0) return 0;

		int rows = arr.length;
		int cols = arr[0].length;
		// dp数组
		int[] maxValue = new int[cols];
		//
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int left = 0;
				int up = 0;
				if (i > 0)
					up = maxValue[j];
				if (j > 0)
					left = maxValue[j - 1];
				maxValue[j] = Math.max(up, left) + arr[i][j];
			}
		}
		return maxValue[cols - 1];
	}


}
