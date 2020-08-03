package com.nano.datastructure.刷题.剑指Offer;

import java.util.Arrays;

/**
 * @author: nano
 * @time: 2020/8/3 19:42
 */
public class Q17打印从1到最大的n位数 {

	char[] number;
	int[] res;
	int counter = 0;

	public int[] printNumbers(int n) {
		if (n <= 0) return new int[]{};
		// 存放结果的数组
		res = new int[(int) Math.pow(10, n) - 1];
		// 初始化一个num数组用于存放每一位
		number = new char[n];
		// 初始digit为0
		dfs(0);
		return res;
	}

	private void dfs(int digit) {
		// 如果digit已经等于位数长度就打印出来
		if (digit == number.length) {
			int num = Integer.parseInt(new String(number));
			if (num != 0) {
				res[counter++] = num;
			}
			return;
		}
		// 递归打印
		for (int i = 0; i < 10; i++) {
			// 增加各个位的值
			number[digit] = (char) (i + '0');
			dfs(digit + 1);
		}
	}

	private void printNumber(char[] number) {
		int index = 0;
		while (index < number.length && number[index] == '0')
			index++;
		while (index < number.length)
			System.out.print(number[index++]);
		System.out.println();
	}


	public static void main(String[] args) {
		Q17打印从1到最大的n位数 n = new Q17打印从1到最大的n位数();
		System.out.println(Arrays.deepToString(new int[][]{n.printNumbers(1)}));
	}



}
