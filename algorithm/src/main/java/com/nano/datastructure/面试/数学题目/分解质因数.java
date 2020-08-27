package com.nano.datastructure.面试.数学题目;

import com.nano.datastructure.面试.链表题目.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: nano
 * @time: 2020/8/21 15:26
 */
public class 分解质因数 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("键入一个正整数：");
		int num = s.nextInt();
		// 定义一个最小的质因数
		int k = 2;
		System.out.print(num + "=");
		// 进行循环判断
		while (k <= num) {
			// 如果已经等于n,直接退出
			if (k == num) {
				System.out.print(num);
				break;
			} else if (num % k == 0) {
				System.out.print(k + "*");
				num = num / k;
			} else {
				k++;
			}
		}
	}

	public static List<Integer> getNum(int num) {

		if(num <= 1) return new ArrayList<>();
		List<Integer> resList = new ArrayList<>();

		// 最小质因数,从小变到大
		int k = 2;

		// 进行循环判断
		while (k <= num) {
			// 如果已经等于n,直接退出
			if (k == num) {
				resList.add(k);
				return resList;
			} else if (num % k == 0) {
				resList.add(k);
				num = num / k;
			} else {
				k++;
			}
		}
		return resList;
	}

}
