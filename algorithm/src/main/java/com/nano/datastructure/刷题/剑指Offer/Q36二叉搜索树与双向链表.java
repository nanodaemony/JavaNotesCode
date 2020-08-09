package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/2 13:19
 */
public class Q36二叉搜索树与双向链表 {

	Node pre, head;
	public Node treeToDoublyList(Node root) {
		if(root == null) return null;
		dfs(root);
		head.left = pre;
		pre.right = head;
		return head;
	}
	// 整体中序遍历模板
	void dfs(Node cur) {
		if(cur == null) return;
		dfs(cur.left);
		if(pre != null) {
			pre.right = cur;
		} else {
			head = cur;
		}
		cur.left = pre;
		pre = cur;
		dfs(cur.right);
	}



	class Node {
		public int val;
		public Node left;
		public Node right;

		public Node() {}

		public Node(int val) {
			this.val = val;
		}

		public Node(int val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	};
}
