package com.nano.datastructure.面试.搜索与回溯题目;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/28 0:14
 */
public class 零钱兑换的方法数 {


	private List<List<Integer>> resList = new ArrayList<>();

	public int change(int target, int[] coins) {

		Deque<Integer> path = new LinkedList<>();

		backtrack(path, 0, target, coins);
		return resList.size();
	}

	private void backtrack(Deque<Integer> path, int start, int target, final int[] coins) {
		// 目标数达到,加入路径中
		if (target == 0) {
			// 新建一个加入结果集
			resList.add(new ArrayList<>(path));
			return;
		}
		// 从开始处递归回溯
		for (int i = start; i < coins.length; i++) {
			// 剪枝
			if (coins[i] > target) continue;
			// 加入路径
			path.add(coins[i]);
			// 分别以i为开始进行回溯
			backtrack(path, i, target - coins[i], coins);
			// 删除元素撤消选择
			path.removeLast();
		}
	}


}
