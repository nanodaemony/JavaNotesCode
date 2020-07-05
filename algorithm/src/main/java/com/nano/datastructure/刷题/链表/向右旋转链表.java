package com.nano.datastructure.刷题.链表;

public class 向右旋转链表 {

    public ListNode rotateRight(ListNode head, int k) {
        // Base case
        if (head == null || k == 0) {
            return head;
        }
        ListNode tmp = head;
        int length = 0;
        // 求出链表的长度
        while (tmp != null) {
            tmp = tmp.next;
            length++;
        }
        k = k % length;  // 以len为一个周期
        if (k == 0) {
            return head;
        }
        // 保存一下头节点
        ListNode listNode = head;
        // 快慢指针
        tmp = head;
        while (k > 0) {
            k--;
            tmp = tmp.next;
        }
        while (tmp.next != null) {
            head = head.next;
            tmp = tmp.next;
        }
        // 记录next的位置，也就是返回值的头结点
        ListNode res = head.next;
        // 断开连接
        head.next = null;
        // 后一段的末尾指向前一段的开头
        tmp.next = listNode;
        return res;
    }
}
