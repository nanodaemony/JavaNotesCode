package com.nano.datastructure.面试.搜索与回溯题目;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/25 12:53
 */
public class 电话号码的字母组合 {

	private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	private List<String> resList = new ArrayList<>();

	public List<String> letterCombinations(String digits) {
		// Base case
		if (digits == null || digits.length() == 0) return resList;

		StringBuilder path = new StringBuilder();
		// 回溯找答案
		backtrack(path, digits);
		return resList;
	}
	// 比如 digits = "23",则最终结果长度为2
	private void backtrack(StringBuilder path, final String digits) {
		// 长度一致则说明找到
		if (path.length() == digits.length()) {
			resList.add(path.toString());
			return;
		}
		// 当前的数字
		int curDigits = digits.charAt(path.length()) - '0';
		// 通过当前为找到数字对应的一串字母
		String letters = KEYS[curDigits];
		// 遍历每一位字母
		for (char c : letters.toCharArray()) {
			path.append(c);  // 添加字符
			backtrack(path, digits);
			// 删除字符
			path.deleteCharAt(path.length() - 1);
		}
	}


}
