package com.nano.datastructure.刷题.树;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/7/5 16:56
 */
public class Q501二叉搜索树中的众数 {

	// 最大的值个数
	int maxNumber = 0;
	List<Integer> resList = new LinkedList<>();
	// 当前值
	int currentValue;
	// 当前值计数器
	int counter;

	public int[] findMode(TreeNode root) {
		// Base case
		if (root == null) return new int[0];
		// 初始化当前值
		currentValue = root.val;
		counter = 0;
		// 进行中序遍历递归
		helper(root);
		// 列表里面存的就是众数列表
		int[] result = new int[resList.size()];
		for (int i = 0; i < resList.size(); i++) {
			result[i] = resList.get(i);
		}
		return result;
	}

	// 中序遍历递归:整体是中序递归的架构
	public void helper(TreeNode root) {
		// Base case
		if (root == null) return;
		helper(root.left);
		// 当前值与结点值相同则当前值计数器+1
		if (currentValue == root.val) {
			counter++;
			// 否则计数器君重置为1并当前值更新为结点值
		} else if (currentValue != root.val) {
			counter = 1;
			currentValue = root.val;
		}
		// 如果当前的计数器值等于最大值将这个数记录到列表中
		if (counter == maxNumber) {
			resList.add(currentValue);
			// 说明还有数量更多的众数
		} else if (counter > maxNumber) {
			// 更新最大值个数
			maxNumber = counter;
			// 清空之前缓存的众数记录
			resList.clear();
			resList.add(currentValue);
		}

		helper(root.right);
	}

}
