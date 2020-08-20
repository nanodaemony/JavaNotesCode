package com.nano.datastructure.面试.链表题目;

/**
 * @author: nano
 * @time: 2020/8/20 16:58
 */
public class 奇偶链表 {

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
