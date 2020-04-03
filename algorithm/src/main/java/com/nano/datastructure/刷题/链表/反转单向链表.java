package com.nano.datastructure.刷题.链表;

/**
 * 将一个单向链表进行反转后返回
 */
public class 反转单向链表 {

    /**
     * 反转单向链表
     *
     * 方法是不断把后面的指针往前面指
     * @param head 原链表头部
     * @return 反转之后的链表
     */
    public Node reverseList(Node head) {

        Node pre = null;
        Node next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
