package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/3 20:08
 */
public class Q55二叉树的深度I {


	/**
	 * 详细版
	 */
	public int maxDepth(TreeNode root) {
		// Base case
		if(root == null) {
			return 0;
		}

		// 下面是树形dp的模板
		int leftMax = maxDepth(root.left);
		int rightMax = maxDepth(root.right);
		int maxHeight = Math.max(leftMax, rightMax) + 1;
		return maxHeight;
	}



	/**
	 * 精简版
	 */
	public int maxDepth2(TreeNode root) {
		// Base case
		if(root == null) {
			return 0;
		}
		// 下面是树形dp的模板
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}



}
