package com.nano.datastructure.面试.栈与队列;

import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/8/14 20:01
 */
public class 最小值栈 {

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
