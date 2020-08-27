package com.nano.datastructure.面试.双指针题目;

/**
 * @author: nano
 * @time: 2020/8/26 16:56
 */
public class 两数平方和 {

	public boolean judgeSquareSum(int num) {
		int i = 0, j = (int) Math.sqrt(num);
		while (i <= j) {
			int powSum = i * i + j * j;
			if (powSum == num) {
				return true;
			} else if (powSum > num) {
				j--;
			} else {
				i++;
			}
		}
		return false;
	}

}
