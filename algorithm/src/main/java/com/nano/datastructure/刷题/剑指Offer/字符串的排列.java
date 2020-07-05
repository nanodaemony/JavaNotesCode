package com.nano.datastructure.刷题.剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: nano
 * @time: 2020/7/2 15:22
 */
public class 字符串的排列 {

	private ArrayList<String> resList = new ArrayList<>();

	public ArrayList<String> Permutation(String str) {
		// Base case
		if (str.length() == 0) return resList;
		// 得到所有的字符数组
		char[] chars = str.toCharArray();
		// 排个序
		Arrays.sort(chars);
		// 回溯得到结果 初始化一个Boolean数组用于标记是否已经遍历过
		backtracking(chars, new boolean[chars.length], new StringBuilder());
		return resList;
	}

	// 回溯法找答案
	private void backtracking(char[] chars, boolean[] hasUsed, StringBuilder s) {
		// Base case
		if (s.length() == chars.length) {
			// 这时候刚好全部涵盖
			resList.add(s.toString());
			return;
		}
		// 以每个字符为开头进行回溯
		for (int i = 0; i < chars.length; i++) {
			// 如果该索引位置已经使用就继续
			if (hasUsed[i]) continue;
			/* 保证不重复 */
			if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) continue;
			// 记录这个位置已经访问
			hasUsed[i] = true;
			// 加入字符串末尾
			s.append(chars[i]);
			// 回溯
			backtracking(chars, hasUsed, s);
			// 这一步？？？
			s.deleteCharAt(s.length() - 1);
			// 清除标记
			hasUsed[i] = false;
		}
	}

}
