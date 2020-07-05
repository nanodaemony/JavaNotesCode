package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/7/5 22:00
 */
public class Q226二叉树的镜像 {


	public TreeNode invertTree(TreeNode root) {
		if (root == null) return null;
		// 先获取左右的子树信息
		TreeNode right = invertTree(root.right);
		TreeNode left = invertTree(root.left);
		// 分别设置之后返回自己
		root.left = right;
		root.right = left;
		return root;
	}


}
