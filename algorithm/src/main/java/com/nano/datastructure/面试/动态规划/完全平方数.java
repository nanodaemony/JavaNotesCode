package com.nano.datastructure.面试.动态规划;

/**
 * @author: nano
 * @time: 2020/8/25 12:04
 */
public class 完全平方数 {


	public int numSquares(int num) {
		if (num < 1) return -1;
		int[] dp = new int[num + 1];
		// 初始化dp数组为这个数:也就是假设当前num最多需要num个1组成
		for (int i = 0; i <= num; i++) {
			dp[i] = i;
		}

		for (int i = 1; i <= num; i++) {
			// 从1到j分别看i减去j的平方是否还大于0
			for (int j = 1; j < i; j++) {
				// 必须大于0
				if(i - j * j >= 0) {
					// 更新dp数组
					dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
				}
			}
		}
		return dp[num];
	}

}
