package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/8/6 13:26
 */
public class Q55平衡二叉树II {
	private boolean balance = true;

	public boolean isBalanced(TreeNode root) {
		process(root);
		return balance;
	}

	private int process(TreeNode root) {
		// Base case
		if(root == null) return 0;
		// 递归获取左右子树信息
		int leftHeight = process(root.left);
		int rightHeight = process(root.right);
		// 构造自己的信息
		if(Math.abs(leftHeight - rightHeight) > 1) {
			// 直接更新最终结果
			balance = false;
		}
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
