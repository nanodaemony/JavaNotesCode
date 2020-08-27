package com.nano.datastructure.面试.双指针题目;

import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/26 17:31
 */
public class 最长子序列 {


	public String findLongestWord(String s, List<String> dic) {
		String res = "";
		for (int i = 0; i < dic.size(); i++) {
			String temp = dic.get(i);
			// 如果当前字符串比已经找到的字符串长度以及字典序较小则直接不管了
			if(temp.length() < res.length()) continue;
			if(temp.length() == res.length() && res.compareTo(temp) < 0) continue;
			// 判断一个字符串是否是给定字符串的子序列
			if (isSubStr(s, temp)) {
				res = temp;
			}
		}
		return res;
	}

	private boolean isSubStr(String str, String target) {
		int i = 0, j = 0;
		while (i < str.length() && j < target.length()) {
			if (str.charAt(i) == target.charAt(j)) {
				j++;
			}
			i++;
		}
		return j == target.length();
	}

}
