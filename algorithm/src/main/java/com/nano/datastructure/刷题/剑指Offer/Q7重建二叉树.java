package com.nano.datastructure.刷题.剑指Offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 利用中序与前序遍历结果重建二叉树
 *
 * @author: nano
 * @time: 2020/6/30 22:31
 */
public class Q7重建二叉树 {

	/**
	 * 缓存中序遍历数组每个值对应的索引
	 */
	HashMap<Integer, Integer> dict = new HashMap<>();

	int[] po;

	public TreeNode buildTree(int[] preOrder, int[] inOrder) {
		// 前序遍历数组
		po = preOrder;
		// 将中序遍历的结果放入Map并记录其索引位置
		for (int i = 0; i < inOrder.length; i++) {
			dict.put(inOrder[i], i);
		}
		// 第一个根结点就是前序数组的0位置
		return process(0, 0, inOrder.length - 1);
	}

	TreeNode process(int preRoot, int inLeft, int inRight) {
		// Base case
		if (inLeft > inRight) return null;
		// 构造根结点：就是前序数组的第一个元素
		TreeNode root = new TreeNode(po[preRoot]);
		// 从字典中找到根结点的索引位置
		int rootIndex = dict.get(po[preRoot]);
		// 递归构造左右子树
		root.left = process(preRoot + 1, inLeft, rootIndex - 1);
		root.right = process(preRoot + rootIndex - inLeft + 1, rootIndex + 1, inRight);
		return root;
	}


	public TreeNode buildTree2(int[] preorder, int[] inorder) {

		// 下面四行代码其实就是把数组转换成list
		List<Integer> pre = new ArrayList<>();
		for (int i : preorder) pre.add(i);
		List<Integer> in = new ArrayList<>();
		for (int i : inorder) in.add(i);

		// 其实这个函数就这一行
		return process(pre, in);
	}

	TreeNode process(List<Integer> pre, List<Integer> in) {
		// 递归停止条件，就是遍历完了列表
		if (pre.size() == 0) return null;

		// 前序遍历的第一个元素就是root
		int val = pre.get(0);
		TreeNode root = new TreeNode(val);

		// 从中序遍历里面找到root的位置，就把中序遍历分成两部分了
		int rootIndex = in.indexOf(root.val);

		//别问 问就是递归
		root.left = process(pre.subList(1, 1 + rootIndex), in.subList(0, rootIndex));
		root.right = process(pre.subList(1 + rootIndex, pre.size()), in.subList(1 + rootIndex, in.size()));
		return root;
	}


}
