package com.nano.datastructure.刷题.动态规划;

/**
 * @author: nano
 * @time: 2020/8/13 10:29
 */
public class 接雨水 {

	public int trap(int[] height) {
		int sum = 0;
		// 最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
		for (int i = 1; i < height.length - 1; i++) {
			int leftMax = 0;
			// 找出左边最高
			for (int j = i - 1; j >= 0; j--) {
				if (height[j] > leftMax) {
					leftMax = height[j];
				}
			}
			int rightMax = 0;
			// 找出右边最高
			for (int j = i + 1; j < height.length; j++) {
				if (height[j] > rightMax) {
					rightMax = height[j];
				}
			}
			// 找出两端较小的
			int min = Math.min(leftMax, rightMax);
			// 只有较小的一段大于当前列的高度才会有水，其他情况不会有水
			if (min > height[i]) {
				sum = sum + (min - height[i]);
			}
		}
		return sum;
	}


	public int trap2(int[] height) {
		int sum = 0;
		int[] leftMax = new int[height.length];
		int[] rightMax = new int[height.length];

		for (int i = 1; i < height.length - 1; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
		}
		for (int i = height.length - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
		}
		for (int i = 1; i < height.length - 1; i++) {
			int min = Math.min(leftMax[i], rightMax[i]);
			if (min > height[i]) {
				sum = sum + (min - height[i]);
			}
		}
		return sum;
	}


}
