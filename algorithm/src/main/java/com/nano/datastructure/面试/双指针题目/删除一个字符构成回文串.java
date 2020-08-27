package com.nano.datastructure.面试.双指针题目;

/**
 * @author: nano
 * @time: 2020/8/26 17:14
 */
public class 删除一个字符构成回文串 {

	public boolean validPalindrome(String str) {
		if (str == null) return false;
		if (str.length() <= 1) return true;
		int i = 0;
		int j = str.length() - 1;
		while (i <= j) {
			// 如果两个字符相同则逼近指针
			if (str.charAt(i) == str.charAt(j)) {
				i++;
				j--;
				// 遇到不同的,由于只能删除一个字符,所以可以删左边或者右边
			} else {
				// 分别看删左边还是右边,删除之后如果剩下的还是回文就OK,否则就不行
				if (!(isPalindrome(str, i + 1, j) || isPalindrome(str, i, j - 1))) {
					return false;
				} else {
					return true;
				}
			}
		}
		return true;

	}

	private boolean isPalindrome(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i++) != s.charAt(j--)) {
				return false;
			}
		}
		return true;
	}
}
