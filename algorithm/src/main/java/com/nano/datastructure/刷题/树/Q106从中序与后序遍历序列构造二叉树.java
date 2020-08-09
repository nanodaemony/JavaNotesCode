package com.nano.datastructure.刷题.树;

import java.util.HashMap;

/**
 * @author: nano
 * @time: 2020/7/5 19:33
 */
public class Q106从中序与后序遍历序列构造二叉树 {


	// 使用辅助的HashMap存储元素，键为中序数组元素值，值为中序数组索引
	HashMap<Integer, Integer> postMap = new HashMap<>();

	int[] post;

	public TreeNode buildTree(int[] inOrder, int[] postOrder) {
		// 将中序数组的值及其对应的索引全部放入到Map中
		for (int i = 0; i < inOrder.length; i++) postMap.put(inOrder[i], i);
		post = postOrder;
		// 使用辅助方法
		return buildTree(0, inOrder.length - 1, 0, post.length - 1);
	}


	public TreeNode buildTree(int inStart, int inEnd, int postStart, int postEnd) {
		// Base case
		if (inEnd < inStart || postEnd < postStart) return null;
		// 根节点等于后序数组的最后一个元素值
		int rootVal = post[postEnd];
		// 构造根节点并递归设置其左右子结点
		TreeNode root = new TreeNode(rootVal);
		// 从Map中找到等于这个值的元素的中序数组索引
		int rootIndex = postMap.get(rootVal);
		// 分别构造左右子树 左右子树的边界确定是最重要的 自己画个图看看！
		root.left = buildTree(inStart, rootIndex - 1, postStart, postStart + rootIndex - inStart - 1);
		root.right = buildTree(rootIndex + 1, inEnd, postStart + rootIndex - inStart, postEnd - 1);
		// 返回构造好的根节点
		return root;
	}



	// -------------另一种构造方法--------------------


	int postIndex;
	int[] postOrder;
	int[] inOrder;
	HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

	public TreeNode buildTree2(int[] inOrder, int[] postOrder) {
		this.postOrder = postOrder;
		this.inOrder = inOrder;
		// 后序数组的最后一个数是根结点
		postIndex = postOrder.length - 1;

		// 将中序数组的值及其对应的索引放入Map中
		int index = 0;
		for (Integer val : inOrder) indexMap.put(val, index++);

		return helper(0, inOrder.length - 1);
	}

	public TreeNode helper(int inLeft, int inRight) {
		// Base case
		if (inLeft > inRight) return null;

		// 找到后序数组的最后一个作为根元素
		int rootVal = postOrder[postIndex];
		// 构造根结点
		TreeNode root = new TreeNode(rootVal);
		// 找到中序数组中根结点的索引
		int index = indexMap.get(rootVal);

		// recursion
		postIndex--;
		// 递归构造左右子树
		root.right = helper(index + 1, inRight);
		root.left = helper(inLeft, index - 1);
		return root;
	}




}
