package com.nano.datastructure.刷题.链表;

/**
 * @author: nano
 * @time: 2020/7/4 21:07
 */
public class Q86分隔链表 {

	public ListNode partition(ListNode head, int num) {

		// dummyLess存放小于X的结点，dummyMore存放大于等于X的结点
		ListNode dummyLess = new ListNode(0);
		ListNode less = dummyLess;
		ListNode dummyMore = new ListNode(0);
		ListNode more = dummyMore;

		while (head != null) {
			// 值小于X放在dummyLess下
			if (head.val < num) {
				less.next = head;
				less = less.next;
			} else {
				// 值大于X放在dummyMore下
				more.next = head;
				more = more.next;
			}
			// 移动指针
			head = head.next;
		}

		// 将两个链表连接起来
		more.next = null;
		less.next = dummyMore.next;
		return dummyLess.next;
	}

}
