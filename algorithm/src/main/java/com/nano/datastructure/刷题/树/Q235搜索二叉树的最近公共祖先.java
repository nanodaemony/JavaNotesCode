package com.nano.datastructure.刷题.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: nano
 * @time: 2020/7/5 17:10
 */
public class Q235搜索二叉树的最近公共祖先 {

	/**
	 * 迭代法
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
		// Base case
		if (root == null) return null;

		// 得到两个目标结点的较大值和较小值
		int min = Math.min(node1.val, node2.val);
		int max = Math.max(node1.val, node2.val);
		// 使用普通层序遍历的方式进行
		Queue<TreeNode> queue = new LinkedList();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			// 判断值，第一个符合条件的就直接返回
			if (node.val >= min && node.val <= max) return node;
			if (node.left != null) queue.offer(node.left);
			if (node.right != null) queue.offer(node.right);
		}
		// 没找到返回null
		return null;
	}

	/**
	 * 递归法
	 */
	public TreeNode LowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
		// Base case
		if (node1 == null || node2 == null || root == null) return null;
		// 两个结点都在当前节点左子树则以当前节点左子节点继续遍历
		if (node1.val < root.val && node2.val < root.val) {
			return LowestCommonAncestor(root.left, node1, node2);
		}
		// 两个结点都在当前节点右子树则以当前节点右子节点继续遍历
		if (node1.val > root.val && node2.val > root.val) {
			return LowestCommonAncestor(root.right, node1, node2);
		}
		// 如果左边大于等于，右边小于等于，找到了满足条件的直接返回root
		if (node1.val <= root.val && node2.val >= root.val) {
			return root;
		}
		return root;
	}


}
