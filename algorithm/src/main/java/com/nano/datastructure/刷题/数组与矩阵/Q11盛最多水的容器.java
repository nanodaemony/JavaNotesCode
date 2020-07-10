package com.nano.datastructure.刷题.数组与矩阵;

/**
 * @author: nano
 * @time: 2020/7/7 15:27
 */
public class Q11盛最多水的容器 {

	public int maxArea(int[] height) {
		// 记录遇到的最大面积值
		int maxArea = 0;
		// 双指针遍历数组，直到两个指针相遇
		for(int left = 0, right = height.length - 1; left < right;) {
			// 计算当前两个指针下的面积
			int area = (right - left) * Math.min(height[left], height[right]);
			// 更新最大值
			maxArea = Math.max(maxArea, area);
			// 根据高度判断该移动哪个指针--每次移动高度较低的的指针
			if(height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxArea;
	}

}
