package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/4 16:16
 */
public class Q20把字符串转化成整数 {


	public int strToInt(String str) {
		// 去掉开头为空格的情况
		str = str.trim();
		if (str.length() == 0) {
			return 0;
		}
		// 存放结果
		int res = 0;
		// 负数标志位
		int negativeFlag = 1;
		// 如果是+号或者-号开头的情况
		if (str.charAt(0) == '+' || str.charAt(0) == '-') {
			if (str.charAt(0) == '-') {
				negativeFlag = -1;
			}
			// 如果是负数则取正数的部分
			str = str.substring(1);
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				// 得到当前位置的数字
				int temp = str.charAt(i) - '0';
				// 这是说明超标了
				if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp > 7)) {
					// 返回超标的统一结果
					return negativeFlag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				}
				// 否则继续累积结果
				res = res * 10 + temp;
			} else {
				// 出现非法字符直接退出
				break;
			}
		}
		// 计算结果与负数标志位合并
		return res * negativeFlag;
	}

	public boolean isNumber(String s) {
		if (s == null || s.length() == 0) return false;
		// 标记是否遇到数位、小数点、‘e’或'E'
		boolean isNum = false, isDot = false, isCharE = false;
		// 转为字符数组，遍历判断每个字符
		char[] str = s.trim().toCharArray();
		for (int i = 0; i < str.length; i++) {
			// 判断当前字符是否为 0~9 的数位
			if (str[i] >= '0' && str[i] <= '9') {
				isNum = true;
				// 遇到小数点
			} else if (str[i] == '.') {
				// 小数点之前可以没有整数，但是不能重复出现小数点、或出现‘e’、'E'
				if (isDot || isCharE) return false;
				// 标记已经遇到小数点
				isDot = true;
				// 遇到‘e’或'E'
			} else if (str[i] == 'e' || str[i] == 'E') {
				// ‘e’或'E'前面必须有整数，且前面不能重复出现‘e’或'E'
				if (!isNum || isCharE) return false;
				// 标记已经遇到‘e’或'E'
				isCharE = true;
				// 重置isNum，因为‘e’或'E'之后也必须接上整数，防止出现 123e或者123e+的非法情况
				isNum = false;
			} else if (str[i] == '-' || str[i] == '+') {
				if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E')
					// 正负号只可能出现在第一个位置，或者出现在‘e’或'E'的后面一个位置
					return false;
				// 其它情况均为不合法字符
			} else return false;
		}
		return isNum;
	}
}
