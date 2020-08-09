package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/8/8 21:25
 */
public class Q814二叉树剪枝 {

	public TreeNode pruneTree(TreeNode root) {
		return containsOne(root) ? root : null;
	}

	// 整个过程是暴力递归的结构
	public boolean containsOne(TreeNode node) {
		// Base case
		if (node == null) return false;
		// 左边和右边子树是否含1
		boolean left = containsOne(node.left);
		boolean right = containsOne(node.right);
		// 不含1则左右直接删掉,也就是设置为null
		if (!left) node.left = null;
		if (!right) node.right = null;
		// 自己的树是否含1
		return node.val == 1 || left || right;
	}


}
