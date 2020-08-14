package com.nano.datastructure.面试.栈与队列;

import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/8/14 20:01
 */
public class 两个栈实现一个队列 {


	private Stack<Integer> inStack = new Stack<>();
	private Stack<Integer> outStack = new Stack<>();

	public void push(int x) {
		// 压入就压到in栈
		inStack.push(x);
	}

	public int pop() {
		// 出栈为空
		if(outStack.isEmpty()) {
			// 如果入栈也为空，抛异常
			if(inStack.isEmpty()) return -1;
			// 将入栈的全部元素放到出栈中
			while(!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}
		// 弹出元素
		return outStack.pop();
	}

	public boolean empty() {
		// 看看是否都为空
		return inStack.isEmpty() && outStack.isEmpty();
	}

}
