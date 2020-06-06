package com.nano.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code03_TopologySort {

	/**
	 * 拓扑排序
	 * @param graph 图
	 * 必须是有向无环图才可以
	 */
	public static List<Node> sortedTopology(Graph graph) {
		// key：某一个node
		// value：剩余的入度
		HashMap<Node, Integer> inMap = new HashMap<>();
		// 入度为0的点，才能进这个队列
		Queue<Node> zeroInQueue = new LinkedList<>();
		// 遍历图的所有节点得到inMap和zeroInQueue
		for (Node node : graph.nodes.values()) {
			// 初始时所有的节点的剩余入度就是其原始入度
			inMap.put(node, node.in);
			// 如果某节点入度为0则加入队列
			if (node.in == 0) {
				zeroInQueue.add(node);
			}
		}
		// 存放拓扑排序的结果，依次加入result
		List<Node> sortResultList = new ArrayList<>();
		// 从入度为0的节点开始排序
		while (!zeroInQueue.isEmpty()) {
			// 弹出一个入度为0的结点并加入结果队列
			Node cur = zeroInQueue.poll();
			sortResultList.add(cur);
			// 变量这个结点的邻居
			for (Node next : cur.nexts) {
				// 变量之后将邻居的剩余入度减1
				inMap.put(next, inMap.get(next) - 1);
				// 当某个结点的剩余入度为0时则放入0入度队列中
				if (inMap.get(next) == 0) {
					zeroInQueue.add(next);
				}
			}
		}
		// 返回排序结果
		return sortResultList;
	}
}
