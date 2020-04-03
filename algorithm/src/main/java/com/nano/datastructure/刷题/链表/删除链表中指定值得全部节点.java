package com.nano.datastructure.刷题.链表;

/**
 * 给定一个值删除链表中所有含有这个值得节点
 * @author nano
 */
public class 删除链表中指定值得全部节点 {

    public static Node removeNode(Node head, int target) {
        // 找第一个不为target的结点作为新的头结点
        while (head != null) {
            if (head.value != target) {
                break;
            }
            head = head.next;
        }

        Node pre = head;
        Node cur = head;
        while (cur != null) {
            // 当相等时进行删除
            if (cur.value == target) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

}
