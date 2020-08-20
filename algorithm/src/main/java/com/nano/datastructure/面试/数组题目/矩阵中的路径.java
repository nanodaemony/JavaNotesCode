package com.nano.datastructure.面试.数组题目;

/**
 * @author: nano
 * @time: 2020/8/19 21:48
 */
public class 矩阵中的路径 {


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
		// 当前位置与目标位置的字符不对应,直接返回
		if(matrix[i][j] != word[walkLen]) return false;
		// 到这里,说明每个字符都是对应的,且已经遍历的步长已经等于目标单词的长度了
		if(walkLen == word.length - 1) return true;
		// 这里是将访问过的位置修改成一个不可能出现的字符,用于标记已经访问,也可以单独使用一个visited数组进行
		char tmp = matrix[i][j];
		matrix[i][j] = '/';
		// 往四个方向增加搜索,同时已经搜索的步长+1
		boolean res = dfs(i + 1, j, walkLen + 1)
				|| dfs(i - 1, j, walkLen + 1)
				|| dfs(i, j + 1, walkLen + 1)
				|| dfs(i , j - 1, walkLen + 1);
		// 回溯,撤消修改
		matrix[i][j] = tmp;
		return res;
	}
}
