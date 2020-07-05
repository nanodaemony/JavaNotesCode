package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/1 15:36
 */
public class 机器人的运动范围 {

	// 这个数组用于DFS的几个方向
	private static final int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	// 全局计数器
	private int cnt = 0;
	private int rows;
	private int cols;
	private int threshold;
	private int[][] digitSum;

	public int movingCount(int threshold, int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.threshold = threshold;
		initDigitSum();
		// 标记是否已经访问
		boolean[][] marked = new boolean[rows][cols];
		// DFS
		dfs(marked, 0, 0);
		return cnt;
	}

	private void dfs(boolean[][] marked, int row, int col) {
		// Base case
		if (row < 0 || row >= rows || col < 0 || col >= cols || marked[row][col])
			return;
		// 标记已经访问的位置
		marked[row][col] = true;
		// 计算这个位置的数字是否符合标准
		if (this.digitSum[row][col] > this.threshold)
			return;
		// 合格计数器++
		cnt++;
		// 继续DFS
		for (int[] n : next)
			dfs(marked, row + n[0], col + n[1]);
	}

	private void initDigitSum() {
		int[] digitSumOne = new int[Math.max(rows, cols)];
		for (int i = 0; i < digitSumOne.length; i++) {
			int n = i;
			while (n > 0) {
				digitSumOne[i] += n % 10;
				n /= 10;
			}
		}
		this.digitSum = new int[rows][cols];
		for (int i = 0; i < this.rows; i++)
			for (int j = 0; j < this.cols; j++)
				this.digitSum[i][j] = digitSumOne[i] + digitSumOne[j];
	}


	/**
	 * 动态规划版本
	 */
	public int integerBreak(int target) {
		// dp数组，表示以长度为n的绳子可以得到最多的切分乘积
		int[] dp = new int[target + 1];
		// 初始化为1
		dp[1] = 1;
		for (int i = 2; i <= target; i++)
			for (int j = 1; j < i; j++)
				dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
		return dp[target];
	}

}
