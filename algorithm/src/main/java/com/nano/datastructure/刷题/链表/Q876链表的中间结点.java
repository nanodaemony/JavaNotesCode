package com.nano.datastructure.刷题.链表;

/**
 * @author: nano
 * @time: 2020/8/7 20:59
 */
public class Q876链表的中间结点 {

	public ListNode middleNode(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode fast = head.next;
		ListNode slow = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if(fast == null) {
			return slow;
		} else {
			return slow.next;
		}
	}


}
