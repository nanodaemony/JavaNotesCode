package com.nano.datastructure.面试.数组题目;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: nano
 * @time: 2020/8/18 19:25
 */
public class 区间调度 {


	public int intervalSchedule(int[][] intervals) {
		if (intervals.length == 0) return 0;
		// 按end升序排序
		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[1] - b[1];
			}
		});
		// 至少有一个区间不相交
		int count = 1;
		// 排序后第一个区间就是x
		int xEnd = intervals[0][1];
		for (int[] interval : intervals) {
			int start = interval[0];
			if (start >= xEnd) {
				// 找到下一个选择的区间了
				count++;
				xEnd = interval[1];
			}
		}
		return count;
	}
}
