package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/8/6 14:32
 */
public class Q56数组中只出现一次的数字II {

	public int singleNumber(int[] nums) {
		int ones = 0, twos = 0;
		for(int num : nums){
			ones = ones ^ num & ~twos;
			twos = twos ^ num & ~ones;
		}
		return ones;
	}


	public int singleNumber2(int[] nums) {
		int[] counts = new int[32];
		for(int num : nums) {
			for(int j = 0; j < 32; j++) {
				counts[j] = counts[j] + (num & 1);
				num = num >>> 1;
			}
		}
		int res = 0, m = 3;
		for(int i = 0; i < 32; i++) {
			res <<= 1;
			res |= counts[31 - i] % m;
		}
		return res;
	}


}
