package com.nano.datastructure.面试.区间类题目;

import java.util.Arrays;

/**
 * @author: nano
 * @time: 2020/8/26 21:28
 */
public class 不重叠的区间个数 {

	public int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length <= 1) return 0;
		// 按照区间结尾排序
		Arrays.sort(intervals, ((o1, o2) -> o1[1] - o2[1]));
		int cnt = 1;
		// 当前区间的结尾
		int end = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			// 边界不算重叠
			if (intervals[i][0] < end) {
				continue;
			}
			// 更新结尾
			end = intervals[i][1];
			cnt++;
		}
		return intervals.length - cnt;
	}

}
