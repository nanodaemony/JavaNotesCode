package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/7/5 21:20
 */
public class Q1325删除给定值的叶子节点 {

	// 先处理叶子所以整个是后序遍历的过程
	public TreeNode removeLeafNodes(TreeNode root, int target) {
		// Base case
		if (root == null) return null;
		// 递归设置结点的左右结点值
		root.left = removeLeafNodes(root.left, target);
		root.right = removeLeafNodes(root.right, target);
		// 如果是子结点且刚好需要删除，则返回null，否则返回root本身
		// 判断是否是等于target的子节点
		if (root.left == null && root.right == null && root.val == target) {
			// 直接返回null代表删除
			return null;
		}
		// 这个结点不删除则直接返回
		return root;
	}

}
