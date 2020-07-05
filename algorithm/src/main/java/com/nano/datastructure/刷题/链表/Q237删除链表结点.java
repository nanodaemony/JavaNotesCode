package com.nano.datastructure.刷题.链表;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 *
 * @author: nano
 * @time: 2020/7/4 19:45
 */
public class Q237删除链表结点 {


	public void deleteNode(ListNode node) {
		// 如果为null则抛出异常, 并确保node不是尾节点
		if (node == null || node.next == null) {
			throw new IllegalArgumentException("node should be valid and can not be the tail node");
		}
		// 将node后面结点的值覆盖掉node的值
		node.val = node.next.val;
		// 再将重复的那个结点断链即可
		node.next = node.next.next;
	}

}
