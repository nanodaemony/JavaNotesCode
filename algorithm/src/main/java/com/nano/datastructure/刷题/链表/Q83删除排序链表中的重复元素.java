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

}
