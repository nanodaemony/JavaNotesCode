package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/3 19:59
 */
public class 二叉查找树的第K个结点 {

	int res, k;
	public int kthLargest(TreeNode root, int k) {
		this.k = k;
		inOrder(root);
		return res;
	}
	// 中序遍历模板
	void inOrder(TreeNode root) {
		// Base case
		if(root == null) {
			return;
		}
		inOrder(root.right);
		if(k == 0) {
			return;
		}
		if(--k == 0) {
			res = root.val;
		}
		inOrder(root.left);
	}


}
