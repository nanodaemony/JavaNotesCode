package com.nano.datastructure.面试.数组题目;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: nano
 * @time: 2020/8/19 19:22
 */
public class 和至少为K的最短子数组 {

	public int shortestSubarray(int[] nums, int K) {
		int len = nums.length;
		long[] temp = new long[len + 1];
		for (int i = 0; i < len; i++) {
			temp[i + 1] = temp[i] + (long) nums[i];
		}
		int res = len + 1;
		Deque<Integer> monoQueue = new LinkedList();

		for (int y = 0; y < temp.length; ++y) {
			while (!monoQueue.isEmpty() && temp[y] <= temp[monoQueue.getLast()]) {
				monoQueue.removeLast();
			}
			while (!monoQueue.isEmpty() && temp[y] >= temp[monoQueue.getFirst()] + K) {
				res = Math.min(res, y - monoQueue.removeFirst());
			}
			monoQueue.addLast(y);
		}

		return res < len + 1 ? res : -1;
	}

}
