package com.nano.datastructure.刷题.剑指Offer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: nano
 * @time: 2020/7/2 16:26
 */
public class Q41数据流中的中位数 {
	// 小顶堆，保存较大的一半
	Queue<Integer> left = new PriorityQueue<>();
	// 大顶堆，保存较小的一半
	Queue<Integer> right = new PriorityQueue<>((x, y) -> (y - x));

	// 当前数据流读入的元素个数
	private int counter = 0;

	public Q41数据流中的中位数() {

	}

	public void addNum(int num) {
		if (counter % 2 == 0) {
			left.add(num);
			int max = left.poll();
			right.add(max);
		} else {
			right.add(num);
			int min = right.poll();
			left.add(min);
		}
		counter++;
	}
	public double findMedian() {
		if (counter % 2 == 0)
			return (left.peek() + right.peek()) / 2.0;
		else
			return (double) right.peek();
	}


}
