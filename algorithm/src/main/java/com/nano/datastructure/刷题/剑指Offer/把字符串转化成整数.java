package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/4 16:16
 */
public class 把字符串转化成整数 {



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

}
