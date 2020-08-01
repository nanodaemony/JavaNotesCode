package com.nano.datastructure.刷题.位运算;

/**
 * @author: nano
 * @time: 2020/7/24 20:16
 */
public class Q461汉明距离 {

	public int hammingDistance(int x, int y) {
		int res = 0;
		// 两个数字相异或，如果不同就为1
		int num = x ^ y;
		// 下面就是求二进制中1的个数的模板
		while(num != 0) {
			if((num & 1) == 1) res++;
			num = num >>> 1;
		}
		return res;
	}

}
