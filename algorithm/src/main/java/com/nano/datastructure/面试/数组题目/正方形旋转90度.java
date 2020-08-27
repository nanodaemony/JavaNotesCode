package com.nano.datastructure.面试.数组题目;

/**
 * @author: nano
 * @time: 2020/8/24 21:33
 */
public class 正方形旋转90度 {

	public void rotate(int[][] matrix) {

		int len = matrix.length;

		// 转置矩阵
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				// (i, j) 与 (j, i) 互换
				int tmp = matrix[j][i];
				matrix[j][i] = matrix[i][j];
				matrix[i][j] = tmp;
			}
		}
		// 翻转每一行
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len / 2; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][len - j - 1];
				matrix[i][len - j - 1] = tmp;
			}
		}
	}

}
