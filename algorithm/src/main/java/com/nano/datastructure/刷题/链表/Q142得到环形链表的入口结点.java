package com.nano.datastructure.刷题.链表;

/**
 * @author: nano
 * @time: 2020/7/5 13:46
 */
public class Q142得到环形链表的入口结点 {

	public ListNode EntryNodeOfLoop(ListNode head) {
		// Base case
		if (head == null || head.next == null) return null;
		// 两个指针
		ListNode slow = head, fast = head;
		// 快慢指针不相同则各自移动
		do {
			fast = fast.next.next;
			slow = slow.next;
		} while (slow != fast);
		// 此时快慢指针相遇,然后快指针重置到head
		fast = head;
		// 当两个指针不同时各自移动一步
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

}
