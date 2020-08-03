package com.nano.datastructure.刷题.剑指Offer;

import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/7/1 19:24
 */
public class Q30包含min函数的栈 {

	// 存放数据的栈
	private Stack<Integer> dataStack = new Stack<>();
	// 存放最小元素的栈
	private Stack<Integer> minStack = new Stack<>();

	public void push(int node) {
		// 所有数据正常压入普通栈
		dataStack.push(node);
		// 如果为空直接加
		if(minStack.isEmpty()) {
			minStack.push(node);
		} else {
			// 否则看谁小就加进去
			minStack.push(Math.min(minStack.peek(), node));
		}
	}

	public void pop() {
		dataStack.pop();
		minStack.pop();
	}

	public int top() {
		return dataStack.peek();
	}

	public int min() {
		return minStack.peek();
	}

}
