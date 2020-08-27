package com.nano.datastructure.面试.搜索与回溯题目;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/24 20:36
 */
public class 子集 {

	private List<List<Integer>> resList = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {
		backtrack(0, nums, new ArrayList<>());
		return resList;
	}


	private void backtrack(int i, int[] nums, ArrayList<Integer> tempList) {
		// 所有路径都加入结果集
		resList.add(new ArrayList<>(tempList));
		// 回溯
		for (int j = i; j < nums.length; j++) {
			// 加入当前的选择
			tempList.add(nums[j]);
			backtrack(j + 1, nums, tempList);
			// 撤消当前选择
			tempList.remove(tempList.size() - 1);
		}
	}


}
