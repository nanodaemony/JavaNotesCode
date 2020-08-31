package com.nano.datastructure.面试.搜索与回溯题目;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/28 12:27
 */
public class 含重复元素求子集 {


	private List<List<Integer>> resList = new ArrayList<>();

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		// 先排个序
		Arrays.sort(nums);
		Deque<Integer> path = new LinkedList<>();
		boolean[] hasVisited = new boolean[nums.length];
		// 考虑不同的子集大小
		for (int size = 0; size <= nums.length; size++) {
			backtrack(0, path, hasVisited, size, nums);
		}
		return resList;
	}

	private void backtrack(int start, Deque<Integer> path, boolean[] hasVisited, final int size, final int[] nums) {
		// 大小合格
		if (path.size() == size) {
			resList.add(new ArrayList<>(path));
			return;
		}
		for (int i = start; i < nums.length; i++) {
			// 含重复元素的统一剪枝方法
			if (i != 0 && nums[i] == nums[i - 1] && !hasVisited[i - 1]) {
				continue;
			}
			path.add(nums[i]);
			hasVisited[i] = true;
			backtrack(i + 1, path, hasVisited, size, nums);
			hasVisited[i] = false;
			path.removeLast();
		}
	}

}
