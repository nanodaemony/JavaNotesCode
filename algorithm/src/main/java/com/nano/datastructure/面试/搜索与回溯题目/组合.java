package com.nano.datastructure.面试.搜索与回溯题目;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/27 22:34
 */
public class 组合 {

	private List<List<Integer>> resList = new ArrayList<>();

	public List<List<Integer>> combine(int n, int k) {
		Deque<Integer> combinePath = new LinkedList<>();
		backtrack(combinePath, 1, k, n);
		return resList;
	}

	private void backtrack(Deque<Integer> combinePath, int start, int k, final int n) {
		// 当K为0添加答案
		if (k == 0) {
			resList.add(new ArrayList<>(combinePath));
			return;
		}
		// 剪枝
		for (int i = start; i <= n - k + 1; i++) {
			combinePath.add(i);
			backtrack(combinePath, i + 1, k - 1, n);
			combinePath.removeLast();
		}
	}

}
