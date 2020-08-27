package com.nano.datastructure.面试.树题目;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: nano
 * @time: 2020/8/24 20:42
 */
public class 二叉树展开为链表 {


	public void flatten(TreeNode root) {
		if (root == null) return;
		Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		// 记录链表的尾部结点
		TreeNode cur = null;
		while (!stack.isEmpty()) {
			// 弹出一个节点
			TreeNode node = stack.pop();
			if (cur != null) {
				cur.left = null;
				cur.right = node;
			}
			TreeNode left = node.left, right = node.right;
			// 当前节点的左右加入队列
			if (right != null) stack.push(right);
			if (left != null) stack.push(left);
			// 切换prev节点
			cur = node;
		}
	}



}
