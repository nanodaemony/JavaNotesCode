package com.nano.datastructure.面试.栈与队列;

import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/8/25 21:59
 */
public class 最长有效括号 {

	public int longestValidParentheses(String s) {
		int res = 0;
		Stack<Integer> stack = new Stack<>();
		// 初始压入-1
		stack.push(-1);
		// 遍历每个字符
		for (int i = 0; i < s.length(); i++) {
			// 遇到(就将对应的索引压栈
			if (s.charAt(i) == '(') {
				stack.push(i);
				// 遇到)就弹栈,但是需要分栈是否空两种情况
			} else {
				stack.pop();
				// 如果此时栈为空
				if (stack.empty()) {
					// 就将当前索引压栈
					stack.push(i);
				} else {
					// 否则当前索引减去弹栈之后的栈顶索引更新最大值
					res = Math.max(res, i - stack.peek());
				}
			}
		}
		return res;
	}



}
