package com.nano.datastructure.刷题.树;

import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

/**
 * @author: nano
 * @time: 2020/7/5 15:56
 */
public class Q111二叉树的最小深度 {


	public int minDepth(TreeNode root) {
		// Base case
		if(root == null) return 0;
		// 直接获取左边的信息和右边信息
		int minLeft = minDepth(root.left);
		int minRight = minDepth(root.right);
		// 构造自己的返回信息
		if(minLeft != 0 && minRight == 0) {
			return minLeft + 1;
		}
		if(minLeft == 0 && minRight != 0) {
			return minRight + 1;
		}
		// 左右高度较小的+1
		return Math.min(minLeft, minRight) + 1;
	}


	//-----------下面是递归法-------------

	// 记录最小值
	int minDepth = Integer.MAX_VALUE;
	public int minDepth2(TreeNode root) {
		if(root == null) return 0;
		dfs(root, 1);
		return minDepth;
	}

	// 递归-整体先序遍历架构
	private void dfs(TreeNode root, int level) {
		if(root == null) return;
		// 如果当前节点是一个叶子节点就判断是否需要更新最小深度
		if(root.left == null && root.right == null) {
			minDepth = Math.min(minDepth, level);
		}

		dfs(root.left, level + 1);
		dfs(root.right, level + 1);
	}


	/**
	 * 层序遍历实现
	 */
	public int minDepth3(TreeNode root) {

		if(root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		// 注意：记录最低层数的变量
		int minDepth = 0;

		while (!queue.isEmpty()) {
			// 到了新的一层，层数++
			minDepth++;

			int levelSize = queue.size();
			while (levelSize-- > 0) {
				TreeNode node = queue.poll();
				// 如果当前是叶子节点就直接退出
				if (node.left == null && node.right == null) {
					return minDepth;
				}
				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
			}
		}
		return minDepth;
	}

}
