package com.nano.datastructure.刷题.动态规划;

/**
 * @author: nano
 * @time: 2020/7/7 17:14
 */
public class Q1025除数博弈 {


	public boolean divisorGame_dynamicPlanning(int N) {
		if (N == 1) return false;
		if (N == 2) return true;
		boolean[] dp = new boolean[N + 1];
		dp[1] = false;
		dp[2] = true;
		for (int i = 3; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if (i % j == 0 && !dp[i - j]) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[N];
	}
}
