package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/1 14:57
 */
public class Q12矩阵中的路径 {



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


	//------------------------再来一种写法-----------------------------------
	char[][] matrix;
	char[] word;
	public boolean exist(char[][] matrix, String word) {
		this.matrix = matrix;
		this.word = word.toCharArray();
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				// 以矩阵每个位置为开头进行dfs查询
				if(dfs(i, j, 0)) return true;
			}
		}
		return false;
	}

	// 以某个位置开始进行DFS搜索
	boolean dfs(int i, int j, int walkLen) {
		// Base case: 数组越界直接退出
		if(i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0) return false;
		// 当前位置与目标位置的字符不对应，直接返回
		if(matrix[i][j] != word[walkLen]) return false;
		// 到这里，说明每个字符都是对应的，且已经遍历的步长已经等于目标单词的长度了
		if(walkLen == word.length - 1) return true;
		// 这里是将访问过的位置修改成一个不可能出现的字符，用于标记已经访问，也可以单独使用一个visited数组进行
		char tmp = matrix[i][j];
		matrix[i][j] = '/';
		// 往四个方向增加搜索，同时已经搜索的步长+1
		boolean res = dfs(i + 1, j, walkLen + 1)
				|| dfs(i - 1, j, walkLen + 1)
				|| dfs(i, j + 1, walkLen + 1)
				|| dfs(i , j - 1, walkLen + 1);
		// 撤消修改
		matrix[i][j] = tmp;
		return res;
	}

}
