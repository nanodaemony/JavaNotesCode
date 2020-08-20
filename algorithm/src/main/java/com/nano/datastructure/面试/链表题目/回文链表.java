package com.nano.datastructure.面试.链表题目;

/**
 * @author: nano
 * @time: 2020/8/20 16:29
 */
public class 回文链表 {

	public static boolean isPalindrome(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		// 遍历结束时slow指向的是mid的前一个,这里跟模板有点出入
		ListNode slow = dummy;
		ListNode fast = head;
		while (fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		// 逆序后面的链表
		ListNode head2 = reverse(slow.next);
		// 断开连接
		slow.next = null;
		while (head != null && head2 != null){
			if(head.val != head2.val) return false;
			else{
				head = head.next;
				head2 = head2.next;
			}
		}
		return true;
	}

	// 反转链表
	private static ListNode reverse(ListNode head){
		if(head == null) return null;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = pre.next;
		while (cur.next != null){
			ListNode nex = cur.next;
			cur.next = nex.next;
			nex.next = pre.next;
			pre.next = nex;
		}
		return pre.next;
	}


}
