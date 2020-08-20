package com.nano.datastructure.面试.链表题目;

import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/20 16:40
 */
public class 删除链表重复元素 {


	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return head;
		// 建立一个虚拟头结点
		ListNode dummy = new ListNode(-1);
		// 定义一个尾巴,用于尾插法
		ListNode tail = dummy;
		// 引入快慢指针
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null) {
			// 当快指针不为空且快慢指针值相同就持续移动快指针
			while (fast != null && fast.val == slow.val) {
				fast = fast.next;
			}
			// 如果长度为1就使用尾插法将这个结点接到dummy后面
			if (slow.next == fast) {
				// 基本的尾插法
				tail.next = slow;
				tail = slow;
				// 这里记得将尾部的后面置为null
				tail.next = null;
			}
			// 重新将慢指针移动到快指针处
			slow = fast;
		}
		return dummy.next;
	}


}
