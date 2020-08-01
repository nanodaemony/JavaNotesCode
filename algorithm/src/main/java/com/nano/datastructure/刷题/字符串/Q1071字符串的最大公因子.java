package com.nano.datastructure.刷题.字符串;

/**
 * @author: nano
 * @time: 2020/7/17 12:36
 */
public class Q1071字符串的最大公因子 {


	public String gcdOfStrings(String str1, String str2) {
		// 假设str1是N个x，str2是M个x，那么str1+str2肯定是等于str2+str1的。
		if (!(str1 + str2).equals(str2 + str1)) {
			return "";
		}
		// 辗转相除法求最大公约数
		return str1.substring(0, gcd(str1.length(), str2.length()));
	}

	private int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

}
