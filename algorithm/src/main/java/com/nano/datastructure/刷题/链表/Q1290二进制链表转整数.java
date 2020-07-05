package com.nano.datastructure.刷题.链表;

/**
 * @author: nano
 * @time: 2020/7/5 14:02
 */
public class Q1290二进制链表转整数 {

	public int getDecimalValue(ListNode head) {
		// 求和
		int sum = 0;
		while(head != null){
			// 每一位都乘2+原来的值
			sum = sum * 2 + head.val;
			head = head.next;
		}
		return sum;
	}

}
