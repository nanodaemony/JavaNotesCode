package com.nano.datastructure.面试.数组题目;

/**
 * @author: nano
 * @time: 2020/8/19 14:40
 */
public class 矩阵旋转90度 {

	public static int[][] change(int[][] matrix) {
		// 矩阵形状变化
		int[][] res = new int[matrix[0].length][matrix.length];
		int dst = matrix.length - 1;
		for (int i = 0; i < matrix.length; i++, dst--) {
			for (int j = 0; j < matrix[0].length; j++) {
				// 核心代码
				res[j][dst] = matrix[i][j];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		int[][] temp = change(matrix);
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				System.out.print(temp[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
