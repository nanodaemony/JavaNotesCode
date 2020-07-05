package com.nano.datastructure.刷题.剑指Offer;

import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/7/1 19:50
 */
public class 栈的压入弹出序列 {

	public boolean IsPopOrder(int[] pushSequence, int[] popSequence) {

		// 求长度
		int n = pushSequence.length;
		Stack<Integer> stack = new Stack<>();

		for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
			// 不断压栈
			stack.push(pushSequence[pushIndex]);

			// 如果当前栈顶就是弹出绪论的值，就弹出栈中元素 并增加弹出索引
			while (popIndex < n && !stack.isEmpty() && stack.peek() == popSequence[popIndex]) {
				stack.pop();
				popIndex++;
			}
		}
		return stack.isEmpty();
	}

}
