package com.nano.datastructure.刷题.字符串;

/**
 * @author: nano
 * @time: 2020/7/16 19:11
 */
public class Q344反转字符串 {

	public void reverseString(char[] nums) {
		if (nums == null || nums.length < 2) return;
		int i = 0;
		int j = nums.length - 1;
		while (true) {

			swap(nums, i, j);
			i++;
			j--;
			if (i >= j) {
				break;
			}
		}
	}

	private void swap(char[] nums, int i, int j) {
		char temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public void reverseString2(char[] str) {
		int len = str.length;
		char temp;
		for (int i = 0; i < len / 2; i++) {
			temp = str[i];
			str[i] = str[len - 1 - i];
			str[len - 1 - i] = temp;
		}
	}







}
