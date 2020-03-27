package com.nano.datastructure.刷题.树;

/**
 * 根据前序与中序遍历结果重构二叉树
 */
public class 重构二叉树 {

    /**
     * 使用前序与中序遍历结果重构二叉树
     *
     * @param preOrder 前序遍历数组
     * @param inOrder 中序遍历数组
     * @return 重构后的二叉树
     */
    public TreeNode reConstructBinaryTree(int preOrder[], int inOrder[]) {
        // 如果前序或者中序有一个是空直接返回
        if (preOrder == null || inOrder == null) {
            return null;
        }
        // 定义构建二叉树的核心算法
        return rebuildBinaryTreeCore(preOrder, 0, preOrder.length - 1,
        inOrder, 0, inOrder.length - 1);
    }


    // 构建二叉树的核心算法
    public TreeNode rebuildBinaryTreeCore(int preOrder[], int startPreOrder,
                                          int endPreOrder, int inOrder[], int startInOrder, int endInOrder) {
        if (startPreOrder > endPreOrder || startInOrder > endInOrder) { // 停止递归的条件
            return null;
        }
        TreeNode root = new TreeNode(preOrder[startPreOrder]);
        for (int i = startInOrder; i <= endInOrder; i++) {
            if (preOrder[startPreOrder] == inOrder[i]) {
                // 其中（i - startInorder）为中序排序中左子树结点的个数
                // 左子树
                root.left = rebuildBinaryTreeCore(preOrder, startPreOrder + 1,
                        startPreOrder + (i - startInOrder), inOrder,
                        startInOrder, i - 1);
                // 右子树
                root.right = rebuildBinaryTreeCore(preOrder, (i - startInOrder)
                                + startPreOrder + 1, endPreOrder, inOrder, i + 1,
                        endInOrder);

            }
        }
        return root;
    }

}
