package com.nano.datastructure.刷题.队列与栈;

import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/7/7 12:57
 */
public class Q20有效的括号 {


	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		// 遍历这个字符串
		for (char c : s.toCharArray()) {
			// 遇到规定的符号就压栈
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
				// 表示遇到闭括号
			} else {
				// 如果此时栈为空直接为false
				if (stack.isEmpty()) {
					return false;
				}
				// 弹出栈顶符号
				char temp = stack.pop();

				if ((temp == '(' && c != ')')) return false;
				if ((temp == '[' && c != ']')) return false;
				if ((temp == '{' && c != '}')) return false;
			}
		}
		// 最后看栈是否为空
		return stack.isEmpty();
	}


}
