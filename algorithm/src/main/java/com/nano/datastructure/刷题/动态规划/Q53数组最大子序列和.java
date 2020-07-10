package com.nano.datastructure.刷题.动态规划;

/**
 * @author: nano
 * @time: 2020/7/7 17:23
 */
public class Q53数组最大子序列和 {

	/**
	 * 一维动态规划法
	 */
	public int maxSubArray(int[] nums) {
		// 数组长度
		int len = nums.length;
		if (len == 0) return 0;
		// 构造dp数组 dp数组存放的是以当前索引位置结束的子数组中的最大子序列和
		int[] dp = new int[len];
		// 初始化
		dp[0] = nums[0];
		// 遍历nums数组
		for (int i = 1; i < len; i++) {
			// 说明之前是正增益
			if (dp[i - 1] >= 0) {
				dp[i] = dp[i - 1] + nums[i];
			} else {
				// 直接取值
				dp[i] = nums[i];
			}
		}
		// 最后不要忘记遍历dp数组找到子序列和最大值
		int res = dp[0];
		for (int i = 1; i < len; i++) {
			res = Math.max(res, dp[i]);
		}
		return res;
	}

	/**
	 * 优化动态规划
	 * @param nums
	 * @return
	 */
	public int maxSubArray2(int[] nums) {
		if (nums == null) return 0;
		// 全局最大值
		int maxSum = nums[0];
		// 前一个子组合的最大值,状态压缩
		int subMax = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (subMax > 0) {
				// 前一个子组合最大值大于0，正增益
				subMax = subMax + nums[i];
			} else {
				// 前一个子组合最大值小于0，抛弃前面的结果
				subMax = nums[i];
			}
			// 计算全局最大值 滚动更新即可
			maxSum = Math.max(maxSum, subMax);
		}
		return maxSum;
	}

}
