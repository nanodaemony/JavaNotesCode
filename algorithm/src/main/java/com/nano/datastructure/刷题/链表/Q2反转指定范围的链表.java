package com.nano.datastructure.刷题.链表;

/**
 * @author: nano
 * @time: 2020/7/4 17:25
 */
public class Q2反转指定范围的链表 {

	/**
	 * 迭代法修改指针
	 */
	public ListNode reverseBetween(ListNode head, int startIndex, int endIndex) {
		// 引入dummy结点
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		// cur用于依次遍历这个链表
		ListNode cur = dummy;
		// 找第一部分不用变的
		for(int i = 0; i < startIndex - 1; i++) {
			cur = cur.next;
		}
		// 记录第一部分不用变化的末尾节点
		ListNode originEnd = cur;
		// 得到需要变得部分的头
		ListNode revBegin = originEnd.next;
		for(int j = 0; j <= endIndex - startIndex; j++) {
			cur = cur.next;
		}
		// 此时p为需要变得部分的末尾，其后面一个结点即为后面不需要变得部分的头结点
		ListNode lastStart = cur.next;
		// 反转链表
		originEnd.next = reverse(revBegin, cur);
		// 连接最后一段不需要变化的部分
		revBegin.next = lastStart;

		return dummy.next;
	}

	// 递归反转链表
	public ListNode reverse(ListNode head, ListNode tail) {
		// Base case
		if(head == tail) {
			return head;
		}
		ListNode cur = reverse(head.next, tail);
		head.next.next = head;
		return cur;
	}

}
