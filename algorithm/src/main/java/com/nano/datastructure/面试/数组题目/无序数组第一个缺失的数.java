package com.nano.datastructure.面试.数组题目;

/**
 * @author: nano
 * @time: 2020/8/14 16:20
 */
public class 无序数组第一个缺失的数 {


	public int findLost(int[] nums) {
		// 找到最大值和最小值
		int min = nums[0];
		int max = nums[0];
		for (int value : nums) {
			min = Math.min(min, value);
			max = Math.max(max, value);
		}
		int[] temp = new int[max - min + 1];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = min - 1;
		}
		for (int value : nums) temp[value] = value;
		int i = 0;
		// 找到没有的地方
		while (i < temp.length) {
			if (temp[i] == min - 1) break;
			i++;
		}
		return i;
	}


}
