package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/7/5 17:03
 */
public class Q701二叉搜索树中的插入操作 {

	public TreeNode insertIntoBST(TreeNode root, int val) {
		// 如果根结点为null直接返回这个值的节点
		if (root == null) return new TreeNode(val);
		// 插入左子树
		if (val > root.val) {
			root.right = insertIntoBST(root.right, val);
			// 插入右子树
		} else {
			root.left = insertIntoBST(root.left, val);
		}
		// 返回根结点
		return root;
	}


	/**
	 * 迭代法
	 */
	public TreeNode insertIntoBST2(TreeNode root, int val) {
		// Base case
		if (root == null) return new TreeNode(val);
		TreeNode cur = root;
		// 遍历找到插入位置
		while (true) {
			// 小于往左边插入
			if (val < cur.val) {
				if (cur.left != null) {
					cur = cur.left;
				} else {
					cur.left = new TreeNode(val);
					break;
				}
			} else if (val > cur.val) {
				if (cur.right != null) {
					cur = cur.right;
				} else {
					cur.right = new TreeNode(val);
					break;
				}
			}
		}
		return root;
	}

}
