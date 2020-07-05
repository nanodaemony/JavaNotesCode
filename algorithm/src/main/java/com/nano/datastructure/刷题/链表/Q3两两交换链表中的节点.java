package com.nano.datastructure.刷题.链表;

/**
 * @author: nano
 * @time: 2020/7/4 19:13
 */
public class Q3两两交换链表中的节点 {

	public ListNode swapPairs(ListNode head) {
		// Base case
		if(head == null || head.next == null) {
			return head;
		}
		// 引入dummy与cur结点
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		// 当cur结点后面没有结点或者仅有一个结点停止
		while(cur.next != null && cur.next.next != null) {
			// 这三步进行指针变换
			cur.next = head.next;
			head.next = head.next.next;
			cur.next.next = head;
			// cur往后移动2个结点
			cur = cur.next.next;
			// head移动到cur后面
			head = head.next;
		}
		return dummy.next;
	}

}
