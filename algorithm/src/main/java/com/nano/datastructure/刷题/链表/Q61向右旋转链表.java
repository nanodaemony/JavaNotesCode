package com.nano.datastructure.刷题.链表;

public class Q61向右旋转链表 {

    public ListNode rotateRight(ListNode head, int k) {
        // Base case
        if (head == null || k == 0) return head;
        ListNode cur = head;
        int length = 0;
        // 求出链表的长度
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        // 以len为一个周期
        k = k % length;
        // 刚好回到原处
        if (k == 0) return head;
        // 保存一下头节点
        ListNode listNode = head;
        // cur重新指向head
        cur = head;
        // 先移动K个结点，也就是前面K个会放到链表末尾
        while (k > 0) {
            k--;
            cur = cur.next;
        }
        while (cur.next != null) {
            head = head.next;
            cur = cur.next;
        }
        // 记录next的位置，也就是返回值的头结点
        ListNode res = head.next;
        // 断开连接
        head.next = null;
        // 后一段的末尾指向前一段的开头
        cur.next = listNode;
        return res;
    }
}
