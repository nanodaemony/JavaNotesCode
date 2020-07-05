package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/7/5 21:54
 */
public class Q965单值二叉树 {

	boolean res = true;
	public boolean isUnivalTree(TreeNode root) {
		if(root == null) return false;
		// 首先保存根节点的值
		process(root, root.val);
		return res;
	}

	private void process(TreeNode root, int originVal) {
		// Base case
		if(root == null) return;

		// 如果这个值与根节点不同则不是单值的
		if(root.val != originVal) res = false;

		// 获取左右子树的信息
		process(root.left, originVal);
		process(root.right, originVal);
	}

}
