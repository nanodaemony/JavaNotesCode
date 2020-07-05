package com.nano.datastructure.刷题.剑指Offer;

import java.util.ArrayList;

/**
 * @author: nano
 * @time: 2020/7/2 13:03
 */
public class 二叉树中和为某一值的路径 {


	private ArrayList<ArrayList<Integer>> resList = new ArrayList<>();

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		// 回溯找结果
		process(root, target, new ArrayList<>());
		return resList;
	}
	// 回溯法
	private void process(TreeNode node, int target, ArrayList<Integer> path) {
		// Base case
		if (node == null) return;
		// 当前的值加入路径
		path.add(node.val);
		// 将目标值减去当前的node值
		target = target - node.val;
		// 当前的值刚好为0且当前节点为叶子节点则认为找到一条
		if (target == 0 && node.left == null && node.right == null) {
			// 将路径加入结果集
			resList.add(new ArrayList<>(path));
		} else {
			// 不是就递归左右计算
			process(node.left, target, path);
			process(node.right, target, path);
		}
		path.remove(path.size() - 1);
	}
}
