package com.nano.datastructure.刷题.字符串;

/**
 * @author: nano
 * @time: 2020/7/17 15:35
 */
public class Q551学生出勤记录 {


	public boolean checkRecord(String str) {
		int counter = 0;
		// 统计A的个数
		for (int i = 0; i < str.length(); i++)
			if (str.charAt(i) == 'A') counter++;

		return counter < 2 && !str.contains("LLL");
	}


	public boolean checkRecord2(String str) {
		int counter = 0;
		for (int i = 0; i < str.length() && counter < 2; i++) {
			if (str.charAt(i) == 'A')
				counter++;
			// 直接遍历的时候判断是否有LLL
			if (i <= str.length() - 3 && str.charAt(i) == 'L' && str.charAt(i + 1) == 'L' && str.charAt(i + 2) == 'L')
				return false;
		}

		return counter < 2;
	}


	public static boolean buddyStrings(String strA, String strB) {

		if(strA == null && strB == null) return true;
		if(strA == null || strB == null) return false;
		if(strB.length() != strA.length()) return false;

		int noMatchCounter = 0;
		char[] nums = new char[4];
		int m = 0;
		for(int i = 0; i < strA.length(); i++) {
			if(strA.charAt(i) != strB.charAt(i)) {
				noMatchCounter++;
				if(noMatchCounter > 2) return false;
				nums[m++] = strA.charAt(i);
				nums[m++] = strB.charAt(i);
			}
		}
		if(nums[0] == nums[3] && nums[1] == nums[2]) return true;
		return false;

	}

	public static void main(String[] args) {
		buddyStrings("ab", "ba");
	}

}
