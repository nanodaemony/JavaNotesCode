package com.nano.datastructure.面试.动态规划;

/**
 * @author: nano
 * @time: 2020/8/28 13:58
 */
public class 数字字符串解码为字母字符串 {

	public int numDecodings(String str) {
		if (str == null || str.length() == 0) return 0;
		int len = str.length();
		// 定义dp[i]是前i个字符可以得到的解码种数
		int[] dp = new int[len + 1];
		// 第一个数字肯定只有一种
		dp[0] = 1;
		// 第一个数字是0则dp[1]为0,否则为1
		dp[1] = str.charAt(0) == '0' ? 0 : 1;
		for (int i = 2; i <= len; i++) {
			// 仅一个字符
			int one = Integer.parseInt(str.substring(i - 1, i));
			// 如果前面一个字符不为0
			if (one != 0) {
				dp[i] = dp[i] + dp[i - 1];
			}
			if (str.charAt(i - 2) == '0') {
				continue;
			}
			// 两个字符
			int two = Integer.parseInt(str.substring(i - 2, i));
			if (two <= 26) {
				dp[i] = dp[i] + dp[i - 2];
			}
		}
		return dp[len];
	}


	public int numDecodings2(String str) {
		char[] nums = str.toCharArray();
		int[] dp = new int[str.length() + 1];
		// 初始化dp
		dp[0] = 1;
		dp[1] = nums[0] == '0' ? 0 : 1;
		if (str.length() <= 1) return dp[1];

		for (int i = 2; i <= str.length(); i++) {
			// 一来就计算当前位置的前两个字符能否解析
			int two = Integer.parseInt(str.substring(i - 2, i));
			// 前面两个字符为"00"直接返回0
			if (two == 0) {
				return 0;
				// 到这说明最多只有一个字符为0
				// 第i-2个字符为0,则它只能与前面的组合解析
			} else if (str.charAt(i - 2) == '0') {
				dp[i] = dp[i - 1];
				// 第i-1个字符为0,则它自己只能与前两个位置组合
			} else if (nums[i - 1] == '0') {
				if (two > 26) return 0;
				dp[i] = dp[i - 2];
			} else if (two > 26) {
				dp[i] = dp[i - 1];
			} else {
				// 否则就类似于爬楼梯的方法数一样是前面情况的和
				dp[i] = dp[i - 1] + dp[i - 2];
			}
		}
		return dp[dp.length - 1];
	}


}
