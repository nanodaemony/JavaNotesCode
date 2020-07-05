package com.nano.datastructure.刷题.树;

/**
 * 判断一棵树是否为平衡二叉树（任何结点的左右子树高度都不大于1）
 */
public class Q110判断是否为平衡二叉树 {


    // 记录是否平衡
    private boolean balance = true;

    public boolean isBalanced(TreeNode root) {
        process(root);
        return balance;
    }

    // 树形dp的模板
    private int process(TreeNode root) {
        // 节点为null返回高度为0
        if(root == null) return 0;
        // 获取左右子树的高度信息
        int leftHeight = process(root.left);
        int rightHeight = process(root.right);
        // 利用左右子树的高度信息判断是否平衡
        if(Math.abs(leftHeight - rightHeight) > 1) {
            balance = false;
        }
        // 构造自己的高度信息:即当前节点的最大高度值（同时需要加上自己的高度1）
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
