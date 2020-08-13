package com.nano.datastructure.刷题.动态规划;

/**
 * @author: nano
 * @time: 2020/8/10 15:28
 */
public class Q416划分数组为相等的两部分 {


	public boolean canPartition(int[] nums) {
		int len = nums.length;
		if (len == 0) return false;

		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		// 如果是奇数就不符合要求
		if ((sum & 1) == 1) return false;
		int target = sum / 2;

		// 创建二维状态数组，行：物品索引，列：容量（包括 0）
		boolean[][] dp = new boolean[len][target + 1];

		// 先填表格第0行，第1个数只能让容积为它自己的背包恰好装满
		if (nums[0] <= target) dp[0][nums[0]] = true;

		// 再填表格后面几行
		for (int i = 1; i < len; i++) {
			for (int j = 0; j <= target; j++) {
				// 直接从上一行先把结果抄下来，然后再修正
				dp[i][j] = dp[i - 1][j];
				if (nums[i] == j) {
					dp[i][j] = true;
					continue;
				}
				if (nums[i] < j) {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
				}
			}
		}
		return dp[len - 1][target];
	}


	public boolean canPartition2(int[] nums) {
		int sum = computeArraySum(nums);
		if (sum % 2 != 0) {
			return false;
		}
		int W = sum / 2;
		boolean[] dp = new boolean[W + 1];
		dp[0] = true;
		for (int num : nums) {                 // 0-1 背包一个物品只能用一次
			for (int i = W; i >= num; i--) {   // 从后往前，先计算 dp[i] 再计算 dp[i-num]
				dp[i] = dp[i] || dp[i - num];
			}
		}
		return dp[W];
	}

	private int computeArraySum(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		return sum;
	}

}
