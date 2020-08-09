package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/7/5 17:36
 */
public class Q669修剪二叉树 {

	private int left;
	private int right;

	public TreeNode trimBST(TreeNode root, int left, int right) {
		this.left = left;
		this.right = right;
		// Base case
		return trim(root);
	}

	private TreeNode trim(TreeNode root) {
		if(root == null) return root;
		if(root.val < left) {
			root.left = trim(root.left);
		} else if (root.val > right) {
			root.right = trim(root.right);
		}
		return root;
//		if(root.val < left) return trim(root.right);
//		if(root.val > right) return trim(root.left);

	}

}
