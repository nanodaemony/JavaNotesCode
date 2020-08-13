package com.nano.datastructure.刷题.动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/java-pai-xu-ji-he-ha-xi-biao-bing-cha-ji-by-lzhlyl/
 * @author: nano
 * @time: 2020/8/13 15:46
 */
public class 最长连续序列 {


	public int longestConsecutive(int[] nums) {
		if (nums.length == 0) return 0;

		// 记录区间 [left, right]
		Map<Integer, Integer> map = new HashMap<>();
		// 数据全部放入到map中
		for (int left : nums) map.put(left, left);

		int max = 1;
		for (int num : nums) {
			int right = num;
			while (map.containsKey(right + 1))
				// 利用前面已知的右边界，快速找到当前需要的右边界
				right = map.get(right + 1);
			map.put(num, right);
			max = Math.max(max, right - num + 1);
		}
		return max;
	}


}
