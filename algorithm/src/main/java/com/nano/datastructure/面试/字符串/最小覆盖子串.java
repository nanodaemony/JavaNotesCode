package com.nano.datastructure.面试.字符串;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: nano
 * @time: 2020/8/18 13:45
 */
public class 最小覆盖子串 {

	Map<Character, Integer> oriMap = new HashMap<>();
	Map<Character, Integer> cntMap = new HashMap<>();

	public String minWindow(String s, String t) {
		int tLen = t.length();
		// 把T字符串的全部内容放入到Map中计数
		for (int i = 0; i < tLen; i++) {
			char c = t.charAt(i);
			oriMap.put(c, oriMap.getOrDefault(c, 0) + 1);
		}
		// 窗口左右指针
		int left = 0, right = -1;
		int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
		int sLen = s.length();
		while (right < sLen) {
			right++;
			if (right < sLen && oriMap.containsKey(s.charAt(right))) {
				cntMap.put(s.charAt(right), cntMap.getOrDefault(s.charAt(right), 0) + 1);
			}
			while (check() && left <= right) {
				if (right - left + 1 < len) {
					len = right - left + 1;
					ansL = left;
					ansR = left + len;
				}
				if (oriMap.containsKey(s.charAt(left))) {
					cntMap.put(s.charAt(left), cntMap.getOrDefault(s.charAt(left), 0) - 1);
				}
				++left;
			}
		}
		return ansL == -1 ? "" : s.substring(ansL, ansR);
	}

	// 判断窗口内的字符是否完全包含T字符串的内容
	public boolean check() {
		Iterator iter = oriMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Character key = (Character) entry.getKey();
			Integer val = (Integer) entry.getValue();
			if (cntMap.getOrDefault(key, 0) < val) {
				return false;
			}
		}
		return true;
	}


}
