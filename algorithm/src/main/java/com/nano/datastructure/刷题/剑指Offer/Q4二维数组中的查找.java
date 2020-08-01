package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/14 20:26
 */
public class Q4二维数组中的查找 {

	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		// Base case
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		// 从右上角开始遍历
		int row = 0;
		int col = matrix[0].length - 1;
		// 维护别超出范围
		while((row <= matrix.length - 1) && (col >= 0)) {
			if(target == matrix[row][col]) {
				return true;
			} else if(target < matrix[row][col]) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}
}
