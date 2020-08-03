package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/8/1 17:07
 */
public class Q15二进制中1的个数 {

	public int hammingWeight(int num) {
		int res = 0;
		while(num != 0) {
			// 和1相与，结果为1则说明个位为1
			if((num & 1) == 1) res++;
			// 右移直到为0
			num = num >>> 1;
		}
		return res;
	}

	public int hammingWeight3(int n) {
		int cnt = 0;
		while (n != 0) {
			cnt++;
			n &= (n - 1);
		}
		return cnt;
	}


	public int hammingWeight2(int n) {
		return Integer.bitCount(n);
	}



}
