package com.nano.datastructure.面试.双指针题目;

/**
 * @author: nano
 * @time: 2020/8/26 17:05
 */
public class 反转字符串中的元音字符 {


	public String reverseVowels(String str) {

		if(str == null || str.length() < 2) return str;
		// 左右双指针
		int i = 0;
		int j = str.length() - 1;
		char[] nums = str.toCharArray();
		while (i < j) {
			// 分别找左右边符合条件的字符
			while (i < j && !isMatch(nums[i]) ) i++;
			while (i <= j && !isMatch(nums[j])) j--;
			// 判断越界
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
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
				|| c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
	}

}
