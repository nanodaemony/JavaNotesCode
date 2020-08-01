package com.nano.datastructure.刷题.剑指Offer;

import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/7/30 13:14
 */
public class Q9用两个栈实现队列 {


	Stack<Integer> pushStack = new Stack<>();
	Stack<Integer> popStack = new Stack<>();

	// 压栈操作一直往in栈压入进行累计
	public void push(int node) {
		pushStack.push(node);
	}

	// 弹栈操作则从out栈取，如果没有就把in栈的全部搬到out栈中
	public int pop() throws Exception {
		// 如果为空
		if (popStack.isEmpty()) {
			while (!pushStack.isEmpty()) {
				popStack.push(pushStack.pop());
			}
		}
		// 都为空抛异常
		if (popStack.isEmpty())
			throw new Exception("queue is empty");
		return popStack.pop();
	}

}
