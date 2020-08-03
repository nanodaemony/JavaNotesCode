package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/1 15:36
 */
public class Q13机器人的运动范围 {

	// 全局计数器
	private int counter = 0;
	private int rows;
	private int cols;
	private int digitSum;
	private boolean[][] visited;

	public int movingCount(int rows, int cols, int digitSum) {
		this.rows = rows; this.cols = cols; this.digitSum = digitSum;
		// 标记是否已经访问
		visited = new boolean[rows][cols];
		// DFS
		dfs(0, 0);
		return counter;
	}

	private void dfs(int row, int col) {
		// Base case 如果遇到越界或者已经访问的就退出
		if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col])
			return;
		// 标记已经访问的位置
		visited[row][col] = true;
		// 计算这个位置的数字是否符合标准
		if (getSum(row, col) > digitSum) return;
		// 合格计数器++
		counter++;
		// 继续DFS
		dfs(row + 1, col);
		dfs(row - 1, col);
		dfs(row, col + 1);
		dfs(row, col - 1);
	}
	// 求一个位置的各位之和
	private int getSum(int i, int j) {
		int res = 0;
		int a = i;
		while(a != 0) {
			res = res + a % 10;
			a = a / 10;
		}
		a = j;
		while(a != 0) {
			res = res + a % 10;
			a = a / 10;
		}
		return res;
	}





}
