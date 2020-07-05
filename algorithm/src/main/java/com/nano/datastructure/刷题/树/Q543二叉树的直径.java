package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/7/5 21:34
 */
public class Q543二叉树的直径 {

	int res;
	public int diameterOfBinaryTree(TreeNode root) {
		res = 1;
		depth(root);
		return res - 1;
	}
	public int depth(TreeNode node) {
		// Base case
		if (node == null) return 0;
		// 分别获取左右子树的直径信息
		int leftDiameter = depth(node.left);
		int rightDiameter = depth(node.right);
		// 计算L+R+1并更新ans
		res = Math.max(res, leftDiameter + rightDiameter + 1);
		// 构造自己的直径值并返回
		return Math.max(leftDiameter, rightDiameter) + 1;
	}

}
