package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/2 13:19
 */
public class 二叉搜索树与双向链表 {

	private TreeNode pre = null;
	// 链表head结点
	private TreeNode head = null;

	public TreeNode Convert(TreeNode root) {
		inOrder(root);
		return head;
	}

	// 整体模板是中序遍历
	private void inOrder(TreeNode node) {
		// Base case
		if (node == null) return;
		inOrder(node.left);
		
		node.left = pre;
		if (pre != null)
			pre.right = node;
		pre = node;
		if (head == null)
			head = node;

		inOrder(node.right);
	}

}
