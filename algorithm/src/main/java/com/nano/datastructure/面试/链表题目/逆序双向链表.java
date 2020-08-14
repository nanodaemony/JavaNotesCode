package com.nano.datastructure.面试.链表题目;

/**
 * @author: nano
 * @time: 2020/8/14 20:14
 */
public class 逆序双向链表 {


	private static DoubleNode reversalList(DoubleNode head) {
		DoubleNode pre = null;
		DoubleNode next;
		while (head != null) {
			next = head.next;
			head.next = pre;
			head.pre = next;
			pre = head;
			head = next;
		}
		return pre;
	}

}
