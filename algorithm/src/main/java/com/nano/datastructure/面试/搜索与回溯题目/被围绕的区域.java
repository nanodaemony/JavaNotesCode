package com.nano.datastructure.面试.搜索与回溯题目;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: nano
 * @time: 2020/8/27 14:46
 */
public class 被围绕的区域 {

	public void solve(char[][] board) {
		if (board == null || board.length == 0) return;
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// 从边缘O开始搜索
				boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
				if (isEdge && board[i][j] == 'O') {
					dfs(board, i, j);
				}
			}
		}
		// 将临时标记的字符#转为O
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if (board[i][j] == '#') {
					board[i][j] = 'O';
				}
			}
		}
	}

	public void dfs(char[][] board, int i, int j) {
		if (i < 0 || j < 0 || i >= board.length  || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
			// board[i][j]=='#'说明已经搜索过了
			return;
		}
		// 做一个标记,说明是不用转换的
		board[i][j] = '#';
		dfs(board, i - 1, j); // 上
		dfs(board, i + 1, j); // 下
		dfs(board, i, j - 1); // 左
		dfs(board, i, j + 1); // 右
	}


}
