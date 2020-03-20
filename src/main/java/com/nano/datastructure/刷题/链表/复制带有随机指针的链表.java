package com.nano.datastructure.刷题.链表;

import java.util.HashMap;

/**
 * 节点除了next指针外还有一个random指针 实现完全克隆
 */
public class 复制带有随机指针的链表 {


    /**
     * 使用HashMap复制带有随机指针的节点链表
     *
     * @param head 原头结点
     * @return 复制后的链表
     */
    private static RandomListNode copyListWithRandomPointer(RandomListNode head) {
        // 使用Map存储原始节点与对应复制后节点的关系
        HashMap<RandomListNode, RandomListNode> nodeMap = new HashMap<>();

        // 遍历第一次将全部节点放入map中
        RandomListNode cur = head;
        while (cur != null) {
            nodeMap.put(cur, new RandomListNode(cur.value));
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


    static class RandomListNode {
        int value;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.value = label;
        }
    }
}

