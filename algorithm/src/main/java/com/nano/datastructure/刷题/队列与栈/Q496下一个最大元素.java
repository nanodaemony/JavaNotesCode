package com.nano.datastructure.刷题.队列与栈;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/7/16 16:25
 */
public class Q496下一个最大元素 {


	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Stack<Integer> stack = new Stack<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] res = new int[nums1.length];
		for (int i = 0; i < nums2.length; i++) {
			//
			while (!stack.empty() && nums2[i] > stack.peek())
				map.put(stack.pop(), nums2[i]);
			stack.push(nums2[i]);
		}
		while (!stack.empty())
			map.put(stack.pop(), -1);
		for (int i = 0; i < nums1.length; i++) {
			res[i] = map.get(nums1[i]);
		}
		return res;
	}


}
