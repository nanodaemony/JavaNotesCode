package com.nano.datastructure.面试.链表题目;

/**
 * @author: nano
 * @time: 2020/8/20 15:49
 */
public class 两个链表的第一个公共节点 {


	public ListNode FindFirstCommonNode(ListNode head1, ListNode head2) {
		ListNode l1 = head1, l2 = head2;
		// 没有相遇就持续移动
		while (l1 != l2) {
			// 如果l1到了l1的末尾就重新指向head2
			l1 = (l1 == null) ? head2 : l1.next;
			// 如果l2到了l2的末尾就重新指向head1
			l2 = (l2 == null) ? head1 : l2.next;
		}
		return l1;
	}

}
