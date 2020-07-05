package com.nano.datastructure.刷题.剑指Offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: nano
 * @time: 2020/7/2 16:26
 */
public class 数据流中的中位数 {

	/* 大顶堆，存储左半边元素 */
	private PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Comparator.reverseOrder());
	/* 小顶堆，存储右半边元素，并且右半边元素都大于左半边 */
	private PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
	// 当前数据流读入的元素个数
	private int counter = 0;

	public void Insert(Integer val) {
		// 插入要保证两个堆处于平衡状态
		if (counter % 2 == 0) {
			/* N为偶数的情况下插入到右半边。
			 * 因为右半边元素都要大于左半边，但是新插入的元素不一定比左半边元素来的大，
			 * 因此需要先将元素插入左半边，然后利用左半边为大顶堆的特点，取出堆顶元素即为最大元素，此时插入右半边 */
			leftHeap.add(val);
			int max = leftHeap.poll();
			rightHeap.add(max);
		} else {
			rightHeap.add(val);
			int min = rightHeap.poll();
			leftHeap.add(min);
		}
		counter++;
	}

	public Double GetMedian() {
		if (counter % 2 == 0)
			return (leftHeap.peek() + rightHeap.peek()) / 2.0;
		else
			return (double) rightHeap.peek();
	}

}
