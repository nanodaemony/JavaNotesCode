package com.nano.datastructure.basic;

/**
 * 将一个链表按照小于等于大于一个数排列
 */
public class SmallerEqualBiggerList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 通过将链表全部复制到数组中再串成链表的方法
     *
     * @param head 头结点
     * @param pivot 轴
     */
    public static Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        // 把元素放入数组中
        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for (i = 0; i != nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        // 利用荷兰国旗的思想进行排序
        arrPartition(nodeArr, pivot);
        for (i = 1; i != nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    public static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].value == pivot) {
                index++;
            } else {
                swap(nodeArr, --big, index);
            }
        }
    }

    public static void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

    /**
     * 使用三个辅助节点的方式进行遍历 空间复杂度O(1)
     */
    public static Node listPartition2(Node head, int pivot) {
        Node smallHead = null; // small head
        Node smallTail = null; // small tail
        Node equalHead = null; // equal head
        Node equalTail = null; // equal tail
        Node bigHead = null; // big head
        Node bigTail = null; // big tail
        Node next = null; // save next node
        // 每个节点都被分布到三个子链表下面
        while (head != null) {
            next = head.next;
            // 将head下一个引用置空
            head.next = null;
            // 小于
            if (head.value < pivot) {
                if (smallHead == null) {
                    smallHead = head;
                    smallTail = head;
                } else {
                    smallTail.next = head;
                    smallTail = head;
                }
                // 等于
            } else if (head.value == pivot) {
                if (equalHead == null) {
                    equalHead = head;
                    equalTail = head;
                } else {
                    equalTail.next = head;
                    equalTail = head;
                }
                // 大于
            } else {
                if (bigHead == null) {
                    bigHead = head;
                    bigTail = head;
                } else {
                    bigTail.next = head;
                    bigTail = head;
                }
            }
            head = next;
        }
        // small and equal reconnect
        if (smallTail != null) {
            smallTail.next = equalHead;
            equalTail = equalTail == null ? smallTail : equalTail;
        }
        // all reconnect
        if (equalTail != null) {
            equalTail.next = bigHead;
        }
        return smallHead != null ? smallHead : equalHead != null ? equalHead : bigHead;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);
    }


}
