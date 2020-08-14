package com.nano.datastructure.面试.链表题目;

/**
 * @author: nano
 * @time: 2020/8/14 20:11
 */
public class 逆序链表 {

	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) return head;
		// 引入dummy结点
		ListNode dummy = new ListNode(0);
		// 使用一个cur表示当前正在反转的结点
		ListNode cur = head;
		// head一直后移
		head = head.next;
		// 先把链表第一个结点放到dummy后面当做反转后的最后一个结点
		dummy.next = cur;
		cur.next = null;
		// 下面就是不断遍历了
		while(head != null) {
			// cur指向头结点
			cur = head;
			// 移动头结点
			head = head.next;
			// 将cur结点插入到dummy结点之后形成新的链表
			cur.next = dummy.next;
			dummy.next = cur;
		}
		return dummy.next;
	}

	public ListNode reverse(ListNode head) {
		// 递归的终止条件 只有一个元素或者无元素返回
		if (head == null || head.next == null) return head;

		ListNode newHead = reverse(head.next);
		// 使用一个temp来保存下一个结点的指针
		ListNode temp = head.next;
		temp.next = head;
		head.next = null;
		return newHead;
	}
}
