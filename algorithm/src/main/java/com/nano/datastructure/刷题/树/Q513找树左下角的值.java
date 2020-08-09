package com.nano.datastructure.刷题.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: nano
 * @time: 2020/7/5 21:24
 */
public class Q513找树左下角的值 {

	/**
	 * 层序遍历BFS
	 */
	public int findBottomLeftValue(TreeNode root) {

		// Base case
		if(root == null) return 0;
		int res = Integer.MAX_VALUE;
		// 根节点入队列
		Queue<TreeNode> queue = new LinkedList<TreeNode>() ;
		queue.add(root);
		// 队列为空时退出循环
		while(queue.size() != 0) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				TreeNode temp = queue.poll();
				// 关键步骤！！记录每一行的第一个数！！！！！！
				if(i == 0) {
					res = temp.val;
				}
				// 将出队结点的左右子节点入队
				if(temp.left != null) queue.add(temp.left);
				if(temp.right != null) queue.add(temp.right);
			}
		}
		return res;
	}


	//----------------下面是递归法-----------------------

	// 最终的结果
	int res = Integer.MIN_VALUE;
	// 当前已经遍历的最深层数
	int deepLevel = 0;

	public int findBottomLeftValue2(TreeNode root) {
		// 从第一层开始
		helper(root, 1);
		return res;
	}

	// 辅助函数：传入根节点以及当前所在的层数
	private void helper(TreeNode root, int level) {
		// Base case
		if(root == null) return;
		// 当第一次当前层大于目前遍历到的最深的层的时候更新数据
		// 由于是先序遍历，所以一定是每行左边第一个节点开启新的一行
		if(level > deepLevel) {
			// 更新最深的层数
			deepLevel = level;
			// 更新res值
			res = root.val;
		}
		// 递归左右子树并深度+1
		helper(root.left, level + 1);
		helper(root.right, level + 1);
	}
}
