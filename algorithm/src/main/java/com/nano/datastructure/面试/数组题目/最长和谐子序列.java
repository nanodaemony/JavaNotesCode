package com.nano.datastructure.面试.数组题目;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: nano
 * @time: 2020/9/12 22:00
 */
public class 最长和谐子序列 {


	public int findLHS(int[] nums) {
		// 计数的map
		Map<Integer, Integer> cntMap = new HashMap<>();
		// 将全部的元素记录到map中
		for (int num : nums) {
			cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
		}
		int res = 0;
		// 遍历寻找当前元素及其下一个元素(因为和谐序列差值最大为1)
		for (int num : cntMap.keySet()) {
			if (cntMap.containsKey(num + 1)) {
				res = Math.max(res, cntMap.get(num + 1) + cntMap.get(num));
			}
		}
		return res;
	}

}
