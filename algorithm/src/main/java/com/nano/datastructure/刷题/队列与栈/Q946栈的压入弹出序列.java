package com.nano.datastructure.刷题.队列与栈;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是
 * 某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个
 * 弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class Q946栈的压入弹出序列 {

    public boolean validateStackSequences(int[] pushArray, int[] popArray) {
        // Base case
        if (popArray.length == 0 || pushArray.length == 0) {
            return true;
        }
        // 使用辅助栈
        Stack<Integer> stack = new Stack<>();
        // 出栈数组指针
        int popIndex = 0;

        for (int i = 0; i < pushArray.length; i++) {
            // 不断将入站数组压栈
            stack.push(pushArray[i]);
            // 入栈后判断是否是为空或者栈顶元素是否是等于出栈数组索引处的值
            while (!stack.isEmpty() && stack.peek() == popArray[popIndex]) {
                // 弹出元素
                stack.pop();
                // 更改索引
                popIndex++;
            }
        }
        // 最后只需要判断栈是否为空就行了
        return stack.isEmpty();
    }


}
