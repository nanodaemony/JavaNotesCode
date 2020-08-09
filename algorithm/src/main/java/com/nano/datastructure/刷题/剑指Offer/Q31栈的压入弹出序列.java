package com.nano.datastructure.刷题.剑指Offer;

import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/7/1 19:50
 */
public class Q31栈的压入弹出序列 {

	public boolean validateStackSequences(int[] push, int[] pop) {

		// 求长度
		int len = push.length;
		Stack<Integer> stack = new Stack<>();
		// 初始化压栈弹栈指针都为0
		int pushIndex = 0;
		int popIndex = 0;

		// 压入索引小于长度
		while (pushIndex < len) {
			// 尝试压入一个元素并移动压入指针
			stack.push(push[pushIndex]);
			pushIndex++;
			// 每次压入一个元素之后判断当前栈顶是不是跟当前的弹出序列匹配，是的话就持续弹出栈
			while (!stack.isEmpty() && pushIndex <= len && stack.peek() == pop[popIndex]) {
				stack.pop();
				popIndex++;
			}
		}
		return stack.isEmpty();
	}

}
