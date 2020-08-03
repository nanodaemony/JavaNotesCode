package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/8/1 16:53
 */
public class Q14剪绳子 {

	/**
	 * 贪心法
	 */
	public int cuttingRope(int n) {
		if (n <= 3) return n - 1;
		int a = n / 3, b = n % 3;
		if (b == 0) return (int) Math.pow(3, a);
		if (b == 1) return (int) Math.pow(3, a - 1) * 4;
		return (int) Math.pow(3, a) * 2;
	}

	public int integerBreak(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		for (int i = 2; i <= n; i++)
			for (int j = 1; j < i; j++)
				dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
		return dp[n];
	}

	public int cuttingRope3(int n) {
		//1.创建数组-设置对应的含义,dp[n]为长度为 n 时候，最大的乘积 我们只需求出dp[n]
		int[] dp = new int[n + 7];
		//3.确定初始值
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 2;
		dp[4] = 4;
		dp[5] = 6;
		dp[6] = 9;
		if (n <= 6) {
			return dp[n];
		}
		//2.找到递推关系
		for (int i = 7; i <= n; i++) {
			dp[i] = dp[i - 3] * 3;
		}
		return dp[n];
	}


	/**
	 * 结果过大需要取模时
	 */
	public int cuttingRope4(int n) {
		if (n <= 3) return n - 1;
		int b = n % 3, mod = 1000000007;
		long rem = 1, x = 3;
		for (int a = n / 3 - 1; a > 0; a /= 2) {
			if (a % 2 == 1) rem = (rem * x) % mod;
			x = (x * x) % mod;
		}
		if (b == 0) return (int) (rem * 3 % mod);
		if (b == 1) return (int) (rem * 4 % mod);
		return (int) (rem * 6 % mod);
	}

}
