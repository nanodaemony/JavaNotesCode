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
        boolean isMeetLeaf = false;
        // 定义两个节点
        TreeNode left, right;
        while (!queue.isEmpty()) {
            // 弹出节点并进行判断
            head = queue.poll();
            left = head.left;
            right = head.right;
            // 不符合条件直接false
            if ((isMeetLeaf && (left != null || right != null) ||
                    left == null && right != null)) {
                return false;
            }
            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            } else {
                // 遇到第一个不是全有左右子节点的结点 则后面的全部节点必须为叶子结点
                isMeetLeaf = true;
            }
        }
        // 上述没有返回false则为true
        return true;
    }


    public boolean isCompleteTree2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 两个都为null则直接返回
            if (cur == null && node != null) return false;
            // 滚动更新cur
            cur = node;
            // 把左右都加入queue,null也加入
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return true;
    }

    public boolean isCompleteTree3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isMeetNull = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) isMeetNull = true;

            // 把左右都加入queue,null也加入
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            } else {
                if (isMeetNull) return false;
            }
        }
        return true;
    }

}
