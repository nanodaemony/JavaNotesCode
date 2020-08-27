package com.nano.datastructure.面试.二分题目;

/**
 * @author: nano
 * @time: 2020/8/27 13:43
 */
public class 大于给定字符的最小字符 {

	public char nextGreatestLetter(char[] letters, char target) {
		int len = letters.length;
		int left = 0, right = len - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			// mid不符合条件,跳过mid
			if (letters[mid] <= target) {
				left = mid + 1;
			} else {
				// 当mid大于target时直接移动right
				right = mid - 1;
			}
		}
		// 如果找不到返回第一个元素
		return left < len ? letters[left] : letters[0];
	}


}
