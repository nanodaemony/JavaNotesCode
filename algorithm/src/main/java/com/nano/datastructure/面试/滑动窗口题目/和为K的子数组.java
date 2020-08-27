package com.nano.datastructure.面试.滑动窗口题目;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: nano
 * @time: 2020/8/25 13:08
 */
public class 和为K的子数组 {

	public int subarraySum(int[] nums, int k) {
		// key:前缀和，value:key对应的前缀和的个数
		Map<Integer, Integer> preSumMap = new HashMap<>();

		// 对于下标为0的元素,前缀和为0,个数为1
		preSumMap.put(0, 1);
		// 前缀和
		int preSum = 0;
		int res = 0;
		for (int num : nums) {
			preSum = preSum + num;
			// 先获得前缀和为preSum - k的个数,加到计数变量里
			if (preSumMap.containsKey(preSum - k)) {
				res = res + preSumMap.get(preSum - k);
			}
			// 然后维护preSumMap的定义
			preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
		}
		return res;
	}

}
