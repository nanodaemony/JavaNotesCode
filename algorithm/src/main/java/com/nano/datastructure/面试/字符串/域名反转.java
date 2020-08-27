package com.nano.datastructure.面试.字符串;

/**
 * @author: nano
 * @time: 2020/8/21 13:08
 */
public class 域名反转 {

	public static String reverseWords(String str) {
		int len = str.length();
		char[] chars = str.toCharArray();
		// 先把整体逆序
		reverse(chars, 0, len - 1);
		// 然后不断根据空格找出一个单词,并将这个单词逆序
		int wordStart = 0;
		for (int i = 0; i < str.length(); i++) {
			if(chars[i] == '.') {
				// 当前单词的开始是WordStart,结束是i-1
				reverse(chars, wordStart, i - 1);
				wordStart = i + 1;
			}
		}
		// 反转一下最后一个单词
		reverse(chars, wordStart, len - 1);
		// 返回结果
		return new String(chars);
	}

	// 反转一个字符串
	private static void reverse(char[] nums, int i, int j) {
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	private static void swap(char[] nums, int i, int j) {
		char temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}


	public static void main(String[] args) {
		System.out.println(reverseWords("www.nano.com"));
	}

}
