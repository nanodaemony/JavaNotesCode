package com.nano.datastructure.面试.字符串;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: nano
 * @time: 2020/8/21 14:39
 */
public class 相似字符串 {


	public static boolean isSamiliarStr(String str1, String str2) {

		if(str1 == null || str2 == null) return true;

		if((str1 == null && str2 != null) || (str1 != null && str2 == null)) return false;

		if (str1.length() != str2.length()) return false;

		int misMatchNum = 0;
		Set<Character> misMatchSet = new HashSet<>();
		for (int i = 0; i < str1.length(); i++) {
			if(str1.charAt(i) != str2.charAt(i)) {
				misMatchNum++;
				misMatchSet.add(str1.charAt(i));
				misMatchSet.add(str2.charAt(i));
				if (misMatchNum > 2 || misMatchSet.size() > 2) return false;
			}
		}
		// 说明字符串相同
		if (misMatchNum == 0) return false;
		return true;
	}

}
