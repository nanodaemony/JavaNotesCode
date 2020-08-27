package com.nano.datastructure.面试.其他;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author: nano
 * @time: 2020/8/26 19:54
 */
public class 按照字符出现次数对字符串排序 {

	public String frequencySort(String str) {
		Map<Character, Integer> freqNum = new HashMap<>();
		for (char c : str.toCharArray()) {
			freqNum.put(c, freqNum.getOrDefault(c, 0) + 1);
		}
		// 根据字符串构造桶
		List<Character>[] bucket = new ArrayList[str.length() + 1];
		// 数据放入桶中
		for (char c : freqNum.keySet()) {
			int cnt = freqNum.get(c);
			if (bucket[cnt] == null) {
				bucket[cnt] = new ArrayList<>();
			}
			bucket[cnt].add(c);
		}
		// 记录最后结果
		StringBuilder builder = new StringBuilder();
		// 从右往左进行添加
		for (int i = bucket.length - 1; i >= 0; i--) {
			if (bucket[i] == null) continue;
			for (char c : bucket[i]) {
				for (int j = 0; j < i; j++) {
					builder.append(c);
				}
			}
		}
		return builder.toString();
	}

}
