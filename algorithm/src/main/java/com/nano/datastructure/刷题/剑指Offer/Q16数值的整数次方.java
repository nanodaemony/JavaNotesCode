package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/8/1 17:10
 */
public class Q16数值的整数次方 {

	public double myPow(double base, int power) {
		if (base == 0) return 0;
		long b = power;
		double res = 1.0;
		if (b < 0) {
			base = 1 / base;
			b = -b;
		}
		while (b > 0) {
			if ((b & 1) == 1) res *= base;
			base *= base;
			b >>= 1;
		}
		return res;
	}


	public double Power(double base, int exponent) {
		if (exponent == 0)
			return 1;
		// 如果次方为1，返回原数
		if (exponent == 1)
			return base;
		// 用于记录是否是负次幂
		boolean isNegative = false;
		// 先将负的幂转为正，后面最后再处理
		if (exponent < 0) {
			exponent = -exponent;
			isNegative = true;
		}
		// 递归求答案
		double pow = Power(base * base, exponent / 2);
		// 如果是奇数的情况，那还需要再次乘一波
		if (exponent % 2 != 0)
			pow = pow * base;
		// 处理负幂的情况
		return isNegative ? 1 / pow : pow;
	}


}
