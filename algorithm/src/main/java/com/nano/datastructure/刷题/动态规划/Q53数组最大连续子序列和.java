package com.nano.datastructure.刷题.动态规划;

/**
 * @author: nano
 * @time: 2020/7/7 17:23
 */
public class Q53数组最大连续子序列和 {

	/**
	 * 一维动态规划法
	 */
	public int maxSubArray(int[] nums) {
		// 数组长度
		int len = nums.length;
		if (len == 0) return 0;
		// 构造dp数组 dp数组存放的是以当前索引位置结束的子数组中的最大子序列和
		int[] dp = new int[len];
		// 初始化dp数组
		dp[0] = nums[0];
		// 遍历nums数组
		for (int i = 1; i < len; i++) {
			// 如果前一个大于0说明之前是正增益
			if (dp[i - 1] >= 0) {
				dp[i] = dp[i - 1] + nums[i];
			} else {
				// 直接取当前值
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
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (sum > 0) {
				// 前一个子组合最大值大于0，正增益
				sum = sum + nums[i];
			} else {
				// 前一个子组合最大值小于0，抛弃前面的结果
				sum = nums[i];
			}
			// 计算全局最大值 滚动更新即可
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}

	public int maxSubArray3(int[] nums) {
		return maxSubArrayDivideWithBorder(nums, 0, nums.length - 1);
	}

	private int maxSubArrayDivideWithBorder(int[] nums, int start, int end) {
		// 只有一个元素，也就是递归的结束情况
		if (start == end) return nums[start];

		// 计算中间值
		int center = (start + end) / 2;
		// 分别递归计算左侧子序列最大值
		int leftMax = maxSubArrayDivideWithBorder(nums, start, center);
		int rightMax = maxSubArrayDivideWithBorder(nums, center + 1, end);
		// 下面计算横跨两个子序列的最大值
		// 计算包含左侧子序列最后一个元素的子序列最大值
		int leftCrossMax = Integer.MIN_VALUE; // 初始化一个值
		int leftCrossSum = 0;
		for (int i = center ; i >= start ; i --) {
			leftCrossSum += nums[i];
			leftCrossMax = Math.max(leftCrossSum, leftCrossMax);
		}

		// 计算包含右侧子序列最后一个元素的子序列最大值
		int rightCrossMax = nums[center+1];
		int rightCrossSum = 0;
		for (int i = center + 1; i <= end ; i ++) {
			rightCrossSum += nums[i];
			rightCrossMax = Math.max(rightCrossSum, rightCrossMax);
		}

		// 计算跨中心的子序列的最大值
		int crossMax = leftCrossMax + rightCrossMax;

		// 比较三者，返回最大值
		return Math.max(crossMax, Math.max(leftMax, rightMax));
	}

}
