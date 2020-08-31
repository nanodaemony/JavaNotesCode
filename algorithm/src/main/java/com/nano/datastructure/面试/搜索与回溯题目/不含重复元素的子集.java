package com.nano.datastructure.面试.搜索与回溯题目;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/24 20:36
 */
public class 不含重复元素的子集 {

	private List<List<Integer>> resList = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {

		Deque<Integer> path = new LinkedList<>();
		backtrack(0, nums, path);
		return resList;
	}

	private void backtrack(int start, int[] nums, Deque<Integer> tempList) {
		// 所有路径都重新生成并加入结果集
		resList.add(new ArrayList<>(tempList));
		// 回溯
		for (int i = start; i < nums.length; i++) {
			// 加入当前的选择
			tempList.add(nums[i]);
			backtrack(i + 1, nums, tempList);
			// 撤消当前选择
			tempList.removeLast();
		}
	}


}
