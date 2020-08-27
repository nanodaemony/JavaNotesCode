package com.nano.datastructure.面试.字符串;

import java.util.Collections;
import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/8/21 13:13
 */
public class 字符串解码 {


	public String decodeString(String str) {
		// 结果集（字符串拼接用StringBuilder），表示上一层（数字字符之前）的字符串
		StringBuilder resBuilder = new StringBuilder();

		// 数字栈,存储当前需要循环拼接的次数
		Stack<Integer> numStack = new Stack<>();
		// 字符串栈,存储当前已拼接的字符串
		Stack<StringBuilder> strStack = new Stack<>();
		// 数字,用于处理>10的数字字符
		StringBuilder numBuilder = new StringBuilder();

		for (int i = 0, len = str.length(); i < len; i++) {
			char cur = str.charAt(i);
			// 1.如果当前字符为0~9,加入数字numBuilder中
			if (Character.isDigit(cur)) {
				numBuilder.append(cur - '0');
				// 2.如果当前字符为'[',开始入栈操作
			} else if (cur == '[') {
				// 数字栈中加入之前获取到的数字字符串（强转Integer）
				numStack.push(Integer.valueOf(numBuilder.toString()));
				// 字符串栈中加入当前操作拼接的字符串
				strStack.push(resBuilder);
				// 重新实例化字符结果集和数字集,用于里层的字符操作
				resBuilder = new StringBuilder();
				numBuilder = new StringBuilder();
				// 3.如果当前字符为']',开始出栈操作
			} else if (cur == ']') {
				// 取出数字,代表需要循环拼接的字符的次数
				int times = numStack.pop();
				// 需要拼接的字符串
				String innerString = resBuilder.toString();
				// 循环从1开始，因为当前的字符已有内容
				for (int loop = 1; loop < times; loop++) {
					resBuilder.append(innerString);
				}
				// 取出字符串（上一层中拼接的字符串）,并拼接上当前结果
				resBuilder = strStack.pop().append(resBuilder);
				// 4.如果为其他字符，则直接拼接
			} else {
				resBuilder.append(cur);
			}
		}
		return resBuilder.toString();
	}



}
