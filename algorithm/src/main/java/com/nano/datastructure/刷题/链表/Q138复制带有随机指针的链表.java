package com.nano.datastructure.刷题.链表;

import java.util.HashMap;

/**
 * 节点除了next指针外还有一个random指针 实现完全克隆
 */
public class Q138复制带有随机指针的链表 {


    /**
     * 使用HashMap复制带有随机指针的节点链表
     *
     * @param head 原头结点
     * @return 复制后的链表
     */
    private static Node copyListWithRandomPointer(Node head) {
        // 使用Map存储原始节点与对应复制后节点的关系
        HashMap<Node, Node> nodeMap = new HashMap<>();

        // 遍历第一次将全部节点放入map中
        Node cur = head;
        while (cur != null) {
            nodeMap.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        // 不断从map中取之前的节点设置副本的关系
        while (cur != null) {
            nodeMap.get(cur).next = nodeMap.get(cur.next);
            nodeMap.get(cur).random = nodeMap.get(cur.random);
            cur = cur.next;
        }
        return nodeMap.get(head);
    }


    public Node copyRandomList2(Node head) {
        // Base case
        if (head == null) return null;
        // 将每个节点复制到下一个结点
        Node cur = head;
        while (cur != null) {
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
        // 复制随机指针
        cur = head;
        while (cur != null) {
            // 随机指针为空的不管
            if (cur.random != null) {
                // 拷贝当前节点的随机指针的指向
                cur.next.random = cur.random.next;
            }
            // 移动两步
            cur = cur.next.next;
        }
        // 将两条链表完全拆分
        cur = head;
        Node copHead = cur.next;
        Node copyCur = copHead;
        while (copyCur.next != null) {
            // 移动原链表指针
            cur.next = cur.next.next;
            cur = cur.next;
            // 移动复制链表指针
            copyCur.next = copyCur.next.next;
            copyCur = copyCur.next;
        }
        // 结束标志null
        cur.next = null;
        return copHead;
    }

    static class Node {
        int val;
        Node next = null;
        Node random = null;

        Node(int label) {
            this.val = label;
        }
    }
}

