package com.nano.datastructure.面试.字符串;

/**
 * @author: nano
 * @time: 2020/8/14 22:06
 */
public class 翻转字符串中的单词 {

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


	public String reverseWords2(String str) {
		String emptyStr = " ";
		String[] splits = str.trim().split(emptyStr);
		StringBuilder sb = new StringBuilder();
		//为了后面处理方法统一，先拼接上最后一个单词
		sb.append(splits[splits.length - 1]);
		for (int i = splits.length - 2; i >= 0; i--) {
			if (!splits[i].isEmpty()) {
				sb.append(emptyStr);
				sb.append(splits[i]);
			}
		}
		return sb.toString();
	}

}
