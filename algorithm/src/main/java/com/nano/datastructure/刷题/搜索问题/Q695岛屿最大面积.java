package com.nano.datastructure.刷题.搜索问题;

/**
 * @author: nano
 * @time: 2020/8/12 17:02
 */
public class Q695岛屿最大面积 {


	public int maxAreaOfIsland(int[][] grid) {
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				// 如果当前格子是1,则代表是新的岛屿
				// 通过深度优先遍历把这个岛屿所涉及的全部位置找出来并座上标记
				res = Math.max(res, dfs(grid, i, j));
			}
		}
		return res;
	}

	private int dfs(int[][] grid, int i, int j) {
		// 不能越界，同时所访问的位置不能为0或者2
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || grid[i][j] == 2) return 0;
		// 到了这里说明是一个新的格子，此时面积应该+1
		// 访问之后标记已经被访问
		grid[i][j] = 2;
		int area1 = dfs(grid, i + 1, j);
		int area2 = dfs(grid, i, j + 1);
		int area3 = dfs(grid, i - 1, j);
		int area4 = dfs(grid, i, j - 1);
		return area1 + area2 + area3 + area4 + 1;
	}


}
