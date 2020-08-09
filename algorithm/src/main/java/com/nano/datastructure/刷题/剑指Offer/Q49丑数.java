package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/3 16:44
 */
public class Q49丑数 {

	public int nthUglyNumber(int n) {
		// 初始化三个指针分别记录
		int p2 = 0, p3 = 0, p5 = 0;
		int[] dp = new int[n];
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			// 选择三个数中最小的一个
			dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
			// 看当前的数是由哪个位置来的，增加位置索引
			if (dp[i] == dp[p2] * 2) p2++;
			if (dp[i] == dp[p3] * 3) p3++;
			if (dp[i] == dp[p5] * 5) p5++;
		}
		return dp[n - 1];
	}


}
