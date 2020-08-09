package com.nano.datastructure.刷题.剑指Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/7/2 13:03
 */
public class Q34二叉树中和为某一值的路径 {


	private List<List<Integer>> resList = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		// 回溯找结果
		process(root, sum, new ArrayList<>());
		return resList;
	}

	// 回溯法
	private void process(TreeNode node, int sum, ArrayList<Integer> path) {
		// Base case
		if (node == null) return;
		// 当前的值加入路径
		path.add(node.val);
		// 将目标值减去当前的node值
		sum = sum - node.val;
		// 当前的值刚好为0且当前节点为叶子节点则认为找到一条
		if (sum == 0 && node.left == null && node.right == null) {
			// 将路径加入结果集
			resList.add(new ArrayList<>(path));
		}
		// 递归左右遍历
		process(node.left, sum, path);
		process(node.right, sum, path);
		path.remove(path.size() - 1);
	}

}
