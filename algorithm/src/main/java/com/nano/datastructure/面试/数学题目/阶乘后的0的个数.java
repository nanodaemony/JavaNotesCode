package com.nano.datastructure.面试.数学题目;

/**
 * @author: nano
 * @time: 2020/8/26 13:23
 */
public class 阶乘后的0的个数 {

	public int trailingZeroes(int num) {
		int count = 0;
		for (int i = 1; i <= num; i++) {
			int temp = i;
			while (temp > 0) {
				// 计算每个数能够整除5的个数
				if (temp % 5 == 0) {
					count++;
					temp /= 5;
				} else {
					break;
				}
			}
		}
		return count;
	}


}
