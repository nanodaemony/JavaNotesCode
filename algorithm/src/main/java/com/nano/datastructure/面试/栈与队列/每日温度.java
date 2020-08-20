package com.nano.datastructure.面试.栈与队列;

import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/8/19 21:43
 */
public class 每日温度 {

	public int[] dailyTemperatures(int[] temp) {
		Stack<Integer> stack = new Stack<>();
		int[] res = new int[temp.length];

		for (int i = 0; i < temp.length; i++) {
			// 当前温度大于栈顶温度
			while (!stack.isEmpty() && temp[i] > temp[stack.peek()]) {
				// 弹出可以求出值的索引
				int index = stack.pop();
				// 当前i减去栈顶索引即是最大距离
				res[index] = i - index;
			}
			// 一轮比较完成,当前元素压栈
			stack.push(i);
		}
		return res;
	}



}
