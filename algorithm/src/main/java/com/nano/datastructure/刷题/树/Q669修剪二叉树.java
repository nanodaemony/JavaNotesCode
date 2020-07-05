package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/7/5 17:36
 */
public class Q669修剪二叉树 {

	public TreeNode trimBST(TreeNode root, int left, int right) {
		// Base case
		if(root == null) return null;
		if(root.val < left) return trimBST(root.right, left, right);
		if(root.val > right) return trimBST(root.left, left, right);
		// 涉及到改变树结构的，肯定要改变链接
		root.left = trimBST(root.left, left, right);
		// 通过这两个链接更新，当前结点的左右子树都是修剪过的了
		root.right = trimBST(root.right, left, right);
		// 返回修改过后的root结点
		return root;
	}

}
