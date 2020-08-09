package com.nano.datastructure.刷题.链表;

/**
 * 将一个单向链表进行反转后返回
 */
public class Q206反转单向链表 {

    /**
     * 反转单向链表
     *
     * 方法是不断把后面的指针往前面指
     * @param head 原链表头部
     * @return 反转之后的链表
     */
    public ListNode reverseList(ListNode head) {

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



    public ListNode reverseList2(ListNode head) {
        // null或只有一个结点的情况
        if(head == null || head.next == null) {
            return head;
        }
        // 引入dummy结点
        ListNode dummy = new ListNode(0);
        // 使用一个cur表示当前正在反转的结点
        ListNode cur = head;
        // head一直后移
        head = head.next;
        // 先把链表第一个结点放到dummy后面当做反转后的最后一个结点
        dummy.next = cur;
        cur.next = null;
        // 下面就是不断遍历了
        while(head != null) {
            // cur指向头结点
            cur = head;
            // 移动头结点
            head = head.next;
            // 将cur结点插入到dummy结点之后形成新的链表
            cur.next = dummy.next;
            dummy.next = cur;
        }
        return dummy.next;
    }

}
