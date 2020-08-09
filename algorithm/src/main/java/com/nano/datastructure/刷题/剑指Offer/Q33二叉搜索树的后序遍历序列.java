package com.nano.datastructure.刷题.剑指Offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: nano
 * @time: 2020/7/1 20:27
 */
public class Q33二叉搜索树的后序遍历序列 {

	public boolean verifyPostorder(int[] sequence) {
		// Base case
		if (sequence == null || sequence.length == 0) return true;
		// 验证一个范围是不是
		return verify(sequence, 0, sequence.length - 1);
	}


	private boolean verify(int[] nums, int first, int last) {
		// 如果只有一或两个元素直接返回
		if (last - first <= 1) return true;
		// 后序遍历根结点值在最后一个
		int rootVal = nums[last];
		// 从头开始搜索剪切点
		int cutIndex = first;
		while (cutIndex < last && nums[cutIndex] <= rootVal) {
			cutIndex++;
		}
		for (int i = cutIndex; i < last; i++)
			if (nums[i] < rootVal)
				return false;
		return verify(nums, first, cutIndex - 1) && verify(nums, cutIndex, last - 1);
	}


	/**
	 * 单调栈法
	 */
	public boolean verifyPostorder2(int[] postOrder) {
		// 单调栈使用，单调递增的单调栈
		Deque<Integer> stack = new LinkedList<>();
		// 表示上一个根节点的元素，这里可以把postOrder的最后一个元素root看成无穷大节点的左孩子
		int pervElem = Integer.MAX_VALUE;
		// 逆向遍历，就是翻转的先序遍历
		for (int i = postOrder.length - 1; i >= 0; i--) {
			// 左子树元素必须要小于递增栈被peek访问的元素，否则就不是二叉搜索树
			if (postOrder[i] > pervElem) {
				return false;
			}
			while (!stack.isEmpty() && postOrder[i] < stack.peek()) {
				// 数组元素小于单调栈的元素了，表示往左子树走了，记录下上个根节点
				// 找到这个左子树对应的根节点，之前右子树全部弹出，不再记录，因为不可能在往根节点的右子树走了
				pervElem = stack.pop();
			}
			// 这个新元素入栈
			stack.push(postOrder[i]);
		}
		return true;
	}


}
