package com.nano.datastructure.刷题.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断是否是完全二叉树
 */
public class Q958判断是否是完全二叉树 {


    /**
     * 判断是否是完全二叉树
     *
     * @param head 头结点
     * @return 是否是完全二叉树
     */
    public boolean isCompleteTree(TreeNode head) {

        if (head == null) return true;
        // 使用队列来进行层序遍历并加入根结点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        // 后面的结点是否必须全为叶子结点的标志
        boolean isLastAllBeLeaf = false;
        // 定义两个节点
        TreeNode leftNode, rightNode;
        while (!queue.isEmpty()) {
            // 弹出节点并进行判断
            head = queue.poll();
            leftNode = head.left;
            rightNode = head.right;

            // 不符合条件直接false
            if ((isLastAllBeLeaf && (leftNode != null || rightNode != null) ||
                    leftNode == null && rightNode != null)) {
                return false;
            }
            if (leftNode != null) {
                queue.offer(leftNode);
            }
            if (rightNode != null) {
                queue.offer(rightNode);
            } else {
                // 遇到第一个不是全有左右子节点的结点 则后面的全部节点必须为叶子结点
                isLastAllBeLeaf = true;
            }
        }
        // 上述没有返回false则为true
        return true;
    }

}
