package com.nano.datastructure.面试.数组题目;

/**
 * @author: nano
 * @time: 2020/8/14 22:03
 */
public class 螺旋打印矩阵 {


	public int[][] generateMatrix(int n) {
		int[][] nums = new int[n][n];
		int num = 1;
		int up = 0;
		int right = n - 1;
		int down = n - 1;
		int left = 0;
		// 直到num小于平方
		while (num <= n * n) {
			for (int col = left; col <= right; col++) {
				nums[up][col] = num;
				num++;
			}
			up++;
			for (int row = up; row <= down; row++) {
				nums[row][right] = num;
				num++;
			}
			right--;
			for (int col = right; col >= left; col--) {
				nums[down][col] = num;
				num++;
			}
			down--;
			for (int row = down; row >= up; row--) {
				nums[row][left] = num;
				num++;
			}
			left++;
		}
		return nums;
	}

}
