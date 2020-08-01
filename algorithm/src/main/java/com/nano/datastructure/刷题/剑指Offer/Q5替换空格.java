package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/30 12:58
 */
public class Q5替换空格 {

	public String replaceSpace(String str) {
		int length = str.length();
		// 直接初始化一个原始长度3倍的数组
		char[] array = new char[length * 3];
		// 记录最后需要多少个字符
		int size = 0;
		for (int i = 0; i < length; i++) {
			char c = str.charAt(i);
			if (c == ' ') {
				array[size++] = '%';
				array[size++] = '2';
				array[size++] = '0';
			} else {
				array[size++] = c;
			}
		}
		return new String(array, 0, size);
	}


	public String replaceSpace2(String str) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				res.append("%20");
			} else {
				res.append(str.charAt(i));
			}
		}
		return res.toString();
	}


}
