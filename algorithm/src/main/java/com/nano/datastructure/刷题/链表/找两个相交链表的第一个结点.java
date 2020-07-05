package com.nano.datastructure.刷题.链表;

/**
 * @author: nano
 * @time: 2020/7/5 13:55
 */
public class 找两个相交链表的第一个结点 {
	/**
	 * 找两个无环链表的第一个相交结点
	 *
	 * @param head1 链表1
	 * @param head2 链表2
	 * @return 相交的节点或null
	 */
	public static ListNode isTwoListMeet(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		// 记录长度
		int length1 = 0;
		int length2 = 0;
		ListNode temp1 = head1;
		ListNode temp2 = head2;
		// 寻找长度 并让temp1和temp2各自到链尾部
		while (temp1.next != null) {
			temp1 = temp1.next;
			length1++;
		}
		while (temp2.next != null) {
			temp2 = temp2.next;
			length2++;
		}
		// 先比较尾部两个指针 如果不相同则肯定不相交
		if (temp1 != temp2) {
			return null;
		}
		// 此处是让temp1时钟指向较长的一根链表 temp2指向较短的链表
		temp1 = (length1 - length2 > 0) ? head1 : head2;
		temp2 = (temp1 == head1) ? head2 : head1;
		// 求两个链表的长度差
		int gap = Math.abs(length1 - length2);
		// 链表长的temp1先走gap步
		while (gap != 0) {
			temp1 = temp1.next;
			gap--;
		}
		// 两个链表同时运动找第一个相同的点
		while (temp1 != temp2) {
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		return temp1;
	}


	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		ListNode head1 = headA;
		ListNode head2 = headB;
		// 两个节点不相交
		while (head1 != head2) {
			if (head1 != null) {
				head1 = head1.next;
			} else {
				head1 = headB;
			}
			if (head2 != null) {
				head2 = head2.next;
			} else {
				head2 = headA;
			}
		}
		if (head1 == null) {
			return null;
		}
		return head1;
	}

}
