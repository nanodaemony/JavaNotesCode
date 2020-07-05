package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/7/5 22:05
 */
public class Q897递增顺序查找树 {

	TreeNode cur;
	public TreeNode increasingBST(TreeNode root) {
		// 引入一个dummy节点
		TreeNode dummy = new TreeNode(0);
		cur = dummy;
		// 中序遍历递归构造
		inorder(root);
		// 返回右子节点
		return dummy.right;
	}

	// 整体中序遍历的架构，类似移动链表
	public void inorder(TreeNode node) {
		// Base case
		if (node == null) return;
		// 整体中序遍历
		inorder(node.left);
		// 把cur节点的左变成当前节点
		node.left = null;
		cur.right = node;
		// 移动cur节点
		cur = node;
		inorder(node.right);
	}

}
