package com.nano.datastructure.面试.树题目;

/**
 * @author: nano
 * @time: 2020/8/14 21:49
 */
public class 二叉树结点的最低公共祖先 {

	/**
	 * 搜索二叉树
	 */
	public TreeNode lowestCommonAncestorBianry(TreeNode root, TreeNode p, TreeNode q) {
		// Base case
		if (root == null) return null;
		// 两个值都小于当前节点 继续往左边找
		if (root.val > p.val && root.val > q.val) {
			return lowestCommonAncestorBianry(root.left, p, q);
		}
		// 两个值都大于当节点值 继续往右边找
		if (root.val < p.val && root.val < q.val) {
			return lowestCommonAncestorBianry(root.right, p, q);
		}
		// 一个小一个大则算找到了
		return root;
	}


	/**
	 * 一般二叉树
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
		if(left == null) return right;
		if(right == null) return left;
		return root;
	}

}
