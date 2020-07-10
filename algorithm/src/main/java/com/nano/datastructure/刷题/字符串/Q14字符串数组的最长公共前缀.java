package com.nano.datastructure.刷题.字符串;

import java.util.Arrays;

/**
 * @author: nano
 * @time: 2020/7/8 20:25
 */
public class Q14字符串数组的最长公共前缀 {

	public String longestCommonPrefix(String[] strs) {
		// Base case
		if (strs.length == 0) return "";
		String res = strs[0];
		for (int i = 1; i < strs.length; i++) {
			int j = 0;
			// 依次对比
			for (; j < res.length() && j < strs[i].length(); j++) {
				// 遇到不相等的情况
				if (res.charAt(j) != strs[i].charAt(j)) break;
			}
			res = res.substring(0, j);
			if ("".equals(res)) return res;
		}
		return res;
	}


}
