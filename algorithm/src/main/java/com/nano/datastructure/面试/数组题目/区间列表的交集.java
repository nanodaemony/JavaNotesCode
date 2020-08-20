package com.nano.datastructure.面试.数组题目;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/20 14:05
 */
public class 区间列表的交集 {

	public int[][] intervalIntersection(int[][] A, int[][] B) {
		List<int[]> ans = new ArrayList();
		int i = 0, j = 0;

		while (i < A.length && j < B.length) {
			// low:区间的起点
			// high:区间的终点
			int low = Math.max(A[i][0], B[j][0]);
			int high = Math.min(A[i][1], B[j][1]);
			// 说明找到一个交集部分
			if (low <= high)
				ans.add(new int[]{low, high});
			// 移动当前较小的那个区间
			if (A[i][1] < B[j][1]) {
				i++;
			} else {
				j++;
			}
		}
		return ans.toArray(new int[ans.size()][]);
	}



}
