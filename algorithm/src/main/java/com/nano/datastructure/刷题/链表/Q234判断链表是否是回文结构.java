package com.nano.datastructure.刷题.链表;

import java.util.Stack;

/**
 * 判断单向链表是不是回文结构
 *
 * @author nano
 */
public class Q234判断链表是否是回文结构 {

	/**
	 * 判断单向链表是否是回文结构--使用栈
	 *
	 * @param head 链表头部
	 * @return 是否回文结构
	 */
	private static boolean isPalindromeListUsingStack(ListNode head) {
		if (head == null) {
			return false;
		}
		// 利用栈
		Stack<ListNode> stack = new Stack<>();
		// 将节点全部压栈
		ListNode temp = head;
		while (temp != null) {
			stack.push(temp);
			temp = temp.next;
		}

		// 元素逐个弹出与链表顺序一一比较
		while (head != null) {
			if (head.val != stack.pop().val) {
				return false;
			}
			head = head.next;
		}
		return true;
	}




	public boolean isPalindrome(ListNode head) {

		if (head == null) return true;

		// 找到前半部分的末尾
		ListNode firstHalfEnd = endOfFirstHalf(head);
		// 反转后半部分并得到后半部分开头
		ListNode secondHalfStart = reverseList(firstHalfEnd.next);

		// 挨着检查是否相同
		ListNode l1 = head;
		ListNode l2 = secondHalfStart;
		boolean result = true;
		while (result && l2 != null) {
			if (l1.val != l2.val) result = false;
			l1 = l1.next;
			l2 = l2.next;
		}
		// 注意把后面的半部分逆序回来
		firstHalfEnd.next = reverseList(secondHalfStart);
		return result;
	}

	// Taken from https://leetcode.com/problems/reverse-linked-list/solution/
	private ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}

	// 找到前半部分的末尾
	private ListNode endOfFirstHalf(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}



}
