package com.nano.datastructure.面试.字符串;

/**
 * @author: nano
 * @time: 2020/8/16 22:31
 */
public class 换位字符串 {


	public static boolean isSimilarStr(String str1, String str2) {
		if(str1 == null && str2 == null) return true;
		if ((str1 == null && str2 != null) || (str1 != null && str2 == null)) return false;
		// 记录字符数量的数组
		int[] cnt = new int[256];
		// 记录数量
		for (int i = 0; i < str1.length(); i++) {
			cnt[(int) str1.charAt(i)]++;
		}
		// 减少数量
		for (int i = 0; i < str2.length(); i++) {
			cnt[(int) str2.charAt(i)]--;
		}
		// 只要有一个位置不为0则为false
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] != 0) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isSimilarStr("1123", "321"));
	}

}
