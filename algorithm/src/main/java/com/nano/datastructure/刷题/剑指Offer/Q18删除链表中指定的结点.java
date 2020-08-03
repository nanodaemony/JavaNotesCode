package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/8/3 20:00
 */
public class Q18删除链表中指定的结点 {

	public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
		if (head == null || tobeDelete == null) return null;

		// 需要删除的是头结点
		if (head == tobeDelete) {
			return head.next;
		}
		// 要删除的节点不是尾节点
		if (tobeDelete.next != null) {
			// 找到待删结点的下一个结点
			ListNode next = tobeDelete.next;
			// 将下一个结点的值赋给被删的结点
			tobeDelete.val = next.val;
			// 覆盖下一个结点即可
			tobeDelete.next = next.next;

			// 现在说明删除的结点是尾结点
		} else {
			// 持续变量找到尾结点
			ListNode cur = head;
			while (cur.next != tobeDelete)
				cur = cur.next;
			cur.next = null;
		}
		return head;
	}




}
