package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/7/6 21:30
 */
public class Q101对称二叉树 {

	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		// 调用递归函数，比较左节点，右节点
		return dfs(root.left, root.right);
	}

	boolean dfs(TreeNode left, TreeNode right) {
		// 递归的终止条件是两个节点都为空
		// 或者两个节点中有一个为空
		// 或者两个节点的值不相等
		if (left == null && right == null) return true;
		if (left == null || right == null) return false;
		if (left.val != right.val) return false;
		// 再递归的比较左节点的左孩子和右节点的右孩子
		// 以及比较左节点的右孩子和右节点的左孩子
		return dfs(left.left, right.right) && dfs(left.right, right.left);
	}


}
