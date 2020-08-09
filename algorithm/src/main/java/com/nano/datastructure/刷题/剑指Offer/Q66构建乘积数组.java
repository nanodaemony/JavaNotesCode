package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/4 16:03
 */
public class Q66构建乘积数组 {

	public int[] constructArr(int[] nums) {
		// Base case
		if(nums.length == 0) return new int[0];
		// nums = [1, 2, 3, 4, 5]
		int[] res = new int[nums.length];
		// res = [1, 0, 0, 0, 0]
		// 初始化
		res[0] = 1;
		// 计算下三角
		for(int i = 1; i < nums.length; i++) {
			res[i] = res[i - 1] * nums[i - 1];
			// res = [1, 1, 2, 6, 24]
		}
		int temp = 1;
		// 计算上三角
		for(int i = nums.length - 2; i >= 0; i--) {
			temp = temp * nums[i + 1];
			res[i] = res[i] * temp;
			// res = [120, 60, 40, 30, 24]
		}
		return res;
	}


}
