package com.nano.datastructure.刷题.剑指Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/7/4 13:34
 */
public class 翻转单词顺序列 {

	public String ReverseSentence(String str) {
		int n = str.length();
		char[] chars = str.toCharArray();

		int i = 0, j = 0;
		while (j <= n) {
			if (j == n || chars[j] == ' ') {
				reverse(chars, i, j - 1);
				i = j + 1;
			}
			j++;
		}
		reverse(chars, 0, n - 1);
		return new String(chars);
	}

	private void reverse(char[] c, int i, int j) {
		while (i < j)
			swap(c, i++, j--);
	}

	private void swap(char[] c, int i, int j) {
		char t = c[i];
		c[i] = c[j];
		c[j] = t;
	}

}
