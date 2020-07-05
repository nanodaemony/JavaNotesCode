package com.nano.datastructure.刷题.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: nano
 * @time: 2020/7/5 14:54
 */
public class Q429N叉树的层序遍历 {

	public List<List<Integer>> levelOrder(Node root) {
		// Base case
		if(root == null) {
			return new ArrayList();
		}
		// 使用辅助队列并将根节点入队列
		Queue<Node> queue = new LinkedList();
		queue.offer(root);
		List<List<Integer>> resList = new ArrayList();
		// 队列为空退出循环
		while(!queue.isEmpty()) {
			// 记录当前层的结点个数
			int len = queue.size();
			// 记录当前层的结果
			List<Integer> levelList = new ArrayList();
			// 依次弹出当前层结点并将其子节点放入队列中同时处理数据
			for(int i = 0; i < len; i++) {
				// 弹出节点并处理元素
				Node temp = queue.poll();
				levelList.add(temp.val);
				// 将该弹出节点的全部子结点依次加入队列中
				for(Node node : temp.children) {
					queue.offer(node);
				}
			}
			resList.add(levelList);
		}
		return resList;
	}

}
