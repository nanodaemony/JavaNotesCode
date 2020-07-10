package com.nano.datastructure.刷题.队列与栈;

import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/7/7 13:08
 */
public class Q739每日温度 {


	public int[] dailyTemperatures(int[] temperatures) {
		int len = temperatures.length;
		int[] distance = new int[len];
		// 辅助栈
		Stack<Integer> indexStack = new Stack<>();

		for (int i = 0; i < len; i++) {
			// 当前遍历的数比栈顶元素大
			while (!indexStack.isEmpty() && temperatures[i] > temperatures[indexStack.peek()]) {
				// 栈顶元素的下一个比它大的数就是当前元素
				int preIndex = indexStack.pop();
				distance[preIndex] = i - preIndex;
			}
			// 持续压入栈
			indexStack.add(i);
		}
		return distance;
	}

}
