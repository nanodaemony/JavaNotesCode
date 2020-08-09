package com.nano.datastructure.刷题.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化与反序列化
 * @author nano
 */
public class Q297二叉树的序列化与反序列化 {


    private String deserializeStr;

    // 前序遍历方式序列化
    public String serialize(TreeNode root) {
        if (root == null)
            return "#";
        return root.val + "!" + serialize(root.left) + "!" + serialize(root.right);
    }

    public TreeNode deserialize(String str) {
        deserializeStr = str;
        return deserialize();
    }

    // 反序列化为二叉树
    private TreeNode deserialize() {
        // Base case
        if (deserializeStr.length() == 0) return null;
        // 找到下一个结点的值
        int index = deserializeStr.indexOf(" ");
        String nodeString = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        // 更新原始的反序列化字符串
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
        // 如果是#代表是null值
        if (nodeString.equals("#")) return null;
        int val = Integer.parseInt(nodeString);
        TreeNode root = new TreeNode(val);
        // 递归解析左右子结点
        root.left = deserialize();
        root.right = deserialize();
        // 然后返回自己
        return root;
    }

    //-------------下面是层序方式-------------------
    public String serialize2(TreeNode root) {
        if (root == null) return "";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.append(node.val + "#");
                // 这里即使是null节点也需要加进去
                queue.add(node.left);
                queue.add(node.right);
            } else {
                // 空节点单独序列化
                res.append("null#");
            }
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    public TreeNode deserialize2(String data) {
        if (data.length() == 0) return null;
        // 拆分成结点值
        String[] nums = data.split("#");
        // 构造根结点
        TreeNode root = new TreeNode(Integer.parseInt(nums[0]));
        // 也是利用队列来不断出队列进行设置
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int numIndex = 1;
        while (!queue.isEmpty()) {
            // 弹出根结点
            TreeNode node = queue.poll();
            // 不断设置其左右结点
            if (!"null".equals(nums[numIndex])) {
                node.left = new TreeNode(Integer.parseInt(nums[numIndex]));
                queue.add(node.left);
            }
            numIndex++;
            if (!"null".equals(nums[numIndex])) {
                node.right = new TreeNode(Integer.parseInt(nums[numIndex]));
                queue.add(node.right);
            }
            numIndex++;
        }
        return root;
    }

}
