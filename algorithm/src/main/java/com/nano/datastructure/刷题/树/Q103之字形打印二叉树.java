package com.nano.datastructure.刷题.树;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: nano
 * @time: 2020/7/5 15:13
 */
public class Q103之字形打印二叉树 {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		// Base case
		if(root == null) return new ArrayList<>();
		// 使用队列来操作，根节点入队列
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		List<List<Integer>> resList = new ArrayList<>();
		// 当前层是否需要逆序的标志位
		boolean reverseFlag = false;
		while(!queue.isEmpty()) {
			// 得到当前层的元素个数
			int size = queue.size();
			List<Integer> levelList = new ArrayList<>();
			// 依次弹出当前层的全部节点并插入levelList中
			for(int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				levelList.add(node.val);
				// 将左右子节点入队列
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
			}
			// 当一层数据处理完后，判断当前层是单层还是双层，如果是双层则反转数据
			if(reverseFlag) {
				Collections.reverse(levelList);
			}
			reverseFlag = !reverseFlag;
			resList.add(levelList);
		}
		return resList;
	}
}
