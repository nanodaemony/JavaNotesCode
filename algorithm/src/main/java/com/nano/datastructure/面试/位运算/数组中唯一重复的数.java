package com.nano.datastructure.面试.位运算;

/**
 * @author: nano
 * @time: 2020/8/15 20:21
 */
public class 数组中唯一重复的数 {


	public int findNumber(int[] nums) {

		if(nums == null) return -1;

		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res = res ^ nums[i];
		}
		for (int i = 1; i <= 1000; i++) {
			res = res ^ i;
		}
		return res;
	}

}
