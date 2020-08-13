package com.nano.datastructure.刷题.搜索问题;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/12 16:44
 */
public class Q47全排列II {


	List<List<Integer>> res = new LinkedList<>();

	List<List<Integer>> permuteUnique(int[] nums) {
		// 使用一个列表来记录「路径」
		LinkedList<Integer> track = new LinkedList<>();
		backTrack(nums, track);
		return res;
	}

	// 路径:记录在track中
	// 选择列表:nums中不存在于track的那些元素
	// 结束条件:nums中的元素全都在track中出现
	public void backTrack(int[] nums, LinkedList<Integer> track) {
		// 触发结束条件
		if (track.size() == nums.length) {
			res.add(new LinkedList(track));
			return;
		}

		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {

			// 与无重复数字全排列的唯一不同之处
			if (set.contains(nums[i])) continue;
			set.add(nums[i]);

			// 排除不合法的选择
			if (track.contains(nums[i])) continue;
			// 做选择
			track.add(nums[i]);
			// 进入下一层决策树
			backTrack(nums, track);
			// 取消之前的选择
			track.removeLast();
		}
	}

}
