package com.nano.datastructure.刷题.链表;

/**
 * @author: nano
 * @time: 2020/7/4 20:08
 */
public class Q82删除排序链表中的重复元素II {

	public ListNode deleteDuplicates(ListNode head) {
		// 可能要删掉头结点-引入dummy结点
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		// 维护一个遍历指针
		ListNode cur = dummy;
		// 迭代退出条件
		while (cur.next != null && cur.next.next != null) {
			// 说明有重复
			if (cur.next.val == cur.next.next.val) {
				// 来一个临时节点
				ListNode temp = cur.next;
				// 循环去重 此时temp指向重复元素的最后一个
				while (temp != null && temp.next != null && temp.val == temp.next.val) {
					temp = temp.next;
				}
				// 移动cur进行去重即可
				cur.next = temp.next;
				// 没有重复则移动指针
			} else {
				cur = cur.next;
			}

		}
		return dummy.next;
	}

}
