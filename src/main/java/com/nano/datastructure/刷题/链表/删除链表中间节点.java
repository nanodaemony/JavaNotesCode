package com.nano.datastructure.刷题.链表;

/**
 * 删除链表的中间结点
 *
 * 思路：使用快慢双指针进行遍历，快指针走两步，慢指针走一步，快指针到底就是了。
 */
public class 删除链表中间节点 {

    /**
     * 删除链表的中间结点
     *
     * @param head 头结点
     * @return 删除中间结点之后的链表头
     */
    public static Node removeMidNote(Node head) {
        // 只有一个结点和无结点的情况
        if (head == null || head.next == null) {
            return head;
        }

        // 只有两个结点则删除头结点
        if (head.next.next == null) {
            return head.next;
        }
        // 快慢指针
        Node slow = head;
        Node fast = head.next.next;
        // 遍历直到快指针到链表尾部
        while (fast.next != null && fast.next.next != null) {
            // 慢指针走一步 快指针走两步
            slow = slow.next;
            fast = fast.next.next;
        }
        // 删除这个结点
        slow.next = slow.next.next;
        return head;
    }

}
