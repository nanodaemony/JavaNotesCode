package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/8/6 14:51
 */
public class Q58翻转单词顺序列 {


	public String reverseWords(String str) {
		int len = str.length();
		char[] chars = str.toCharArray();
		int i = 0, j = 0;
		while (j <= len) {
			if (j == len || chars[j] == ' ') {
				reverse(chars, i, j - 1);
				i = j + 1;
			}
			j++;
		}
		reverse(chars, 0, len - 1);
		return new String(chars);
	}

	// 仅仅反转一个单词
	private void reverse(char[] c, int i, int j) {
		while (i < j) swap(c, i++, j--);
	}

	private void swap(char[] nums, int i, int j) {
		char temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}



	public String reverseLeftWords2(String s, int n) {
		StringBuilder res = new StringBuilder();
		for(int i = n; i < s.length(); i++)
			res.append(s.charAt(i));
		for(int i = 0; i < n; i++)
			res.append(s.charAt(i));
		return res.toString();
	}

}
