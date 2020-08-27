package com.nano.datastructure.面试.位运算;

/**
 * @author: nano
 * @time: 2020/8/21 15:06
 */
public class 判断一个数是否是2的幂次方 {

	public boolean isTwoPower(int num) {

		if(num < 1) return false;
		int m = num & (num - 1);
		return m == 0;
	}

}
