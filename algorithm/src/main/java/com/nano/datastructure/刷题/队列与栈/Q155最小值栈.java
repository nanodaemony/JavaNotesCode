package com.nano.datastructure.刷题.队列与栈;

import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/7/7 12:49
 */
public class Q155最小值栈 {

	private Stack<Integer> dataStack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();


	public void push(int data) {
		// 压入普通栈
		dataStack.push(data);
		// 如果新值小于最小值栈的栈顶就同时压入最小值栈
		if(minStack.isEmpty() || data <= minStack.peek()) {
			minStack.push(data);
		}
	}


	public void pop() {
		// 如果弹出的元素等于最小值栈的栈顶，则同时弹出
		if(dataStack.pop().equals(minStack.peek())) {
			minStack.pop();
		}
	}

	public int top() {
		return dataStack.peek();
	}
	public int getMin() {
		return minStack.peek();
	}

}
