package com.nano.datastructure.面试.滑动窗口题目;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/14 14:38
 */
public class 和为S的连续正整数序列 {


	public int[][] findContinuousSequence(int target) {
		// 窗口仅含1
		int i = 1;
		int j = 1;
		int sum = 0;
		List<int[]> resList = new ArrayList<>();
		// 序列是由小到大排列，所以如果i>target/2，那么i+i+1肯定大于target
		while (i <= target / 2) {
			// 如果小于目标值就移动右边界同时加上右边界值
			if (sum < target) {
				sum = sum + j;
				j++;
				// 大于目标值就移动左边界同时减去左边界值
			} else if (sum > target) {
				sum = sum - i;
				i++;
				// 相等的值出现了就记录到结果列表中
			} else {
				int[] temp = new int[j - i];
				for (int m = i; m < j; m++) temp[m - i] = m;
				resList.add(temp);
				// 在这里左边界向右移动
				sum = sum - i;
				i++;
			}
		}
		return resList.toArray(new int[resList.size()][]);
	}

}
