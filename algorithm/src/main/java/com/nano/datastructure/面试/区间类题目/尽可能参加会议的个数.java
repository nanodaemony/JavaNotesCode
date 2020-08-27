package com.nano.datastructure.面试.区间类题目;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author: nano
 * @time: 2020/8/19 21:16
 */
public class 尽可能参加会议的个数 {


	public int maxEvents(int[][] events) {
		// 按照开始时间进行排序
		Arrays.sort(events, (o1, o2) -> o1[0] - o2[0]);
		// 小顶堆
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		// 结果、开始时间、events下标、有多少组数据
		int res = 0, last = 1, i = 0, n = events.length;
		while (i < n || !queue.isEmpty()) {
			// 将start相同的会议都放进堆里
			while (i < n && events[i][0] == last) {
				queue.offer(events[i++][1]);
			}
			// pop掉当前天数之前的
			while (!queue.isEmpty() && queue.peek() < last) {
				queue.poll();
			}
			// 顶上的就是要参加的
			if (!queue.isEmpty()) {
				queue.poll();
				res++;
			}
			last++;
		}
		return res;
	}


	public int maxEvents2(int[][] events) {
		int len = events.length;
		if (len == 1) return 1;
		// 构造一个map, 记录当前是否已经参加会议
		Set<Integer> set = new HashSet<>();
		// 按照结束时间排序, 结束时间相同的开始时间早的在前
		Arrays.sort(events, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});

		// 遍历
		for (int i = 0; i < len; i++) {
			// 如果当天没有参加过会议, 则添加该次会议的开始时间
			if (!set.contains(events[i][0])) {
				set.add(events[i][0]);
			} else {
				// 否则的话遍历结束时间范围
				int start = events[i][0];
				int end = events[i][1];
				while (end > start) {
					start++;
					// 如果在返回内有时间则参加会议, 并break
					if (!set.contains(start)) {
						set.add(start);
						break;
					}
				}
			}
		}
		// 最后返回总共参加了多少会议
		return set.size();
	}




}
