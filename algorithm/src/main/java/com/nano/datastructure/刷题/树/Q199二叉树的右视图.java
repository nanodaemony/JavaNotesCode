package com.nano.datastructure.刷题.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: nano
 * @time: 2020/7/5 15:09
 */
public class Q199二叉树的右视图 {


	public List<Integer> rightSideView(TreeNode root) {
		// Base case
		if(root == null) return new ArrayList<>();
		// 使用队列来操作并将根节点入队列
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		List<Integer> resList = new ArrayList<>();
		while(!queue.isEmpty()) {
			// 得到当前层的元素个数
			int size = queue.size();
			// 弹出当前层的所有元素并将其左右结点入队
			for(int i = 0; i < size; i++) {
				// 弹出节点
				TreeNode node = queue.poll();
				// 注意！当且仅当弹出结点是这一层最后一个,也就是右视图
				if(i == size - 1) resList.add(node.val);
				if(node.left != null) queue.offer(node.left);
				if(node.right != null) queue.offer(node.right);
			}
		}
		return resList;
	}


	// 当前最大层数
	int level = -1;

	List<Integer> resList = new ArrayList<>();
	public List<Integer> rightSideView2(TreeNode root) {
		dfs(root, 0);
		return resList;
	}

	// 辅助方法：传入根节点，层数，结果集
	public void dfs(TreeNode root, int level) {
		// Base case
		if (root == null) return;
		// 代表是新的一层，仅添加一次
		if (level > this.level) {
			this.level = level;
			resList.add(root.val);
		}
		// 先递归右子树
		dfs(root.right, level + 1);
		dfs(root.left, level + 1);
	}

}
