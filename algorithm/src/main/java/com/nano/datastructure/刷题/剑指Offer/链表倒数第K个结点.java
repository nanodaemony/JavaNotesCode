package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/1 17:04
 */
public class 链表倒数第K个结点 {


	public ListNode FindKthToTail(ListNode head, int k) {
		// Base case
		if (head == null)
			return null;
		ListNode fast = head;
		// 如果链表长度足够则先让fast走K步
		while (fast != null && k-- > 0)
			fast = fast.next;
		// 说明这里链表长度不够
		if (k > 0)
			return null;
		// 再来一个慢指针
		ListNode slow = head;
		// 同时移动直到快指针到链表尾部
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

}
