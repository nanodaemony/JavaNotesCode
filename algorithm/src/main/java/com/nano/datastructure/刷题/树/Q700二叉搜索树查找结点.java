package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/7/5 17:28
 */
public class Q700二叉搜索树查找结点 {


	/**
	 * 递归法
	 */
	public TreeNode searchBST(TreeNode root, int target) {
		// 为null或者找到就返回
		if (root == null || target == root.val) return root;

		// 整体前序遍历:根据值决定往左还是右查找
		if(target < root.val) {
			return searchBST(root.left, target);
		} else {
			return searchBST(root.right, target);
		}
	}

	/**
	 * 迭代法
	 */
	public TreeNode searchBST2(TreeNode root, int target) {
		while (root != null) {
			if(root.val == target) {
				return root;
			} else if (root.val < target) {
				root = root.right;
			} else {
				root = root.left;
			}
		}
		return null;
	}

}
