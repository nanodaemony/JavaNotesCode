package com.nano.datastructure.刷题.链表;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: nano
 * @time: 2020/7/5 13:28
 */
public class Q141判断链表是否有环 {

	/**
	 * 哈希表法
	 */
	public boolean hasCycle(ListNode head) {

		Set<ListNode> nodesSeen = new HashSet<>();
		while (head != null) {
			if (nodesSeen.contains(head)) {
				return true;
			} else {
				nodesSeen.add(head);
			}
			// 遍历指针
			head = head.next;
		}
		return false;
	}


	/**
	 * 快慢指针法
	 */
	public boolean hasCycle2(ListNode head) {
		// Base case
		if (head == null || head.next == null) {
			return false;
		}
		// 初始化时快指针在慢指针之前一步
		ListNode slow = head;
		ListNode fast = head.next;
		// 一直判断指针是否相遇
		while (slow != fast) {
			// 并判断是否已经到头
			if (fast == null || fast.next == null) {
				return false;
			}
			// 否则分别移动两个指针
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}


	public boolean hasCycle3(ListNode head) {
		if(head == null || head.next == null) {
			return false;
		}
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) return true;
		}
		return false;
	}

}
