package com.nano.datastructure.面试.栈与队列;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/9/12 21:54
 */
public class 循环数组中下一个更大的数字 {


	public int[] nextGreaterElements(int[] nums) {
		int len = nums.length;
		int[] next = new int[len];
		// 全部置为-1
		Arrays.fill(next, -1);

		Stack<Integer> preStack = new Stack<>();
		for (int i = 0; i < len * 2; i++) {
			int num = nums[i % len];
			while (!preStack.isEmpty() && nums[preStack.peek()] < num) {
				next[preStack.pop()] = num;
			}
			if (i < len) {
				preStack.push(i);
			}
		}
		return next;
	}


}
