package com.nano.datastructure.刷题.剑指Offer;

import java.util.Arrays;

/**
 * @author: nano
 * @time: 2020/7/3 14:18
 */
public class Q45把数组排成最小的数 {

	public String minNumber(int[] numbers) {
		// Base case
		if (numbers == null || numbers.length == 0) return "";
		int n = numbers.length;
		// 将数字转换为字符串
		String[] nums = new String[n];
		for (int i = 0; i < n; i++)
			nums[i] = numbers[i] + "";
		// 排序
		Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
		StringBuilder res = new StringBuilder();
		for (String str : nums)
			res.append(str);
		return res.toString();
	}

}
