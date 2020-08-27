package com.nano.datastructure.面试.区间类题目;

import java.util.Arrays;

/**
 * @author: nano
 * @time: 2020/8/26 21:35
 */
public class 用最少数量的箭引爆气球 {

	public int findMinArrowShots(int[][] points) {
		if (points.length <= 1) return 0;
		// 按照区间结尾排序
		Arrays.sort(points, ((o1, o2) -> o1[1] - o2[1]));

		int cnt = 1;
		// 记录第一个区间的结尾
		int end = points[0][1];
		for (int i = 1; i < points.length; i++) {
			// 边界重合算重叠
			if (points[i][0] <= end) {
				continue;
			}
			cnt++;
			end = points[i][1];
		}
		return cnt;
	}

}
