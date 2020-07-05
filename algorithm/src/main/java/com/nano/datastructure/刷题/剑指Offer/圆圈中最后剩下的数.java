package com.nano.datastructure.刷题.剑指Offer;

import java.util.ArrayList;

/**
 * @author: nano
 * @time: 2020/7/4 14:53
 */
public class 圆圈中最后剩下的数 {

	/**
	 * 使用模拟链表法
	 */
	public int lastRemaining(int n, int m) {
		// 构造一个链表
		ArrayList<Integer> list = new ArrayList<>();
		// 将数字加到链表中
		for (int i = 0; i < n; i++) list.add(i);

		int index = 0;
		// 不断移除一个元素直到只剩下一个元素
		while (list.size() > 1) {
			// index +=m-1;
			// while(index>list.size()-1) index = index-list.size();
			// 上面两步等价于下面
			// 用需要报的数对当前链表长度取模
			index = (index + m - 1) % list.size();
			// 去掉这个位置的元素
			list.remove(index);
		}
		return list.get(0);
	}

}
