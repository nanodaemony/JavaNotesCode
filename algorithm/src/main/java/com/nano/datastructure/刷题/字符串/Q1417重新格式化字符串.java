package com.nano.datastructure.刷题.字符串;

/**
 * @author: nano
 * @time: 2020/7/17 13:40
 */
public class Q1417重新格式化字符串 {

	public String reformat(String str) {
		int charCounter = 0, digitCounter = 0;
		char[] chars = str.toCharArray();
		// 统计数字与字母的个数
		for (char c : chars) {
			int a = c >= '0' && c <= '9' ? charCounter++ : digitCounter++;
		}
		// 数量相差超过1直接返回
		if (Math.abs(charCounter - digitCounter) > 1) {
			return "";
		}
		if (charCounter > digitCounter) {
			charCounter = 0;
			digitCounter = 1;
		} else {
			charCounter = 1;
			digitCounter = 0;
		}
		for (char c : str.toCharArray()) {
			if (c >= '0' && c <= '9') {
				chars[charCounter] = c;
				charCounter += 2;
			} else {
				chars[digitCounter] = c;
				digitCounter += 2;
			}
		}
		return new String(chars);
	}

}
