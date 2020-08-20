package com.nano.datastructure.面试.数组题目;

/**
 * @author: nano
 * @time: 2020/8/20 15:31
 */
public class 除自身以外数组的乘积 {


	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		// 初始化为1
		int p = 1, q = 1;
		// 从左到右遍历
		for (int i = 0; i < nums.length; i++) {
			res[i] = p;
			// p为当前元素左边元素的全部乘积
			p = p * nums[i];
		}
		// 从右往左遍历
		for (int i = nums.length - 1; i > 0; i--) {
			// q为该数右边的全部乘积,且不断更新
			q = q * nums[i];
			// 让i-1位置计算的之前的乘积与i的右边位置的累积相乘
			res[i - 1] = res[i - 1] * q;
		}
		return res;
	}


}
