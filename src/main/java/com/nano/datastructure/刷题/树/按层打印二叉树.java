package com.nano.datastructure.刷题.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 将二叉树按照每一层进行打印
 * @author nano
 */
public class 按层打印二叉树 {

    /**
     * 按层打印二叉树
     *
     * @param head 头结点
     */
    public void printByLevel(TreeNode head) {
        if (head == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;
        TreeNode last = head;
        TreeNode nLast = null;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            // 处理数据
            System.out.println(head.value + " ");

            // 加入左右子节点并更新 nLast
            if (head.left != null) {
                queue.offer(head.left);
                nLast = head.left;
            }

            if (head.right != null) {
                queue.offer(head.right);
                nLast = head.right;
            }

            if (head == last && !queue.isEmpty()) {
                // 换行
                System.out.println("\n");
                level++;
                last = nLast;
            }
        }
    }


}
