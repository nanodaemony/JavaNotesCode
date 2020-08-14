package com.nano.datastructure.面试.树题目;

import java.util.HashMap;

/**
 * @author: nano
 * @time: 2020/8/14 21:46
 */
public class 前序中序重建二叉树 {

	// 缓存中序遍历数组每个值对应的索引
	HashMap<Integer, Integer> dict = new HashMap<>();

	int[] po;

	public TreeNode buildTree(int[] preOrder, int[] inOrder) {
		// 前序遍历数组
		po = preOrder;
		// 将中序遍历的结果放入Map并记录其索引位置
		for(int i = 0; i < inOrder.length; i++) {
			dict.put(inOrder[i], i);
		}
		// 第一个根结点就是前序数组的0位置
		return process(0, 0, inOrder.length - 1);
	}

	TreeNode process(int preRoot, int inLeft, int inRight) {
		// Base case
		if(inLeft > inRight) return null;
		// 构造根结点：就是前序数组的第一个元素
		TreeNode root = new TreeNode(po[preRoot]);
		// 从字典中找到根结点的索引位置
		int rootIndex = dict.get(po[preRoot]);
		// 递归构造左右子树
		root.left = process(preRoot + 1, inLeft, rootIndex - 1);
		root.right = process(preRoot + rootIndex - inLeft + 1, rootIndex + 1, inRight);
		return root;
	}
}
