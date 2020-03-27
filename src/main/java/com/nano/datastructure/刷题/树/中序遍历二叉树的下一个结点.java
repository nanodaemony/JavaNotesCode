package com.nano.datastructure.刷题.树;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class 中序遍历二叉树的下一个结点 {


    /**
     * 找一个结点的后继节点
     *
     * @param node 给定结点
     * @return 后继节点
     */
    public TreeLinkNode getNextNode(TreeLinkNode node) {

        if (node == null) {
            return null;
        }
        // 有右子树则找右子树的最左的结点
        if (node.right != null) {
            return getLeftMost(node.right);

            // 无右子树看当前节点是不是其父节点的左孩子，如果是则父节点就是后继节点
            // 如果不是就持续向上，直到某个结点是其父节点的左孩子为止（注意寻找到了根节点）
        } else {
            TreeLinkNode parent = node.parent;
            // 当不是父节点的左子节点时不断往上找
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }

    }

    // 找最左的结点
    private TreeLinkNode getLeftMost(TreeLinkNode node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        // 父节点指针
        TreeLinkNode parent = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }


}


