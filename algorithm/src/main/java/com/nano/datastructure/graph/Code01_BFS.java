package com.nano.datastructure.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Code01_BFS {

	public static void bfs(Node node) {
		// Base case
		if (node == null) return;
		// 使用队列进行遍历
		Queue<Node> queue = new LinkedList<>();
		// 使用Set存储已经遍历的结点
		HashSet<Node> visitedSet = new HashSet<>();
		// 加入头结点
		queue.add(node);
		visitedSet.add(node);
		while (!queue.isEmpty()) {
			// 弹出一个结点
			Node cur = queue.poll();
			// 处理数据
			System.out.println(cur.value);
			// 迭代处理各个没有遍历的结点
			for (Node next : cur.nexts) {
				// 如果没有遍历过则加入队列中
				if (!visitedSet.contains(next)) {
					visitedSet.add(next);
					queue.add(next);
				}
			}
		}
	}

}
