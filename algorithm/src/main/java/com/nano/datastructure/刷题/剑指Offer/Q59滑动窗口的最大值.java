package com.nano.datastructure.刷题.剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author: nano
 * @time: 2020/7/4 13:58
 */
public class Q59滑动窗口的最大值 {

	/**
	 * 基于堆实现
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length == 0 || k < 1) {
			return new int[]{};
		}

		ArrayList<Integer> resList = new ArrayList<>();
		// 大顶堆
		PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
		// 先将K个元素加入堆中
		for (int i = 0; i < k; i++)
			heap.add(nums[i]);
		// 此时第一个元素就是当前最大值
		resList.add(heap.peek());
		// 维护一个大小为size的大顶堆
		for (int i = 0, j = i + k; j < nums.length; i++, j++) {
			// 不断取出窗口的左边界并加入右边界
			heap.remove(nums[i]);
			heap.add(nums[j]);
			// 每次滑动一个都得到一个值
			resList.add(heap.peek());
		}
		// 列表转为数组
		int[] res = new int[resList.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = resList.get(i);
		}
		return  res;
	}


	/**
	 * 基于单调队列实现
	 */
	public int[] maxSlidingWindow2(int[] nums, int k) {
		// Base case
 		if (nums == null || k < 1 || nums.length < k) {
			return new int[0];
		}

		int index = 0;
 		// 构造一个结果数组
		int[] res = new int[nums.length - k + 1];
		// 单调队列
		LinkedList<Integer> queue = new LinkedList<>();

		for (int i = 0; i < nums.length; i++) {
			// 在队列不为空的情况下，如果队列尾部的元素要比当前的元素小，或等于当前的元素
			// 那么为了维持从大到小的原则，必须让尾部元素弹出
			while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
				queue.pollLast();
			}
			// 不走while的话，说明正常在队列尾部添加元素
			queue.addLast(i);
			// 如果滑动窗口已经略过了队列中头部的元素，则将头部元素弹出
			if (queue.peekFirst() == (i - k)) {
				queue.pollFirst();
			}
			// 看看窗口有没有形成，只有形成了大小为k的窗口才能收集窗口内的最大值
			if (i >= (k - 1)) {
				res[index++] = nums[queue.peekFirst()];
			}
		}
		return res;
	}



}
