package com.nano.datastructure.刷题.队列与栈;

import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/7/7 13:08
 */
public class Q739每日温度 {

	/**
	 * 最小栈法
	 */
	public int[] dailyTemperatures(int[] temp) {
		int len = temp.length;
		int[] res = new int[len];
		// 辅助栈
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < len; i++) {
			// 当前遍历的数比栈顶元素大
			while (!stack.isEmpty() && temp[i] > temp[stack.peek()]) {
				// 栈顶元素的下一个比它大的数就是当前元素
				int preIndex = stack.pop();
				res[preIndex] = i - preIndex;
			}
			// 持续压入栈
			stack.push(i);
		}
		return res;
	}


	/**
	 * 从右往左遍历法
	 */
	public int[] dailyTemperatures2(int[] nums) {
		int length = nums.length;
		int[] res = new int[length];
		// 从倒数第二个开始从右向左遍历,最后一个肯定是0
		for (int i = length - 2; i >= 0; i--) {
			// j+= result[j]是利用已经有的结果进行跳跃
			for (int j = i + 1; j < length; j += res[j]) {
				if (nums[j] > nums[i]) {
					res[i] = j - i;
					break;
					// 遇到0表示后面不会有更大的值，那当然当前值就应该也为0
				} else if (res[j] == 0) {
					res[i] = 0;
					break;
				}
			}
		}
		return res;
	}

}
