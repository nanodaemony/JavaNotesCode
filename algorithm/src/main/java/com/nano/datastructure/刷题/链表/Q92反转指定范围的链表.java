package com.nano.datastructure.刷题.链表;

/**
 * @author: nano
 * @time: 2020/7/4 17:25
 */
public class Q92反转指定范围的链表 {

	/**
	 * 迭代法修改指针
	 */
	public ListNode reverseBetween(ListNode head, int start, int end) {
		// 引入dummy结点
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		// cur用于依次遍历这个链表
		ListNode cur = dummy;
		// 找第一部分不用变的 start = 4, end = 6
		for(int i = 0; i < start - 1; i++) {
			cur = cur.next;
		}
		// 记录第一部分不用变化的末尾节点
		ListNode originEnd = cur;
		// 得到需要变得部分的头
		ListNode revBegin = originEnd.next;
		// end - start = 2
		for(int j = 0; j <= end - start; j++) {
			cur = cur.next;
		}
		// 此时p为需要变得部分的末尾，其后面一个结点即为后面不需要变得部分的头结点
		ListNode lastStart = cur.next;
		// 当前cur指向需要反转链表的最后一个节点，此时断开指针
		cur.next = null;
		// 反转链表，经过反转，revBegin已经指向了反转后链表的末尾
		originEnd.next = reverse(revBegin);

		// 连接最后一段不需要变化的部分
		revBegin.next = lastStart;

		return dummy.next;
	}

	// 递归反转链表
	ListNode reverse(ListNode head) {
		if (head.next == null) return head;
		ListNode last = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return last;
	}


}
