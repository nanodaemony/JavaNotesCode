package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/1 17:29
 */
public class 合并两个有序链表 {

	/**
	 * 递归法合并
	 *
	 * @param list1 链表1
	 * @param list2 链表2
	 * @return 合并后的链表
	 */
	public ListNode Merge(ListNode list1, ListNode list2) {
		// Base case
		if (list1 == null) return list2;
		if (list2 == null) return list1;
		// 根据两个节点的值进行不同的递归操作
		if (list1.val <= list2.val) {
			// 需要设置list1的下一个节点并返回
			list1.next = Merge(list1.next, list2);
			return list1;
		} else {
			list2.next = Merge(list1, list2.next);
			return list2;
		}
	}


	/**
	 * 迭代版本
	 * @param list1 链表1
	 * @param list2 链表2
	 * @return 合并后的链表
	 */
	public ListNode Merge2(ListNode list1, ListNode list2) {
		// 引入dummy节点
		ListNode dummy = new ListNode(-1);
		// cur指针代表当前合并的节点
		ListNode cur = dummy;
		// 两个都不为null才能合并
		while (list1 != null && list2 != null) {
			// 说明list1的节点是需要合并的
			if (list1.val <= list2.val) {
				// 合并到cur后面
				cur.next = list1;
				// list1移动一个
				list1 = list1.next;
			} else {
				cur.next = list2;
				list2 = list2.next;
			}
			// 移动cur指针
			cur = cur.next;
		}
		// 到这里说明其中一个或者两个链表都为null了
		if (list1 != null)
			cur.next = list1;
		if (list2 != null)
			cur.next = list2;
		return dummy.next;
	}


}
