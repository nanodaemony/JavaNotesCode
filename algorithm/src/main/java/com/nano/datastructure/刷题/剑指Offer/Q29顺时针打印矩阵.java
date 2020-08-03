package com.nano.datastructure.刷题.剑指Offer;

import java.util.ArrayList;

/**
 * @author: nano
 * @time: 2020/7/1 19:19
 */
public class Q29顺时针打印矩阵 {


	public ArrayList<Integer> printMatrix(int[][] matrix) {

		ArrayList<Integer> res = new ArrayList<>();
		// 四个变量分别指示这个矩阵的范围
		int row1 = 0, row2 = matrix.length - 1, col1 = 0, col2 = matrix[0].length - 1;
		// 结束条件就是打印到最内圈了
		while (row1 <= row2 && col1 <= col2) {
			// 下面就是依次打印一圈，注意边界控制就行
			for (int i = col1; i <= col2; i++)
				res.add(matrix[row1][i]);
			for (int i = row1 + 1; i <= row2; i++)
				res.add(matrix[i][col2]);
			if (row1 != row2)
				for (int i = col2 - 1; i >= col1; i--)
					res.add(matrix[row2][i]);
			if (col1 != col2)
				for (int i = row2 - 1; i > row1; i--)
					res.add(matrix[i][col1]);
			// 然后缩圈继续打印
			row1++; row2--; col1++; col2--;
		}
		return res;
	}

}
