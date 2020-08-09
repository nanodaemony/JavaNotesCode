package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/7/5 22:05
 */
public class Q897递增顺序查找树 {

	// cur结点沿着链表移动进行设置
	TreeNode cur;
	public TreeNode increasingBST(TreeNode root) {
		// 引入一个dummy节点
		TreeNode dummy = new TreeNode(0);
		cur = dummy;
		// 中序遍历递归构造
		process(root);
		// 返回右子节点
		return dummy.right;
	}

	// 整体中序遍历的架构，类似移动链表
	public void process(TreeNode node) {
		// Base case
		if (node == null) return;
		process(node.left);
		// cur的左结点都为null
		node.left = null;
		// 把cur节点的右变成当前节点node
		cur.right = node;
		// 不断移动cur节点到链表尾部
		cur = node;
		process(node.right);
	}

}
