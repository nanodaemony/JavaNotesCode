package com.nano.datastructure.刷题.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import lombok.val;

/**
 * 给定一个有序数组，一直其中没有重复值，用这个有序数组生成一颗平衡搜索二叉树
 */
public class 通过有序数组生成平衡搜索二叉树 {

    /**
     * 根据已排序的数组生成平衡搜索二叉树
     *
     * @param sortArr 已排序数组
     * @return 平衡二叉树
     */
    public TreeNode generateBSTTree(int[] sortArr) {
        if (sortArr == null) {
            return null;
        }
        return generate(sortArr, 0, sortArr.length - 1);
    }

    private TreeNode generate(int[] sortArr, int start, int end) {
        if (start > end) {
            return null;
        }
        // 中间位置
        int mid = (start + end) / 2;
        // 构造树及左右子树
        TreeNode head = new TreeNode(sortArr[mid]);
        head.left = generate(sortArr, start, mid - 1);
        head.right = generate(sortArr, mid + 1, end);
        return head;
    }


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode head) {
        if (head == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> resList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            resList.add(head.value);
            if (head.left != null) {
                queue.offer(head.left);
            }
            if (head.right != null) {
                queue.offer(head.right);
            }
        }

        return resList;

    }
}
