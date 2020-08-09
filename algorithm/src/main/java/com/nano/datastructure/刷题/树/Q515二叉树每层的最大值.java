package com.nano.datastructure.刷题.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * @author: nano
 * @time: 2020/7/5 15:15
 */
public class Q515二叉树每层的最大值 {

	public List<Integer> largestValues(TreeNode root) {
		// Base case
		if(root == null) return new ArrayList<>();
		List<Integer> resList = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			// 注意！存放当前层最大值
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				// 注意:更新最大值
				max = Math.max(max, node.val);
				if(node.left != null) queue.offer(node.left);
				if(node.right != null) queue.offer(node.right);
			}
			resList.add(max);
		}
		return resList;
	}

	//------------------下面是递归法---------------------

	private List<Integer> resList = new ArrayList<>();

	public List<Integer> largestValues2(TreeNode root) {
		dfs(root, 0);
		return resList;
	}

	// 递归方法：整体是先序遍历的模板
	public void dfs(TreeNode root, int level) {
		// Base case
		if (root == null) return;
		// 如果当前的结点所在的层是新的层，则添加当前值到列表中作为最大值
		if (resList.size() <= level) {
			resList.add(root.val);
			// 否则是已经遍历过的层，获取已有的记录并判断是否要更新数据
		} else {
			resList.set(level, Math.max(resList.get(level), root.val));
		}
		// 递归左右子树
		dfs(root.left, level + 1);
		dfs(root.right, level + 1);
	}

}
