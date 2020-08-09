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
		// 计算每份至少多少个结点
		int everyNum = length / k;
		// 表示前面多少份需要多分一个
		int moreNum = length % k;

		ListNode[] resList = new ListNode[k];
		for (int i = 0; i < k; i++) {
			// 一个部分的链表
			ListNode newHead = new ListNode(0);
			ListNode cur = newHead;
			// 判断如果prevCount > 0 ，则当前需要多分一份
			for (int j = 0; j < (moreNum <= 0 ? everyNum : everyNum + 1); j++) {
				if (root != null) {
					cur.next = root;
					cur = root;
					root = root.next;
				}
			}
			// 将需要多分的数量减一
			moreNum--;
			// 切断前面的节点和后面的联系
			cur.next = null;
			resList[i] = newHead.next;
		}
		return resList;
	}

	public ListNode[] splitListToParts2(ListNode root, int k) {
		int length = 0;
		ListNode head = root;
		// 先求链表长度
		while (head != null) {
			head = head.next;
			length++;
		}
		// 计算每份至少多少个结点
		int everyNum = length / k;
		// 表示前面多少份需要多分一个
		int moreNum = length % k;

		ListNode[] resList = new ListNode[k];
		// 当前是第几轮分配结点
		int cnt = 0;

		while (root != null) {
			// curNum是当前需要分配多少个结点
			int curNum = everyNum;
			// 前面的几个需要多分配一个结点
			if (moreNum != 0) {
				curNum++;
				moreNum--;
			}
			// 往临时结点上不断添加链表
			ListNode tempNode = new ListNode(0);
			ListNode curNode = tempNode;
			while (curNum > 0) {
				curNode.next = root;
				root = root.next;
				curNode = curNode.next;
				curNum--;
			}
			// 与原本的链断开连接
			curNode.next = null;
			resList[cnt] = tempNode.next;
			cnt++;
		}
		return resList;
	}

}
