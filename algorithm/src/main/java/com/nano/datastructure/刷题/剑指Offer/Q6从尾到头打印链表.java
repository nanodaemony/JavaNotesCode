package com.nano.datastructure.刷题.剑指Offer;

import java.util.ArrayList;

/**
 * @author: nano
 * @time: 2020/7/30 13:05
 */
public class Q6从尾到头打印链表 {


	ArrayList<Integer> resList = new ArrayList<Integer>();

	public ArrayList<Integer> reversePrint(ListNode head) {
		// 递归打印
		process(head);
		return resList;
	}
	void process(ListNode head) {
		if(head == null) return;
		process(head.next);
		resList.add(head.val);
	}


}
