package com.nano.datastructure.刷题.链表;

/**
 * @author: nano
 * @time: 2020/8/7 16:54
 */
public class Q328奇偶链表 {


	public ListNode oddEvenList(ListNode head) {
		if (head == null) return null;
		// 初始化两个dummy结点即可
		ListNode odd = new ListNode(0);
		ListNode even = new ListNode(0);
		ListNode oddCur = odd;
		ListNode evenCur = even;
		int cnt = 1;
		while(head != null) {
			if(cnt % 2 == 1) {
				oddCur.next = head;
				head = head.next;
				oddCur = oddCur.next;
				oddCur.next = null;
			} else {
				evenCur.next = head;
				head = head.next;
				evenCur = evenCur.next;
				evenCur.next = null;
			}
			cnt++;
		}
		// 连接两个链表
		oddCur.next = even.next;
		return odd.next;
	}

}
