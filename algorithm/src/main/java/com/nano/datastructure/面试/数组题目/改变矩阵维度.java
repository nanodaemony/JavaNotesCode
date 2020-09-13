package com.nano.datastructure.面试.数组题目;

/**
 * @author: nano
 * @time: 2020/9/13 16:30
 */
public class 改变矩阵维度 {

	public int[][] matrixReshape(int[][] nums, int r, int c) {
		int m = nums.length, n = nums[0].length;
		// 不合格直接返回原矩阵
		if (m * n != r * c) {
			return nums;
		}
		int[][] res = new int[r][c];
		int index = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				res[i][j] = nums[index / n][index % n];
				index++;
			}
		}
		return res;
	}

}
