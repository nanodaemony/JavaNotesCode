package com.nano.datastructure.刷题.链表;

/**
 * @author: nano
 * @time: 2020/7/4 19:39
 */
public class Q725链表分隔成K个链表 {


	public ListNode[] splitListToParts(ListNode root, int k) {
		int length = 0;
		ListNode head = root;
		// 先求链表长度
		while (head != null) {
			head = head.next;
			length++;
		}
		// 计算可以分成几份
		int cutCount =  length / k;
		// 如果不够分成k份， 则不需要前面几份多分， 否则前面prevCount份每份需要多分一个
		int preCount = length % k;
		ListNode[] resListNodes = new ListNode[k];
		for (int i = 0; i < k; i++) {
			// 一个部分的链表
			ListNode newHead = new ListNode(0);
			ListNode cur = newHead;
			// 判断如果prevCount > 0 ，则当前需要多分一份
			for (int j = 0; j < (preCount <= 0 ? cutCount : cutCount + 1); j++) {
				if (root != null) {
					cur.next = root;
					cur = root;
					root = root.next;
				}
			}
			// 将需要多分的数量减一
			preCount--;
			// 切断前面的节点和后面的联系
			cur.next = null;
			resListNodes[i] = newHead.next;
		}
		return resListNodes;
	}

}
