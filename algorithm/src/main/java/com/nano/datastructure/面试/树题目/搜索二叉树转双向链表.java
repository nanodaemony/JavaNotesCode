package com.nano.datastructure.面试.树题目;

/**
 * @author: nano
 * @time: 2020/8/15 19:44
 */
public class 搜索二叉树转双向链表 {

	// 双向链表头尾结点
	TreeNode head = null;
	TreeNode end = null;

	public TreeNode treeToDoublyList(TreeNode root) {
		if(root == null) return null;
		// 递归构造
		dfs(root);
		head.left = end;
		end.right = head;
		return head;
	}

	// 整体中序遍历模板
	void dfs(TreeNode root) {
		if(root == null) return;
		dfs(root.left);
		// 当前结点指向root结点
		root.left = end;
		// 如果end为空则直接加入
		if(end == null) {
			head = root;
		} else {
			// end结点的右之前当前结点
			end.right = root;
		}
		// end移动到当前结点
		end = root;
		dfs(root.right);
	}

}
