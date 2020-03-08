package com.nano.datastructure.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * 找链表是否有环以及两个链表相交的问题
 * @author nano
 */
public class FindFirstIntersectNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 找第一个相交的节点
     */
    public static Node getIntersectNode(Node head1, Node head2) {


        if (head1 == null || head2 == null) {
            return null;
        }
        // 得到第一个链表的第一个入环节点
        Node firstEnterLoopNode1 = getLoopNode(head1);
        // 得到第二个链表的第一个入环节点
        Node firstEnterLoopNode2 = getLoopNode(head2);
        // 两个链表都无环
        if (firstEnterLoopNode1 == null && firstEnterLoopNode2 == null) {
            // 就是无环链表的相交问题
            return noLoop(head1, head2);
        }
        // 两个链表都有环的情况 分三种情况
        if (firstEnterLoopNode1 != null && firstEnterLoopNode2 != null) {
            return bothLoop(head1, firstEnterLoopNode1, head2, firstEnterLoopNode2);
        }
        return null;
    }

    /**
     * 通过双指针的方式得到第一个入环的节点
     *
     * @param head 如果存在则返回第一个入环节点，不存在环则返回null
     */
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        // 慢指针一次走1步
        Node n1 = head.next; // n1 -> slow
        // 快指针一次走两步
        Node n2 = head.next.next; // n2 -> fast
        // 一个指针走到底或者直到两个指针相遇退出
        while (n1 != n2) {
            // 如果快指针提前遇到null，则说明肯定无环
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        // 此时肯定有环，快指针到头结点
        n2 = head; // n2 -> walk again from head
        // 快慢指针一次走一步直到两者相遇即为第一个进入环的节点
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    /**
     * 两个无环链表的相交问题
     *
     * @param head1 第一个头结点
     * @param head2 第二个头结点
     */
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        // 此时两个指针到了末尾，如果两个指针不相等，说明一定没有相交
        if (cur1 != cur2) {
            return null;
        }
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * 两个都有环的情况
     *
     * @param head1 第一个链表头结点
     * @param firstEnterLoopNode1 第一个链表中进入环的第一个节点
     * @param head2 第二个链表头结点
     * @param firstEnterLoopNode2 第二个链表中进入环的第一个节点
     * @return 首次相交的节点
     */
    public static Node bothLoop(Node head1, Node firstEnterLoopNode1, Node head2, Node firstEnterLoopNode2) {
        Node cur1 = null;
        Node cur2 = null;
        if (firstEnterLoopNode1 == firstEnterLoopNode2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != firstEnterLoopNode1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != firstEnterLoopNode2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = firstEnterLoopNode1.next;
            while (cur1 != firstEnterLoopNode1) {
                if (cur1 == firstEnterLoopNode2) {
                    return firstEnterLoopNode1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);


        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);
    }

}
