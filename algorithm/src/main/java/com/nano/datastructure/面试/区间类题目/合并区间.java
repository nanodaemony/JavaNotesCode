package com.nano.datastructure.面试.区间类题目;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/14 22:25
 */
public class 合并区间 {

	public int[][] merge(int[][] intervals) {
		int len = intervals.length;
		if (len < 2) return intervals;

		// 按照起点排序
		Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));

		// 也可以使用 Stack，因为我们只关心结果集的最后一个区间
		List<int[]> res = new ArrayList<>();
		res.add(intervals[0]);

		for (int i = 1; i < len; i++) {
			// 取出当前区间
			int[] temp = intervals[i];
			// 每次新的区间与当前结果集中的最后一个区间的末尾端点进行比较
			int[] peek = res.get(res.size() - 1);
			if (temp[0] <= peek[1]) {
				// 注意:这里应该取最大
				peek[1] = Math.max(temp[1], peek[1]);
			} else {
				// 说明两者完全不重叠
				res.add(temp);
			}
		}
		return res.toArray(new int[res.size()][]);
	}

}
