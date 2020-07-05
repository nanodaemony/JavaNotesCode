package com.nano.datastructure.刷题.剑指Offer;

import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/7/1 19:24
 */
public class 包含min函数的栈 {

	// 存放数据的栈
	private Stack<Integer> dataStack = new Stack<>();
	// 存放最小元素的栈
	private Stack<Integer> minStack = new Stack<>();

	public void push(int node) {
		// 所有数据正常压入普通栈
		dataStack.push(node);

		minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
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
