package com.nano.datastructure.面试.树题目;

/**
 * @author: nano
 * @time: 2020/8/20 18:51
 */
public class 二叉树中的最大路径和 {

	int res = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		if (root == null) return 0;
		dfs(root);
		return res;
	}

	public int dfs(TreeNode root) {
		// Base case
		if (root == null) return 0;
		// 获取左右孩子的贡献,如果是负的就取0
		int leftMax  = Math.max(0, dfs(root.left));
		int rightMax = Math.max(0, dfs(root.right));
		// 看看是否需要更新答案
		res = Math.max(res, root.val + leftMax + rightMax);
		// 返回当前节点的总贡献
		return root.val + Math.max(leftMax, rightMax);
	}


}
