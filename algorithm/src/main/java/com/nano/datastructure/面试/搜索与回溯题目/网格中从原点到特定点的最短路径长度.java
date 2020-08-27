package com.nano.datastructure.面试.搜索与回溯题目;

import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

/**
 * @author: nano
 * @time: 2020/8/27 14:10
 */
public class 网格中从原点到特定点的最短路径长度 {

	public int minPathLength(int[][] grids, int tr, int tc) {
		final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		final int m = grids.length, n = grids[0].length;
		// 搜索队列
		Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
		queue.add(new Pair<>(0, 0));
		int pathLength = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			pathLength++;
			while (size-- > 0) {
				Pair<Integer, Integer> cur = queue.poll();
				int cr = cur.getKey(), cc = cur.getValue();
				// 标记已经访问
				grids[cr][cc] = 0;
				for (int[] d : direction) {
					int nr = cr + d[0], nc = cc + d[1];
					if (nr < 0 || nr >= m || nc < 0 || nc >= n || grids[nr][nc] == 0) continue;
					if (nr == tr && nc == tc) {
						return pathLength;
					}
					queue.add(new Pair<>(nr, nc));
				}
			}
		}
		return -1;
	}

}
