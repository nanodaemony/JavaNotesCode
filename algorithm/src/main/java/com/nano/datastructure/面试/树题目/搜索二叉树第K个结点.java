package com.nano.datastructure.面试.树题目;

import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/8/14 20:30
 */
public class 搜索二叉树第K个结点 {


	public int kthLargest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();
		int cnt = 0;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.right;
			}
			root = stack.pop();
			cnt++;
			if (cnt == k) return root.val;
			root = root.left;
		}
		return 0;
	}


	int res, index;

	public int kthLargest2(TreeNode root, int k) {
		index = k;
		dfs(root);
		return res;
	}

	public void dfs(TreeNode root) {
		if (root == null) return;
		dfs(root.right);
		if (index == 0) return;
		index--;
		if (index == 0) res = root.val;
		dfs(root.left);
	}

}
