package com.nano.datastructure.刷题.链表;

/**
 * @author: nano
 * @time: 2020/7/5 12:59
 */
public class Q143重排链表 {

	public void reorderList(ListNode head) {
		// Base case
		if (head == null || head.next == null || head.next.next == null) return;
		// 利用快慢指针找中点，链表分成两部分
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// 断开指针。将链表分成两个部分,newHead为新的链表的头部
		ListNode newHead = slow.next;
		slow.next = null;

		// 第二个链表逆序
		newHead = reverseList(newHead);

		// 链表节点依次交错连接合并
		while (newHead != null) {
			ListNode temp = newHead.next;
			newHead.next = head.next;
			head.next = newHead;
			head = newHead.next;
			newHead = temp;
		}
	}
	// 逆序一个链表
	private ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode tail = head;
		head = head.next;
		tail.next = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = tail;
			tail = head;
			head = temp;
		}
		return tail;
	}

}
