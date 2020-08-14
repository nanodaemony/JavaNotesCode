package com.nano.datastructure.面试.字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: nano
 * @time: 2020/8/14 22:08
 */
public class 最长不含重复字符的子字符串 {


	public int lengthOfLongestSubstring(String str) {
		// 记录字符位置的map,空间为O(1)
		Map<Character, Integer> dic = new HashMap<>();
		// 记录当前元素之前出现过的位置
		int lastShowIndex = -1;
		int res = 0;
		// 遍历字符串
		for (int i = 0; i < str.length(); i++) {
			// 如果字典中已经包含了这个字符,说明之前出现过
			if (dic.containsKey(str.charAt(i))) {
				// 记录当前元素之前出现过的位置
				lastShowIndex = Math.max(lastShowIndex, dic.get(str.charAt(i)));
			}
			// 不断更新哈希表记录
			dic.put(str.charAt(i), i);
			// 更新结果,如果i没有更新,那么temp
			res = Math.max(res, i - lastShowIndex);
		}
		return res;
	}


}
