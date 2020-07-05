package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/3 19:15
 */
public class 两个链表的第一个公共结点 {

	public ListNode FindFirstCommonNode(ListNode head1, ListNode head2) {
		ListNode l1 = head1, l2 = head2;
		while (l1 != l2) {
			l1 = (l1 == null) ? head2 : l1.next;
			l2 = (l2 == null) ? head1 : l2.next;
		}
		return l1;
	}

}
