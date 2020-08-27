package com.nano.datastructure.面试.数学题目;

/**
 * @author: nano
 * @time: 2020/8/21 14:57
 */
public class 判断丑数 {


	public boolean isUgly(int num) {
		if (num <= 0) return false;
		// 因子列表
		int[] factor = new int[]{2, 3, 5};
		for (int i : factor) {
			// 分别取因子,直到不能整除为止
			while (num % i == 0) {
				num = num / i;
			}
		}
		// 最后看结果是否为1
		if (num == 1) return true;
		return false;
	}


}
