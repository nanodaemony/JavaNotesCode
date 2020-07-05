package com.nano.datastructure.刷题.剑指Offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: nano
 * @time: 2020/7/3 19:00
 */
public class 第一个只出现一次的字符位置 {

	public char firstUniqChar(String s) {

		Map<Character, Integer> map = new LinkedHashMap<>();
		char[] chars = s.toCharArray();
		for(char c : chars) {

			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		for (Map.Entry entry : map.entrySet()) {

			if ((Integer)entry.getValue() == 1) {
				return (char)entry.getKey();
			}
		}

		return ' ';
	}

}
