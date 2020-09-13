package com.nano.datastructure.面试.数学题目;

/**
 * @author: nano
 * @time: 2020/9/13 14:38
 */
public class 判断一个整数是否是回文数 {

	public boolean isPalindrome(int num) {
		if (num == 0) {
			return true;
		}
		if (num < 0 || num % 10 == 0) {
			return false;
		}
		int right = 0;
		while (num > right) {
			right = right * 10 + num % 10;
			num = num / 10;
		}
		return num == right || num == right / 10;
	}

}
