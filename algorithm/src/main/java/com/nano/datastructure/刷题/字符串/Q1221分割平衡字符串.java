package com.nano.datastructure.刷题.字符串;

import java.util.Arrays;

/**
 * @author: nano
 * @time: 2020/7/16 17:35
 */
public class Q1221分割平衡字符串 {


	public int balancedStringSplit(String str) {
		int counter = 0;
		int res = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'L') {
				counter++;
			} else {
				counter--;
			}
			if (counter == 0) {
				res++;
			}
		}
		return res;
	}




}
