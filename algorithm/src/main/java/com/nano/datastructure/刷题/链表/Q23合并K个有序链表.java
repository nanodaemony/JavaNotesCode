package com.nano.datastructure.刷题.链表;

/**
 * @author: nano
 * @time: 2020/8/7 16:28
 */
public class Q23合并K个有序链表 {

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode(int x) { val = x; }
	 * }
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;
		return merge(lists, 0, lists.length - 1);
	}
	// 合并从left到right区间内的链表
	private ListNode merge(ListNode[] lists, int left, int right) {
		// 直接返回链表
		if (left == right) return lists[left];
		// 找中间索引
		int mid = left + (right - left) / 2;
		// 分别归并左右
		ListNode l1 = merge(lists, left, mid);
		ListNode l2 = merge(lists, mid + 1, right);
		return mergeTwoLists(l1, l2);
	}

	// 递归合并两条有序数组
	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}


}
