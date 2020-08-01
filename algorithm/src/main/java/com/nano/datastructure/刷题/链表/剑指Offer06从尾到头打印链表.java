package com.nano.datastructure.刷题.链表;

/**
 * @author: nano
 * @time: 2020/7/29 13:56
 */
public class 剑指Offer06从尾到头打印链表 {

	int[] res;
	int cnt = 0;

	public int[] reversePrint(ListNode head) {
		if(head == null) {return new int[]{};}
		ListNode cur = head;
		// 计算链表结点数
		int counter = 0;
		while(cur != null) {
			counter++;
			cur = cur.next;
		}
		res = new int[counter];
		// 递归打印结果
		process(head);
		return res;
	}

	private void process(ListNode head) {
		if(head == null) return;
		process(head.next);
		res[cnt] = head.val;
		cnt++;
	}

}
