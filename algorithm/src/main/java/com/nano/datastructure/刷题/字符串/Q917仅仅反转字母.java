package com.nano.datastructure.刷题.字符串;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/7/16 15:56
 */
public class Q917仅仅反转字母 {


	public static String reverseOnlyLetters(String str) {

		if(str == null || str.length() <= 1) return str;

		int i = 0;
		int j = str.length() - 1;
		char[] nums = str.toCharArray();
		while(true) {

			while(true) {
				if(i < j && !isLetter(nums[i])) {
					i++;
				} else {
					break;
				}
			}
			while(true) {
				if(i < j && !isLetter(nums[j])) {
					j--;
				} else {
					break;
				}
			}

			if(i <= j) {
				swap(nums, i, j);
				i++;
				j--;
			}
			if(i >= j) {
				break;
			}
		}
		return new String(nums);
	}

	private static boolean isLetter(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}

	private static void swap(char[] nums, int i, int j) {
		char temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		System.out.println(reverseOnlyLetters("7_28]"));
	}



	public String reverseOnlyLetters2(String str) {
		Stack<Character> letters = new Stack();
		// 将全部字母压栈
		for (char c: str.toCharArray()) {
			if (Character.isLetter(c)) {
				letters.push(c);
			}
		}
		// 构造结果
		StringBuilder ans = new StringBuilder();
		for (char c: str.toCharArray()) {
			// 如果当前是字母就从栈中弹出一个字母进行替换
			if (Character.isLetter(c)) {
				ans.append(letters.pop());
			} else {
				ans.append(c);
			}
		}
		return ans.toString();
	}


}
