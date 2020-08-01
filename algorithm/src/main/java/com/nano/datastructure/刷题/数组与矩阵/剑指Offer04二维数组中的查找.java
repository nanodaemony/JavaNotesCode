package com.nano.datastructure.刷题.数组与矩阵;

/**
 * @author: nano
 * @time: 2020/7/29 13:32
 */
public class 剑指Offer04二维数组中的查找 {

	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		// Base case
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		// 行号
		int i = 0;
		// 列号
		int j = matrix[0].length - 1;
		// 遍历越界则退出
		while((i <= matrix.length - 1) && (j >= 0)) {
			// 找到
			if(target == matrix[i][j]) {
				return true;
			} else if(target < matrix[i][j]) {
				j--;
			} else {
				i++;
			}
		}
		return false;
	}

}
