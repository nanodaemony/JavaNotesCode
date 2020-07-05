package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/7/5 21:00
 */
public class Q563二叉树的坡度 {


	// 最后的答案
	private int res = 0;

	public int findTilt(TreeNode root) {
		process(root);
		return res;
	}

	// 暴力递归
	private int process(TreeNode root) {
		// Base case
		if(root == null) return 0;
		// 从左右子树获取其所有节点值之和的信息
		int left = process(root.left);
		int right = process(root.right);
		// 当时计算每个节点的坡度值并更新res
		int poDu = Math.abs(left - right);
		res = res + poDu;
		// 返回以自己为根节点的整棵树的所有节点值之和
		return left + right + root.val;
	}

}
