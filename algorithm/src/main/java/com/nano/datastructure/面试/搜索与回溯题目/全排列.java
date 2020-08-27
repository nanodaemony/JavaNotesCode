package com.nano.datastructure.面试.搜索与回溯题目;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/16 17:35
 */
public class 全排列 {

	List<List<Integer>> res = new LinkedList<>();

	List<List<Integer>> permute(int[] nums) {
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
		// 挨着递归
		for (int i = 0; i < nums.length; i++) {
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



	//---------------方法2----------------------

	private static List<String> resList = new ArrayList<>();

	public static void permutation(char[] nums, int start) {

		if(nums == null || start < 0) return;

		// 起始位置等于长度则成功
		if(start == nums.length) {
			resList.add(new String(nums));
			return;
		}
		// 从头开始固定字符
		for (int i = start; i < nums.length; i++) {
			// 交换一个字符
			swap(nums, start, i);
			permutation(nums, start + 1);
			// 回溯原来的状态
			swap(nums, start, i);
		}
	}


	private static void swap(char[] nums, int i, int j) {
		char temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}


	public static void main(String[] args) {
		String a = "aba";
		permutation(a.toCharArray(), 0);
		System.out.println(Arrays.deepToString(new List[]{resList}));

	}



}
