package com.nano.datastructure.刷题.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: nano
 * @time: 2020/7/5 21:10
 */
public class Q1302层数最深叶子节点的和 {

	/**
	 * 迭代法
	 */
	public int deepestLeavesSum(TreeNode root) {
		// Base case
		if(root == null) return 0;
		// 一层元素的和
		int sum = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>() ;
		// 根节点入队列
		queue.add(root);
		// 队列为空时推退出循环
		while(queue.size() != 0) {
			// 获取当前队列中的元素个数，也就是当前这一层有多少个结点
			int len = queue.size();
			// 将当前层的元素依次出队列并处理数据，每弹出一个结点并再次将其左右子节点入队列
			for(int i = 0; i < len; i++) {
				// 出队列并处理数据
				TreeNode temp = queue.poll();
				// 求这一层的元素之和
				sum = sum + temp.val;
				// 将出队结点的左右子节点入队
				if(temp.left != null) queue.add(temp.left);
				if(temp.right != null) queue.add(temp.right);
			}
			// 判断队列是否还有元素，如果还有说明还没到最后一层，则清空sum
			if(!queue.isEmpty()) {
				sum = 0;
			}
		}
		return sum;
	}

	//--------------下面是递归法---------------------

	// 结点和
	private int sum = 0;

	// 二叉树最大深度
	private int deepLevel = 0;
	public int deepestLeavesSum2(TreeNode root) {
		// 当前深度为0
		helper(root, 0);
		return sum;
	}

	private void helper(TreeNode node, int index){
		// Base case
		if (node == null) return;
		// 当前层等于已经来的深度
		if (index == deepLevel) {
			sum = sum + node.val;
			// 如果有更深的深度则更新sum和最大深度deep
		} else if (index > deepLevel){
			sum = node.val;
			deepLevel = index;
		}
		// 递归左子树和右子树
		helper(node.left, index + 1);
		helper(node.right, index + 1);
	}

}
