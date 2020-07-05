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

		// 记录根节点
		TreeNode node = root;
		while (node != null) {
			// 大于当前节点值就往右子树插入
			if (val > node.val) {
				// 此时插入成功
				if (node.right == null) {
					node.right = new TreeNode(val);
					return root;
					// 否则持续找右子树
				} else {
					node = node.right;
				}
			} else { // 小于节点值就插入左子树
				// 此时插入成功
				if (node.left == null) {
					node.left = new TreeNode(val);
					return root;
				} else {
					// 否则持续找左子树
					node = node.left;
				}
			}
		}
		// 都没有则返回一个节点
		return new TreeNode(val);
	}
}
