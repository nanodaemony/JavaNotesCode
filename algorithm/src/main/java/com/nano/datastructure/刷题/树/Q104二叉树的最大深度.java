package com.nano.datastructure.刷题.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: nano
 * @time: 2020/7/5 15:54
 */
public class Q104二叉树的最大深度 {

	public int maxDepth(TreeNode root) {
		// Base case
		if(root == null) return 0;
		// 维护一个队列,根节点入队列
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		// 初始化高度为0
		int depth = 0;
		// 循环直到队列为空
		while(!queue.isEmpty()){
			// 高度+1
			depth++;
			// 获取当前队列的尺寸，也就是这一层的元素
			int size = queue.size();
			// 弹出当前这一层的元素，并把其左右子节点放入队列中
			while (size-- > 0){
				// 取队列
				TreeNode node =  queue.poll();
				if(node.left != null) queue.offer(node.left);
				if(node.right != null) queue.offer(node.right);
			}
		}
		return depth;
	}

}
