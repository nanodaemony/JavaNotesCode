package com.nano.datastructure.面试.链表题目;

/**
 * @author: nano
 * @time: 2020/8/20 16:24
 */
public class 删除链表倒数第K个结点 {

	public ListNode removeNthFromEnd(ListNode head, int k) {
		// 引入dummy结点
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy;
		ListNode slow = dummy;
		// fast指针先走k步
		for (int i = 1; i <= k + 1; i++) {
			fast = fast.next;
		}
		// 当fast指针到达null时停止
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		// 此时slow指针的下一个结点就是需要删除的结点
		slow.next = slow.next.next;
		return dummy.next;
	}

}
