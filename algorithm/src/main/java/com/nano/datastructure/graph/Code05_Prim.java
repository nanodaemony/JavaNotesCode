package com.nano.datastructure.graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// undirected graph only
public class Code05_Prim {

	public static class EdgeComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}

	}

	public static Set<Edge> primMST(Graph graph) {
		// 解锁的边进入小根堆
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
		HashSet<Node> set = new HashSet<>();
		// 依次挑选的的边在result里
		Set<Edge> result = new HashSet<>();
		// 随便挑了一个点
		for (Node node : graph.nodes.values()) {
			// node是开始点
			if (!set.contains(node)) {
				// 不在集合的点就加入set
				set.add(node);
				// 将这个点所有相连的边解锁，加入优先级队列
				for (Edge edge : node.edges) {
					priorityQueue.add(edge);
				}

				while (!priorityQueue.isEmpty()) {
					// 弹出解锁的边中，权重最小的边
					Edge edge = priorityQueue.poll();
					// 获取这个边的to结点
					Node toNode = edge.to;
					// 不含有的时候，就是新的点
					if (!set.contains(toNode)) {
						// 记录已经遍历
						set.add(toNode);
						// 含有新的结点的且是权重小的边则加入结果集
						result.add(edge);
						// 将to结点的全部边加入优先级队列中
						for (Edge nextEdge : toNode.edges) {
							priorityQueue.add(nextEdge);
						}
					}
				}
			}
			// break;
		}
		return result;
	}

	// 请保证graph是连通图
	// graph[i][j]表示点i到点j的距离，如果是系统最大值代表无路
	// 返回值是最小连通图的路径之和
	public static int prim(int[][] graph) {
		int size = graph.length;
		int[] distances = new int[size];
		boolean[] visit = new boolean[size];
		visit[0] = true;
		for (int i = 0; i < size; i++) {
			distances[i] = graph[0][i];
		}
		int sum = 0;
		for (int i = 1; i < size; i++) {
			int minPath = Integer.MAX_VALUE;
			int minIndex = -1;
			for (int j = 0; j < size; j++) {
				if (!visit[j] && distances[j] < minPath) {
					minPath = distances[j];
					minIndex = j;
				}
			}
			if (minIndex == -1) {
				return sum;
			}
			visit[minIndex] = true;
			sum += minPath;
			for (int j = 0; j < size; j++) {
				if (!visit[j] && distances[j] > graph[minIndex][j]) {
					distances[j] = graph[minIndex][j];
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println("hello world!");
	}

}
