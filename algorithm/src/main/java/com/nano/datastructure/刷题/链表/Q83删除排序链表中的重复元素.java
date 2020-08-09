package com.nano.datastructure.刷题.链表;

/**
 * @author: nano
 * @time: 2020/7/4 20:07
 */
public class Q83删除排序链表中的重复元素 {

	public ListNode deleteDuplicates(ListNode head) {
		ListNode cur = head;
		while(cur != null && cur.next != null) {
			// 结点值相同则删除重复结点
			if(cur.val == cur.next.val) {
				cur.next = cur.next.next;
				// 结点值不同则直接后移一个结点
			} else {
				cur = cur.next;
			}
		}
		return head;
	}


	/**
	 * 自己写的版本
	 */
	public ListNode deleteDuplicates2(ListNode head) {

		if(head == null || head.next == null) return head;
		// 引入dummy结点
		ListNode dummy = new ListNode(Integer.MAX_VALUE);
		ListNode cur = dummy;

		while (head != null) {
			// 判断当前dummy链表的最后一个结点是否是当前head的值，如果是就忽略，不是就加入这个head结点
			if(cur.val != head.val) {
				cur.next = head;
				head = head.next;
				cur = cur.next;
				// 断开指针
				cur.next = null;
			} else {
				head = head.next;
			}
		}
		return dummy.next;
	}

}
