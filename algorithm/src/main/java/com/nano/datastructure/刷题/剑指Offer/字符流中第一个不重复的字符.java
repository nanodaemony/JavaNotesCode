package com.nano.datastructure.刷题.剑指Offer;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author: nano
 * @time: 2020/7/2 16:39
 */
public class 字符流中第一个不重复的字符 {

	// 存放字符的数组
	private int[] cnts = new int[256];

	private Queue<Character> queue = new LinkedList<>();

	public void Insert(char ch) {
		// 这个字符对应位置的计数器++
		cnts[ch]++;
		// 字符加入Queue中
		queue.add(ch);
		// 队列不为空且这个字符对应的个数大于1
		while (!queue.isEmpty() && cnts[queue.peek()] > 1) {
			// 弹出队头元素
			queue.poll();
		}
	}

	public char FirstAppearingOnce() {
		return queue.isEmpty() ? '#' : queue.peek();
	}




	public char FirstAppearingOnce2() {
		// 遍历发现第一个只出现一次的字符
		for (Map.Entry entry : countMap.entrySet()) {
			if ((Integer) entry.getValue() == 1) {
				return (char)entry.getKey();
			}
		}
		// 没找到
		return '#';
	}

	private Map<Character, Integer> countMap = new LinkedHashMap();


	public void Insert1(char ch) {
		// 如果已经有则计数器++
		if(countMap.containsKey(ch)) {
			countMap.put(ch, countMap.get(ch) + 1);
		} else {
			countMap.put(ch, 1);
		}
	}

}
