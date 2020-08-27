package com.nano.datastructure.面试.搜索与回溯题目;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/24 20:57
 */
public class 数组中和为N的组合数 {


	private List<List<Integer>> resList = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		int len = candidates.length;
		if (len == 0) return resList;

		// 注意!排序是剪枝的前提
		Arrays.sort(candidates);
		// 记录路径
		Deque<Integer> path = new ArrayDeque<>();
		backtrack(candidates, 0, len, target, path);
		return resList;
	}

	private void backtrack(int[] candidates, int begin, int len, int target, Deque<Integer> path) {
		// 由于进入更深层的时候,小于0的部分被剪枝,因此递归终止条件值只判断等于0的情况
		if (target == 0) {
			resList.add(new ArrayList<>(path));
			return;
		}

		for (int i = begin; i < len; i++) {
			// 重点理解这里剪枝,前提是候选数组已经有序,到这不用考虑更小的分支了
			if (target - candidates[i] < 0) {
				break;
			}

			path.addLast(candidates[i]);
			backtrack(candidates, i, len, target - candidates[i], path);
			path.removeLast();
		}
	}


}
