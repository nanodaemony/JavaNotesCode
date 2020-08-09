package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/8/6 14:15
 */
public class Q56数组中只出现一次的数字I {


	public int[] singleNumbers(int[] nums) {
		int mask = 0;
		// 将数组所有元素进行异或，最后的结果就那两个单一数字的异或结果
		for (int i = 0; i < nums.length; i++) {
			mask = mask ^ nums[i];
		}
		mask = mask & (- mask);
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			//将数组分类。
			if ((nums[i] & mask) == 0) {
				res[0] ^= nums[i];
			} else {
				res[1] ^= nums[i];
			}
		}
		return res;
	}


	public int[] singleNumbers2(int[] nums) {
		// 用于将所有的数异或起来
		int temp = 0;
		for(int num: nums) {
			temp ^= num;
		}
		// 获得k中最低位的1
		int mask = 1;

		// mask = k & (-k) 这种方法也可以得到mask，具体原因百度 哈哈哈哈哈
		while((temp & mask) == 0) {
			mask <<= 1;
		}
		int a = 0;
		int b = 0;

		for(int num: nums) {
			if((num & mask) == 0) {
				a ^= num;
			} else {
				b ^= num;
			}
		}

		return new int[]{a, b};
	}


}
