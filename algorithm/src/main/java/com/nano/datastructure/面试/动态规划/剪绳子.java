package com.nano.datastructure.面试.动态规划;

/**
 * @author: nano
 * @time: 2020/8/20 23:42
 */
public class 剪绳子 {

	public int cutRope(int target) {
		if(target == 2) return 1;
		if(target == 3) return 2;
		if(target == 4) return 4;
		int[] dp = new int[target + 1];

		// 下面3行是n>=4的情况，跟n<=3不同，4可以分很多段，比如分成1、3，
		// 这里3可以不需要再分了，因为3分段最大才2，不分就是3。记录最大的。
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		// 用来记录最大值
		int res = 0;
		for(int i = 4; i <= target; i++){
			for(int j = 1; j <= i / 2; j++){
				res = Math.max(res, dp[j] * dp[i - j]);
			}
			dp[i] = res;
		}
		return dp[target];
	}

}
