package com.nano.datastructure.面试.搜索与回溯题目;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/16 17:35
 */
public class 全排列重复元素 {




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

			if(!isDuplicate(nums, start, i)) continue;
			// 交换一个字符
			swap(nums, start, i);
			permutation(nums, start + 1);
			// 回溯原来的状态
			swap(nums, start, i);
		}
	}

	// 判断[begin, end)区间内是否有字符与end相等
	private static boolean isDuplicate(char[] nums, int begin, int end) {
		for (int i = begin; i < end; i++) {
			if(nums[i] == nums[end]) {
				return false;
			}
		}
		return true;
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


	private List<List<Integer>> permutes = new ArrayList<>();

	public List<List<Integer>> permuteUnique(int[] nums) {
		Deque<Integer> pathList = new LinkedList<>();
		// 先排序
		Arrays.sort(nums);
		// 记录是否已经访问过
		boolean[] hasVisited = new boolean[nums.length];
		backtrack(pathList, hasVisited, nums);
		return permutes;
	}

	private void backtrack(Deque<Integer> pathList, boolean[] visited, final int[] nums) {
		// 长度足够
		if (pathList.size() == nums.length) {
			permutes.add(new ArrayList<>(pathList));
			return;
		}

		for (int i = 0; i < visited.length; i++) {
			// 防止重复,剪枝
			if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
				continue;
			}
			// 剪枝
			if (visited[i]){
				continue;
			}
			// 标记为已经访问
			visited[i] = true;
			pathList.add(nums[i]);
			backtrack(pathList, visited, nums);
			// 撤消选择
			pathList.removeLast();
			visited[i] = false;
		}
	}


}
