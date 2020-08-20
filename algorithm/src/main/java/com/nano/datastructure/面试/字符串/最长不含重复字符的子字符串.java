package com.nano.datastructure.面试.字符串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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


	/**
	 * 滑动窗口法
	 */
	public int lengthOfLongestSubstring2(String str) {
		// Set记录每个字符是否出现过
		Set<Character> set = new HashSet<Character>();
		int len = str.length();
		// 右指针初始值为-1，相当于在字符串的左边界的左侧，还没有开始移动
		int right = -1, res = 0;

		for (int i = 0; i < len; i++) {
			// 左指针向右移动一格，移除一个字符
			if (i != 0) {
				set.remove(str.charAt(i - 1));
			}
			// 不断地移动右指针
			while (right + 1 < len && !set.contains(str.charAt(right + 1))) {
				set.add(str.charAt(right + 1));
				right++;
			}
			// 更新记录,第i到right个字符是一个极长的无重复字符子串
			res = Math.max(res, right - i + 1);
		}
		return res;
	}

}
