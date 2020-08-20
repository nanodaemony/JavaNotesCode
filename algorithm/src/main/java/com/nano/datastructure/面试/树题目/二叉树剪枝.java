package com.nano.datastructure.面试.树题目;

/**
 * @author: nano
 * @time: 2020/8/20 19:14
 */
public class 二叉树剪枝 {



	public TreeNode pruneTree(TreeNode root) {
		// Base case
		if (root == null) return null;
		// 设置左右结点
		root.left = pruneTree(root.left);
		root.right = pruneTree(root.right);
		// 如果为0且为叶子结点则返回null
		if (root.val == 0 && root.left == null && root.right == null) return null;
		return root;
	}


	public TreeNode pruneTree2(TreeNode root) {
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
