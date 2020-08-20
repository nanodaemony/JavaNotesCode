package com.nano.datastructure.面试.数组题目;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/20 15:21
 */
public class 相加之和的组合总数 {

	List<List<Integer>> resList = new ArrayList<>();
	// 记录一次路径
	List<Integer> pathList = new ArrayList<>();
	public List<List<Integer>> combinationSum3(int k, int n) {
		process(1, 0, n, k);
		return resList;
	}

	private void process(int start, int level, int target, int k) {
		if (target < 0) return;
		// 这里总和已经达到了n,而且总和个数满足了k个情况
		if (target == 0 && level == k) {
			resList.add(new ArrayList<>(pathList));
			return;
		}
		// 从1到9挨着遍历
		for (int i = start; i <= 9; i++) {
			// 选择i
			pathList.add(i);
			// 递归
			process(i + 1, level + 1, target - i, k);
			// 撤消选择i,进行回溯
			pathList.remove(pathList.size() - 1);
		}
	}

}
