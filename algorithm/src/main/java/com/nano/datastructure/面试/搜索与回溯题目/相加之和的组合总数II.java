package com.nano.datastructure.面试.搜索与回溯题目;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/28 12:12
 */
public class 相加之和的组合总数II {

	private List<List<Integer>> resList = new ArrayList<>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		// 先排个序
		Arrays.sort(candidates);
		// 路径队列
		Deque<Integer> path = new LinkedList<>();
		// 记录是否已经访问过
		boolean[] visited = new boolean[candidates.length];
		backtrack(path, visited, 0, target, candidates);
		return resList;
	}

	private void backtrack(Deque<Integer> path, boolean[] hasVisited, int start, int target, final int[] candidates) {
		// 目标为0则成功
		if (target == 0) {
			// 注意需要生成一个新的列表存起来
			resList.add(new ArrayList<>(path));
			return;
		}
		// 从start开始递归
		for (int i = start; i < candidates.length; i++) {
			// 剪枝
			if (i != 0 && candidates[i] == candidates[i - 1] && !hasVisited[i - 1]) {
				continue;
			}
			if (candidates[i] <= target) {
				path.add(candidates[i]);
				hasVisited[i] = true;
				backtrack(path, hasVisited, i + 1, target - candidates[i], candidates);
				hasVisited[i] = false;
				path.removeLast();
			}
		}
	}

}
