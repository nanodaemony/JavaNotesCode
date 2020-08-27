package com.nano.datastructure.面试.栈与队列;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/8/23 14:01
 */
public class 移除K个数字使结果最小 {


	// 单调栈
	public String removeKdigits(String num, int k) {
		char[] chars = num.toCharArray();
		if (k >= chars.length) return "0";
		// 栈中记录的是索引指针
		Stack<Integer> stack = new Stack<>();
		int count = 0;
		for (int i = 0; i < chars.length; i++) {
			// 下一个元素如果小于栈顶元素就弹出栈顶元素
			while (!stack.isEmpty() && chars[stack.peek()] > chars[i]) {
				// count记录弹出几次
				if (count < k) {
					count++;
					stack.pop();
				} else {
					break;
				}
			}
			// 将当前索引加入栈中
			stack.push(i);
		}
		// 如果count==k说明stack栈内元素正好是num去掉k个的数字，如果count<k说明栈没有去掉k个数，所以继续弹出栈顶元素
		for (int i = count; i < k; i++) {
			stack.pop();
		}
		// 取出结果,取出时判断是否前面是0,如果是就不用这些数字
		StringBuilder resBuilder = new StringBuilder();
		// 判断是否遇到非0元素
		boolean leadingZero = true;
		for (int digit : stack) {
			// 去0的操作
			if (leadingZero && chars[digit] == '0') {
				continue;
			}
			leadingZero = false;
			resBuilder.append(chars[digit]);
		}
		if (resBuilder.length() == 0) return "0";
		return resBuilder.toString();
	}


}
