package com.nano.datastructure.面试.链表题目;

/**
 * @author: nano
 * @time: 2020/8/14 20:16
 */
public class K个一组反转链表 {

	public ListNode reverseKGroup(ListNode head, int k) {
		// 由于要操作第一个节点 引入dummy节点
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		// 初始化双指针
		ListNode slow = dummy;
		ListNode fast = dummy;
		while (true) {
			// 让fast遍历到需要翻转的最后一个元素位置
			for (int i = 0; i < k && fast != null; i++) {
				fast = fast.next;
			}
			// 只要fast遍历到了null说明长度不够一次反转直接跳出循环
			if (fast == null) break;
			// 下面就是画图改变指针指向
			// 为了别把链表搞丢，记录一下后面等待反转的链表头结点
			ListNode remainList = fast.next;
			// 定义start指向翻转元素的第一个位置
			ListNode reverseStart = slow.next;
			// 最后一个翻转元素先断链
			fast.next = null;
			// 然后通过翻转方法reverse()后接在slow后面
			slow.next = reverseList(reverseStart);
			// 保持下次循环一致的位置
			reverseStart.next = remainList;
			slow = reverseStart;
			// 反转之后重置指针
			fast = slow;
		}
		return dummy.next;
	}

	// 迭代反转链表的模板
	public ListNode reverseList(ListNode head) {
		// 初始化两个指针指向null
		ListNode pre = null;
		ListNode next = null;

		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

}
