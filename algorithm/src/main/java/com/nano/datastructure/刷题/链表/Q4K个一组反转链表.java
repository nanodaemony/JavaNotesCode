package com.nano.datastructure.刷题.链表;

/**
 * @author: nano
 * @time: 2020/7/4 19:09
 */
public class Q4K个一组反转链表 {


	public ListNode reverseKGroup(ListNode head, int k) {
		// 由于要操作第一个节点 引入dummy节点
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		// 初始化pre与end指针
		ListNode pre = dummy;
		ListNode end = dummy;
		while (end != null) {
			// 让 end 遍历到需要翻转的最后一个元素位置
			for (int i = 0; i < k && end != null; i++) {
				end = end.next;
			}
			// 只要 end 遍历到了 null 直接跳出循环
			if (end == null) {
				break;
			}
			// 下面就是画图改变指针指向
			// 定义 pLast 指向翻转元素后面第一个元素
			ListNode pLast = end.next;
			// 定义 start 指向翻转元素的第一个位置
			ListNode start = pre.next;
			// 最后一个翻转元素先断链
			end.next = null;
			// 然后通过翻转方法 reverse() 后接在 pre 后面
			pre.next = reverseList(start);

			// 保持下次循环一致的位置
			start.next = pLast;
			pre = start;
			end = pre;
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
