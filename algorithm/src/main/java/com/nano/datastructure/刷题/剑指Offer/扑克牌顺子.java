package com.nano.datastructure.刷题.剑指Offer;

import java.util.Arrays;

/**
 * @author: nano
 * @time: 2020/7/4 14:34
 */
public class 扑克牌顺子 {

	public boolean isStraight(int[] nums) {

		// Base case
		if (nums.length < 5) return false;

		// 先排个序
		Arrays.sort(nums);

		// 统计癞子数量
		int king = 0;
		for (int num : nums)
			if (num == 0) {
				king++;
			}

		int need = 0;
		// 使用癞子去补全不连续的顺子
		for (int i = king; i < nums.length - 1; i++) {
			// 如果前后相同，肯定不行
			if (nums[i + 1] == nums[i]) {
				return false;
			}
			// 如果前后不一致则计算需要多少个King才能补齐
			need = need + (nums[i + 1] - nums[i] - 1);
		}
		// 最后判断king数量是否超标
		return king >= need;
	}

}
