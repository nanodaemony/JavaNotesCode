package com.nano.datastructure.刷题.剑指Offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: nano
 * @time: 2020/7/3 16:02
 */
public class Q48最长不含重复字符的子字符串 {

	public int lengthOfLongestSubstring(String s) {
		// 存放结果
		int res = 0, tmp = 0;
		// 遍历一次
		for (int j = 0; j < s.length(); j++) {
			// 从j的前一个元素开始找
			int i = j - 1;
			// 线性查找,直到找到与j位置相同的索引i或者找到开始处
			while (i >= 0 && s.charAt(i) != s.charAt(j)) i--;
			// 滚动更新temp，dp[j - 1] -> dp[j]
			tmp = tmp < j - i ? tmp + 1 : j - i;
			// 更新res，max(dp[j - 1], dp[j])
			res = Math.max(res, tmp);
		}
		return res;
	}


	public int lengthOfLongestSubstring2(String s) {
		// 记录字符位置的map
		Map<Character, Integer> dic = new HashMap<>();
		// i表示当前索引的位置的前面一个相同元素的索引位置
		int i = -1, res = 0;
		// 遍历字符串
		for (int j = 0; j < s.length(); j++) {
			// 如果map已经存在这个元素，则更新不重复的最左指针i
			if (dic.containsKey(s.charAt(j)))
				i = Math.max(i, dic.get(s.charAt(j)));
			// 一直更新当前元素哈希表记录
			dic.put(s.charAt(j), j);
			// 滚动更新最大的结果
			res = Math.max(res, j - i);
		}
		return res;
	}
}
