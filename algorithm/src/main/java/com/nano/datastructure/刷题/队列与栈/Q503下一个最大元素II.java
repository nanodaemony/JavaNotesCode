package com.nano.datastructure.刷题.队列与栈;

import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/7/16 16:43
 */
public class Q503下一个最大元素II {

	public int[] nextGreaterElements(int[] nums) {
		int[] res = new int[nums.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 2 * nums.length - 1; i >= 0; --i) {
			while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
				stack.pop();
			}
			res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
			stack.push(i % nums.length);
		}
		return res;
	}


}
