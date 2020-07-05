package com.nano.datastructure.刷题.树;

import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/7/5 16:36
 */
public class Q938二叉搜索树的范围和 {

	int sum;
	public int rangeSumBST(TreeNode root, int L, int R) {
		sum = 0;
		dfs(root, L, R);
		return sum;
	}

	// 递归求解，整体先序遍历模板
	public void dfs(TreeNode node, int left, int right) {
		if (node != null) {
			// 这个值OK，加上
			if (left <= node.val && node.val <= right)
				sum = sum + node.val;
			// 递归左子树
			if (left < node.val)
				dfs(node.left, left, right);
			// 递归右子树
			if (node.val < right)
				dfs(node.right, left, right);
		}
	}


	/**
	 * 迭代法
	 */
	public int rangeSumBST2(TreeNode root, int L, int R) {
		int sum = 0;
		// 使用栈
		Stack<TreeNode> stack = new Stack();
		// 根节点压栈
		stack.push(root);
		while (!stack.isEmpty()) {
			// 弹出一个节点
			TreeNode node = stack.pop();
			if (node != null) {
				// 如果符合条件
				if (L <= node.val && node.val <= R)
					sum += node.val;
				// 先压左边再压右边
				if (L < node.val)
					stack.push(node.left);
				if (node.val < R)
					stack.push(node.right);
			}
		}
		return sum;
	}

}
