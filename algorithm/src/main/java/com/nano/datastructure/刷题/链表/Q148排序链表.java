package com.nano.datastructure.刷题.链表;

/**
 * @author: nano
 * @time: 2020/8/7 21:49
 */
public class Q148排序链表 {


	public ListNode sortList(ListNode head) {
		// Base case
		if(head == null || head.next == null) return head;
		// 使用快慢指针寻找链表中间节点
		ListNode slow, fast;
		slow = head; fast = head.next;
		while(fast != null && fast.next != null){
			head = head.next; fast = fast.next.next;
		}
		fast = head.next; head.next = null;
		// 分治，递归调用
		ListNode slowTemp = sortList(slow);
		ListNode fastTemp = sortList(fast);
		return merge(slowTemp, fastTemp);
	}

	// 归并操作-合并两个排序链表
	ListNode merge(ListNode a, ListNode b){
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		while(a != null && b != null){
			if (a.val < b.val){
				dummy.next = a; dummy = a; a = a.next;
			} else {
				dummy.next = b; dummy = b; b = b.next;
			}
		}
		dummy.next = (a == null) ? b : a;
		return head.next;
	}

}
