package com.nano.datastructure.刷题.搜索问题;

/**
 * @author: nano
 * @time: 2020/8/12 17:02
 */
public class Q200岛屿数量 {


	public int numIslands(char[][] grid) {
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				// 如果当前格子是1,则代表是新的岛屿
				if (grid[i][j] == '1') {
					// 通过深度优先遍历把这个岛屿所涉及的全部位置找出来并座上标记
					dfs(grid, i, j);
					res++;
				}
			}
		}
		return res;
	}

	private void dfs(char[][] grid, int i, int j) {
		// 不能越界，同时所访问的位置不能为0或者2
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || grid[i][j] == '2') return;
		// 访问之后标记已经被访问
		grid[i][j] = '2';
		dfs(grid, i + 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i - 1, j);
		dfs(grid, i, j - 1);
	}


}
