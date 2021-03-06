package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/7/5 21:34
 */
public class Q543二叉树的直径 {

	int res = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		dfs(root);
		return res;
	}

	// 自底向上暴力递归模板
	public int dfs(TreeNode node) {
		// Base case
		if (node == null) return 0;
		// 分别获取左右子树的直径信息
		int leftDiameter = dfs(node.left);
		int rightDiameter = dfs(node.right);
		// 计算L+R+1并更新ans
		res = Math.max(res, leftDiameter + rightDiameter + 1);
		// 构造自己的直径值并返回
		return Math.max(leftDiameter, rightDiameter) + 1;
	}

}
