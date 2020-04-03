package com.nano.datastructure.刷题.树;

/**
 * 二叉树中，一个节点可以往上走和往下走，那么从节点A总能走到节点B。
 * 节点A走到节点B的距离为：A走到B最短路径上的节点个数。求一棵二叉树上的最远距离。
 */
public class 整棵二叉树节点间的最大距离问题 {

    /**
     * 找一颗二叉树上结点间的最大距离
     *
     * @param head 头结点
     * @return 最大距离
     */
    public static int getMaxDistance(TreeNode head) {
        return process(head).maxDistance;
    }


    private static ReturnType process(TreeNode head) {
        // Base case
        if (head == null) {
            return new ReturnType(0, 0);
        }
        // 默认从左右子树得到信息
        ReturnType leftData = process(head.left);
        ReturnType rightData = process(head.right);
        // 构造自己的返回信息

        int height = Math.max(leftData.height, rightData.height) + 1;
        int maxDistance = Math.max(leftData.height + rightData.height + 1,
                Math.max(leftData.maxDistance, rightData.maxDistance));

        return new ReturnType(maxDistance, height);
    }

    // 封装返回值
    private static class ReturnType {
        // 以 X 为头结点的树上的最大距离 就是题目需要得
        public int maxDistance;
        // 树高度
        public int height;

        public ReturnType(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }

    }
}
