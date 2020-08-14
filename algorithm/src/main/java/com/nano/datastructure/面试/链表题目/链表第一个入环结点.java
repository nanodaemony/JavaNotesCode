package com.nano.datastructure.面试.链表题目;

/**
 * @author: nano
 * @time: 2020/8/14 20:06
 */
public class 链表第一个入环结点 {


	public ListNode EntryNodeOfLoop(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		if (fast == null || fast.next == null) return null;
		// 快慢指针移动
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			// 双指针相遇
			if (fast == slow) break;
		}
		// 慢指针重新回到头
		slow = head;
		// 两指针同时移动
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}

}
