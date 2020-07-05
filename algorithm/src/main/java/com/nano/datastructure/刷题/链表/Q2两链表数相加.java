package com.nano.datastructure.刷题.链表;

/**
 * @author: nano
 * @time: 2020/7/5 13:18
 */
public class Q2两链表数相加 {

	public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
		// 引入dummy结点
		ListNode dummy = new ListNode(0);
		ListNode head1 = list1, head2 = list2, cur = dummy;
		// 进位标志
		int carry = 0;
		// 当两链表都为null才退出
		while (head1 != null || head2 != null) {
			// 取链表的值，如果一个已经为null则返回0
			int value1 = (head1 != null) ? head1.val : 0;
			int value2 = (head2 != null) ? head2.val : 0;
			// 带进位值计算和
			int sum = carry + value1 + value2;
			// 再次更新进位
			carry = sum / 10;
			// 生成新的结点
			cur.next = new ListNode(sum % 10);
			// 移动cur
			cur = cur.next;
			// 如果链表不为null还要继续移动指针进行下一轮相加
			if (head1 != null) head1 = head1.next;
			if (head2 != null) head2 = head2.next;
		}
		// 最后还需要再次看看进位标志是否为1
		if (carry > 0) {
			cur.next = new ListNode(carry);
		}
		return dummy.next;
	}

}
