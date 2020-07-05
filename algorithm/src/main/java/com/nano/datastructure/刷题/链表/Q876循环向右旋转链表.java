package com.nano.datastructure.刷题.链表;

/**
 * @author: nano
 * @time: 2020/7/4 20:54
 */
public class Q876循环向右旋转链表 {

	/**
	 * 连接成环法
	 */
	public ListNode rotateRight(ListNode head, int k) {
		// base cases
		if (head == null) return null;
		if (head.next == null) return head;

		// 将链表合并成环形
		ListNode oldTail = head;
		// n是链表长度
		int n;
		for(n = 1; oldTail.next != null; n++)
			oldTail = oldTail.next;
		// 合并成环
		oldTail.next = head;

		// 找到新的尾部结点: (n - k % n - 1)th node
		// 新的头结点: (n - k % n)th node
		ListNode newTail = head;
		for (int i = 0; i < n - k % n - 1; i++) {
			newTail = newTail.next;
		}
		// 新的头结点
		ListNode newHead = newTail.next;

		// 打开这个环
		newTail.next = null;
		return newHead;
	}

	/**
	 * 取模法
	 */
	public ListNode rotateRight2(ListNode head, int k) {
		// Base case
		if (head == null || k == 0) {
			return head;
		}
		ListNode tmp = head;

		// 求出链表的长度
		int length = 0;
		while (tmp != null) {
			tmp = tmp.next;
			length++;
		}
		// 以len为一个周期
		k = k % length;
		// 说明刚好回到原位置
		if (k == 0) {
			return head;
		}
		// 保存一下头节点
		ListNode node = head;
		// 快慢指针
		tmp = head;
		while (k > 0) {
			k--;
			tmp = tmp.next;
		}
		while (tmp.next != null) {
			head = head.next;
			tmp = tmp.next;
		}
		// 记录next的位置，也就是返回值的头结点
		ListNode res = head.next;
		// 断开连接
		head.next = null;
		// 后一段的末尾指向前一段的开头
		tmp.next = node;
		return res;
	}
}
