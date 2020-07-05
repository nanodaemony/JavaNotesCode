package com.nano.datastructure.刷题.树;

/**
 * 二叉树的序列化与反序列化
 * @author nano
 */
public class 二叉树的序列化与反序列化 {


    /**
     * 采用先序遍历方式进行序列化
     *
     * @param head 根节点
     * @return 序列化后的字符串
     */
    public String serializeByPre(TreeNode head) {
        if (head == null) {
            return "#!";
        }
        String res = head.val + "!";
        res = res + serializeByPre(head.left);
        res = res + serializeByPre(head.right);
        return res;
    }


    /**
     * 结点索引
     */
    private int index = -1;

    /**
     * 先序方式反序列化二叉树
     *
     * @param str 字符串
     * @return 序列化后的二叉树
     */
    public TreeNode Deserialize(String str) {
        String[] arr = str.split("!");
        TreeNode treeNode = null;
        index++;
        if(!arr[index].equals("#")) {
            treeNode = new TreeNode(Integer.valueOf(arr[index]));
            treeNode.left = Deserialize(str);
            treeNode.right = Deserialize(str);

        }
        return treeNode;
    }
}
