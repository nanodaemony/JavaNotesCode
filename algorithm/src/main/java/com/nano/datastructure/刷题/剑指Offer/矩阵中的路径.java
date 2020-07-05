package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/1 14:57
 */
public class 矩阵中的路径 {

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		// Base case
		if (matrix == null || rows < 1 || cols < 1 || str == null) {
			return false;
		}
		// 用于记录已经访问过位置的标志位数组
		boolean[] isVisited = new boolean[rows * cols];
		// 路径长度,表示当前以及匹配到了第几个位置
		int pathLength = 0;
		// 遍历数组进行回溯求解
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (backTracing(matrix, rows, cols, row, col, str, pathLength, isVisited))
					return true;
			}
		}
		return false;
	}


	private boolean backTracing(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength,
								boolean[] isVisited) {
		// 先根据col和row计算第一个元素转一位数组的位置
		int index = row * cols + col;
		// 递归终止条件
		if (row < 0 || col < 0 || row >= rows || col >= cols ||
				// 如果字符不匹配返回false
				matrix[index] != str[pathLength]
				|| isVisited[index] == true) {
			return false;
		}
		// 若pathLength已经到str末尾,说明之前的匹配成功了,直接返回True即可
		if (pathLength == str.length - 1) {
			return true;
		}
		// 表示已经走过了
		isVisited[index] = true;
		// 回溯递归寻找每次找到了就给k加一，找不到就需要还原
		boolean hasPath =
				backTracing(matrix, rows, cols, row - 1, col, str, pathLength + 1, isVisited)
				|| backTracing(matrix, rows, cols, row + 1, col, str, pathLength + 1, isVisited)
				|| backTracing(matrix, rows, cols, row, col - 1, str, pathLength + 1, isVisited)
				|| backTracing(matrix, rows, cols, row, col + 1, str, pathLength + 1, isVisited);
		if (hasPath) {
			return true;
		}
		// 走到这，说明这一条路不通，还原，再试其他的路径
		isVisited[index] = false;
		return false;
	}
}
