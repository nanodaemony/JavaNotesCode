package com.nano.datastructure.面试.搜索与回溯题目;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/28 12:20
 */
public class 相加之和的组合总数III {

	List<List<Integer>> resList = new ArrayList<>();
	// 记录一次路径
	Deque<Integer> path = new LinkedList<>();

	public List<List<Integer>> combinationSum3(int k, int n) {
		process(1, 0, n, k);
		return resList;
	}

	private void process(int start, int level, int target, int k) {
		if (target < 0) return;
		// 这里总和已经达到了n,而且总和个数满足了k个情况
		if (target == 0 && level == k) {
			resList.add(new ArrayList<>(path));
			return;
		}
		// 从1到9挨着遍历
		for (int i = start; i <= 9; i++) {
			// 选择i
			path.add(i);
			// 递归
			process(i + 1, level + 1, target - i, k);
			// 撤消选择i,进行回溯
			path.removeLast();
		}
	}
}
