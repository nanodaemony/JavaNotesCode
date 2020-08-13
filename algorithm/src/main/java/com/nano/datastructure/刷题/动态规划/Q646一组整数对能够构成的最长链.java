package com.nano.datastructure.刷题.动态规划;

import java.util.Arrays;

/**
 * @author: nano
 * @time: 2020/8/10 14:02
 */
public class Q646一组整数对能够构成的最长链 {

	public int findLongestChain(int[][] pairs) {
		if (pairs == null || pairs.length == 0) return 0;
		Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
		int len = pairs.length;
		int[] dp = new int[len];
		// 初始化dp数组
		Arrays.fill(dp, 1);
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				// 转移方程
				if (pairs[j][1] < pairs[i][0]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		// 找到dp数组中的最大值
		int ans = 0;
		for (int x: dp) if (x > ans) ans = x;
		return ans;
	}



	public int findLongestChain2(int[][] pairs) {
		Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
		int cur = Integer.MIN_VALUE, ans = 0;
		for (int[] pair: pairs) if (cur < pair[0]) {
			cur = pair[1];
			ans++;
		}
		return ans;
	}

}
