package com.nano.datastructure.刷题.字符串;

/**
 * @author: nano
 * @time: 2020/7/17 13:20
 */
public class Q345反转字符串中的元音字母 {

	// a e i o u

	public String reverseVowels(String str) {

		if(str == null || str.length() < 2) return str;
		int i = 0;
		int j = str.length();

		char[] nums = str.toCharArray();

		while (i < j) {
			while (i < j && !isMatch(nums[i]) ) {
				i++;
			}

			while (i < j && !isMatch(nums[j])) {
				j--;
			}

			if(i >= j) break;

			swap(nums, i, j);
			i++;
			j--;

		}
		return new String(nums);
	}

	private void swap(char[] nums, int i, int j) {
		char temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private boolean isMatch(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

}
