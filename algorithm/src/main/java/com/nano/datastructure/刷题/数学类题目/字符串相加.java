package com.nano.datastructure.刷题.数学类题目;

/**
 * @author: nano
 * @time: 2020/8/13 21:56
 */
public class 字符串相加 {

	public String addStrings(String num1, String num2) {
		StringBuilder res = new StringBuilder();
		// 双指针
		int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
		// 只要有一个不为0即可
		while(i >= 0 || j >= 0){
			int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
			int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
			int tmp = n1 + n2 + carry;
			carry = tmp / 10;
			res.append(tmp % 10);
			i--; j--;
		}
		if(carry == 1) res.append(1);
		// 最后记得逆序
		return res.reverse().toString();
	}


}
