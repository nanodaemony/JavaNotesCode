package com.nano.datastructure.刷题.树;

/**
 * 判断一棵树是否为平衡二叉树（任何结点的左右子树高度都不大于1）
 */
public class 判断是否为平衡二叉树 {


    public boolean isBalanceTree(TreeNode head) {
        return process(head).isBalanced;
    }


    private ReturnType process(TreeNode head) {
        // Base case
        if (head == null) {
            return new ReturnType(true, 0);
        }
        // 默认从左右获取信息
        ReturnType leftData = process(head.left);
        ReturnType rightData = process(head.right);
        // 构造自己返回的信息
        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced
                && Math.abs(leftData.height - rightData.height) < 2;
        return new ReturnType(isBalanced, height);
    }

    // 封装的返回信息
    private static class ReturnType {
        // 是否平衡
        public boolean isBalanced;
        // 高度信息
        public int height;

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

}
