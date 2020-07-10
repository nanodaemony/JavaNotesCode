package com.nano.datastructure.刷题.队列与栈;

import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/7/7 12:36
 */
public class Q232用栈实现队列 {

	private Stack<Integer> inStack = new Stack<>();
	private Stack<Integer> outStack = new Stack<>();

	// 压入就压到in栈
	public void push(int x) {
		inStack.push(x);
	}

	public int pop() {
		in2out();
		return outStack.pop();
	}

	public int peek() {
		in2out();
		return outStack.peek();
	}

	// 如果out栈为空则将in栈全部压到out栈中
	private void in2out() {
		if (outStack.isEmpty()) {
			while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}
	}

	public boolean empty() {
		return inStack.isEmpty() && outStack.isEmpty();
	}

}
