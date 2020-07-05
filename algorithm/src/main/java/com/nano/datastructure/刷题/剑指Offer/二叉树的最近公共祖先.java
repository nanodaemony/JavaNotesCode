package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/4 16:48
 */
public class 二叉树的最近公共祖先 {

	/**
	 * 整体是树形dp的套路
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// Base case:返回null或者返回自己
		if(root == null || root == p || root == q) {
			return root;
		}
		// 分别找左右的信息
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		// 构造自己的返回信息
		if(left == null) {
			return right;
		}
		if(right == null) {
			return left;
		}
		return root;
	}


}
