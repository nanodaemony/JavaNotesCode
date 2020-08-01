package com.nano.datastructure.刷题.字符串;

/**
 * @author: nano
 * @time: 2020/7/17 13:03
 */
public class Q520检测大写字母 {

	public boolean detectCapitalUse(String word) {
		if(word == null) return false;
		int counter = 0;
		// 记录大写字母的个数即可
		for(int i = 0; i < word.length(); i++) {
			if(isUpperLetter(word.charAt(i))) counter++;
		}
		// 全为小写
		if(counter == 0) return true;
		// 全为大写
		if(counter == word.length()) return true;
		// 一个大写且为首字母大写
		if(counter == 1 && isUpperLetter(word.charAt(0))) return true;
		return false;
	}

	private boolean isUpperLetter(char c) {
		return c >= 'A' && c <= 'Z';
	}
}

