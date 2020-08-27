package com.nano.datastructure.面试.其他;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: nano
 * @time: 2020/8/26 19:44
 */
public class 出现频率最多的K个元素 {


	public List<Integer> topKFrequent(int[] nums, int k) {
		// 统计全部数字的个数信息
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (int num : nums) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}
		// 构造桶
		List<Integer>[] buckets = new ArrayList[nums.length + 1];
		// 将各个元素放入到桶中
		for (int key : freqMap.keySet()) {
			// 获取这个数的cnt
			int cnt = freqMap.get(key);
			if (buckets[cnt] == null) {
				buckets[cnt] = new ArrayList<>();
			}
			buckets[cnt].add(key);
		}
		List<Integer> resList = new ArrayList<>();

		// 从后往前遍历桶找到K个数
		for (int i = buckets.length - 1; i >= 0 && resList.size() < k; i--) {
			// 说明这个桶位置没有元素
			if (buckets[i] == null) continue;
			if (buckets[i].size() <= (k - resList.size())) {
				resList.addAll(buckets[i]);
			} else {
				resList.addAll(buckets[i].subList(0, k - resList.size()));
			}
		}
		return resList;
	}

}
