package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/4 16:41
 */
public class Q68二叉搜索树的最近公共祖先 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// Base case
		if (root == null) {
			return null;
		}
		// 两个值都小于当前节点 继续往左边找
		if (root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		}
		// 两个值都大于当节点值 继续往右边找
		if (root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		}
		// 一个小一个大则算找到了
		return root;
	}

}
