package com.nano.datastructure.刷题.字符串;

/**
 * @author: nano
 * @time: 2020/7/8 20:13
 */
public class Q125验证回文字符串 {

	public boolean isPalindrome(String s) {
		StringBuffer sgood = new StringBuffer();
		int length = s.length();
		for (int i = 0; i < length; i++) {
			char ch = s.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				sgood.append(Character.toLowerCase(ch));
			}
		}
		StringBuffer sgoodRev = new StringBuffer(sgood).reverse();
		return sgood.toString().equals(sgoodRev.toString());
	}


	/**
	 * 双指针法
	 */
	public boolean isPalindrome2(String s) {
		StringBuffer buffer = new StringBuffer();
		int length = s.length();
		// 转换大小写
		for (int i = 0; i < length; i++) {
			char ch = s.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				buffer.append(Character.toLowerCase(ch));
			}
		}
		int n = buffer.length();
		// 双指针
		int left = 0, right = n - 1;
		while (left < right) {
			if (Character.toLowerCase(buffer.charAt(left)) != Character.toLowerCase(buffer.charAt(right))) {
				return false;
			}
			// 移动指针
			++left;
			--right;
		}
		return true;
	}


	/**
	 * 双指针2
	 */
	public  boolean isPalindrome3(String str) {
		if (str.length() == 0) return true;
		int left = 0, right = str.length() - 1;
		// 从头和尾开始向中间遍历
		while (left < right) {
			// 字符不是字母和数字的情况
			if (!Character.isLetterOrDigit(str.charAt(left))) {
				left++;
				// 字符不是字母和数字的情况
			} else if (!Character.isLetterOrDigit(str.charAt(right))) {
				right--;
			} else {
				// 判断二者是否相等
				if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right)))
					return false;
				left++;
				right--;
			}
		}
		return true;
	}


}
