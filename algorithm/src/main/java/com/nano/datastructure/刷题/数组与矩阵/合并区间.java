package com.nano.datastructure.刷题.数组与矩阵;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode56
 * https://leetcode-cn.com/problems/merge-intervals/solution/chi-jing-ran-yi-yan-miao-dong-by-sweetiee/
 *
 * @author: nano
 * @time: 2020/8/13 10:40
 */
public class 合并区间 {


	public int[][] merge(int[][] arr) {
		// 按照第一个排序
		Arrays.parallelSort(arr, (x, y) -> x[0] - y[0]);

		LinkedList<int[]> tempList = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			// 集合为空，或不满足条件，直接加入当前的区间
			if (tempList.size() == 0 || tempList.getLast()[1] < arr[i][0]) {
				tempList.add(arr[i]);
				// 满足条件，集合最后元素的end=最大值
			} else {
				tempList.getLast()[1] = Math.max(tempList.getLast()[1], arr[i][1]);
			}
		}
		// 后面是将列表转换为数组输出
		int[][] res = new int[tempList.size()][2];
		int index = 0;
		// 遍历集合
		for (int i = 0; i < tempList.size(); i++) {
			res[index] = tempList.get(i);
			index++;
		}
		return res;
	}


	public static int squareNotEqual(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		if (nums.length == 1) return 1;
		// 将所有负数转正
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Math.abs(nums[i]);
		}
		int i = 0, j = nums.length - 1;
		// 上一个数据,初始化为第一个数的绝对值
		int lastBig = Math.abs(nums[0]);
		int res = 0;

		while (i <= j) {

			if(nums[i] > nums[j]) {
				if(lastBig != nums[i]) {
					res++;
					lastBig = nums[i];
				}
				i++;
			} else {
				if(lastBig != nums[j]) {
					res++;
					lastBig = nums[j];
				}
				j--;
			}
		}
		return res;
	}


	public static void main(String[] args) {

		System.out.println(squareNotEqual(new int[]{-1, -1, 1, 1}));
	}

}
