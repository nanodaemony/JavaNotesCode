package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/7/5 21:54
 */
public class Q965单值二叉树 {

	boolean res = true;
	int rootVal = 0;
	public boolean isUnivalTree(TreeNode root) {
		if(root == null) return false;
		rootVal = root.val;
		// 首先保存根节点的值
		process(root);
		return res;
	}

	private void dfs(TreeNode root) {
		// Base case
		if(root == null) return;

		// 如果这个值与根节点不同则不是单值的
		if(root.val != rootVal) res = false;

		// 获取左右子树的信息
		dfs(root.left);
		dfs(root.right);
	}




	int value;

	public boolean isUnivalTree3(TreeNode root) {
		if(root == null) return false;
		// 首先保存根节点的值
		value = root.val;
		return process(root);
	}

	private boolean process(TreeNode root) {
		// Base case
		if(root == null) return true;
		// 如果这个值与根节点不同则不是单值的
		if(root.val != value) return false;
		// 获取左右子树的信息
		boolean left = process(root.left);
		boolean right = process(root.right);
		// 必须左右子树都为true才是true
		return left && right;
	}
}
