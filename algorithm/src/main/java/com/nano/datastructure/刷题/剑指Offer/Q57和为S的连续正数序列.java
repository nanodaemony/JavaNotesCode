package com.nano.datastructure.刷题.剑指Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/6 14:43
 */
public class Q57和为S的连续正数序列 {

	public int[][] findContinuousSequence(int target) {
		int i = 1; // 滑动窗口的左边界
		int j = 1; // 滑动窗口的右边界
		int sum = 0; // 滑动窗口中数字的和
		List<int[]> res = new ArrayList<>();
		// 左边界大于目标的一半就可直接退出
		while (i <= target / 2) {
			// 右边界向右移动
			if (sum < target) {
				sum = sum + j;
				j++;
			// 左边界向右移动
			} else if (sum > target) {
				sum = sum - i;
				i++;
				// 刚好和为target
			} else {
				// 记录结果
				int[] arr = new int[j - i];
				for (int k = i; k < j; k++) {
					arr[k - i] = k;
				}
				res.add(arr);
				// 左边界向右移动
				sum = sum - i;
				i++;
			}
		}
		return res.toArray(new int[res.size()][]);
	}


}
