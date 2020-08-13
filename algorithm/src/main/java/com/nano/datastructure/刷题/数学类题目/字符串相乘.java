package com.nano.datastructure.刷题.数学类题目;

/**
 * @author: nano
 * @time: 2020/8/13 21:58
 */
public class 字符串相乘 {

	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) return "0";
		// 保存计算结果
		String res = "0";

		// num2逐位与num1相乘
		for (int i = num2.length() - 1; i >= 0; i--) {
			int carry = 0;
			// 保存num2第i位数字与num1相乘的结果
			StringBuilder temp = new StringBuilder();
			// 补0
			for (int j = 0; j < num2.length() - 1 - i; j++) {
				temp.append(0);
			}
			int n2 = num2.charAt(i) - '0';

			// num2的第i位数字n2与num1相乘
			for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
				int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
				int product = (n1 * n2 + carry) % 10;
				temp.append(product);
				carry = (n1 * n2 + carry) / 10;
			}
			// 将当前结果与新计算的结果求和作为新的结果
			res = addStrings(res, temp.reverse().toString());
		}
		return res;
	}

	// 下面是字符串相加的模板
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
