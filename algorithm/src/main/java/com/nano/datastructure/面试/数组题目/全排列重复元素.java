package com.nano.datastructure.面试.数组题目;

import java.util.ArrayList;
import java.util.Arrays;
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



}
