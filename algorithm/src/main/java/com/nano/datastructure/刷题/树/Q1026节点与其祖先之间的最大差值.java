package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/8/9 12:43
 */
public class Q1026节点与其祖先之间的最大差值 {

	int res = 0;

	public int maxAncestorDiff(TreeNode root) {
		dfs(root, root.val, root.val);
		return res;
	}

	public void dfs(TreeNode node, int maxValue, int minValue) {
		// Base case
		if (node == null) return;
		// 更新结果
		res = Math.max(res, Math.max(Math.abs(maxValue - node.val), Math.abs(minValue - node.val)));
		// 更新最大值
		if (node.val > maxValue) maxValue = node.val;
		// 更新最小值
		if (node.val < minValue) minValue = node.val;
		// 递归
		dfs(node.left, maxValue, minValue);
		dfs(node.right, maxValue, minValue);
	}

}
