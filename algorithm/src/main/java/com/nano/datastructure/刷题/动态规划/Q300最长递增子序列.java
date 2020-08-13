package com.nano.datastructure.刷题.动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个长度为N的数组，找出一个最长的单调自增子序列（不一定连续，但是顺序不能乱）。
 * 例如：给定一个长度为6的数组A{5， 6， 7， 1， 2， 8}，
 * 则其最长的单调递增子序列为{5，6，7，8}，长度为4.
 */
public class Q300最长递增子序列 {

	public int lengthOfLIS(int[] nums) {
		// Base case
		int len = nums.length;
		if (len == 0) return 0;

		int res = 1;
		int[] dp = new int[len];
		// 全部填充为1
		Arrays.fill(dp, 1);

		for (int i = 1; i < len; i++) {
			// 找到之前所有小于nums[i]的值中dp值最大的
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		// 找dp中最大的值
		for (int i = 0; i < len; i++) {
			res = Math.max(dp[i], res);
		}
		return res;
	}

	/**
	 * 优化DP
	 */
	public int lengthOfLIS2(int[] nums) {
		int n = nums.length;
		int[] tails = new int[n];
		int len = 0;
		for (int num : nums) {
			int index = binarySearch(tails, len, num);
			tails[index] = num;
			if (index == len) {
				len++;
			}
		}
		return len;
	}

	private int binarySearch(int[] tails, int len, int key) {
		int left = 0, right = len;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (tails[mid] == key) {
				return mid;
			} else if (tails[mid] > key) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}



	public List<List<Integer>> lengthOfLIS3(int[] nums) {
		List<List<Integer>> resList = new ArrayList<>();
		int n = nums.length;
		if (n == 0) return null;

		int maxLength = 1;
		int[] dp = new int[n];
		// 初始化dp
		Arrays.fill(dp, 1);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			// 每次更新最大的值
			maxLength = Math.max(maxLength, dp[i]);
		}

		// 记录一下有几个最长上升子序列及其位置
		List<Integer> lisIndex = new ArrayList<>();
		// 寻找所有最大上升子序列的结束位置
		for (int i = 0; i < n; i++) {
			if (dp[i] == maxLength) {
				lisIndex.add(i);
			}
		}

		for (int lastIndex : lisIndex) {
			ArrayList<Integer> list = new ArrayList<>();
			int nowMemoCount = dp[lastIndex];
			for (int i = lastIndex; i >= 0; i--) {
				if (nowMemoCount - dp[i] == 1 || nowMemoCount - dp[i] == 0) {
					list.add(nums[i]);
					nowMemoCount--;
				}
			}
			// 由于是从后往前加的结果，需要转换结果
			Collections.reverse(list);
			resList.add(list);
		}
		return resList;
	}

}
