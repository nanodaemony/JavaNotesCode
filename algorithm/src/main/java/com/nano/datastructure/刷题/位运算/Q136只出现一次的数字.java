package com.nano.datastructure.刷题.位运算;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: nano
 * @time: 2020/7/24 20:26
 */
public class Q136只出现一次的数字 {

	public int singleNumber(int[] nums) {
		int res = nums[0];
		// 每个数字都做异或运算
		for(int i = 1; i < nums.length; i++) {
			res = res ^ nums[i];
		}
		return res;
	}



}
