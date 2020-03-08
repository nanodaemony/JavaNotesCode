package com.nano.datastructure.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 栈与队列互相转换
 * @author nano
 */
public class StackAndQueueConvert {

    /**
     * 两个栈实现一个队列
     */
    public static class TwoStacksQueue {

        private Stack<Integer> stackPush;

        private Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        /**
         * 如数据一直往stackPush栈存
         */
        public void push(int pushInt) {
            stackPush.push(pushInt);
        }


        public int poll() {
            // 都为空报错
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");

                // 如果Pop栈为空则需要将Push栈里面的数据转移到Pop中
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            // Pop栈中数据不为空 则直接弹出数据
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }


    /**
     * 两个队列实现一个栈
     */
    public static class TwoQueuesStack {
        private Queue<Integer> dataQueue;
        private Queue<Integer> helpQueue;

        public TwoQueuesStack() {
            dataQueue = new LinkedList<Integer>();
            helpQueue = new LinkedList<Integer>();
        }

        public void push(int pushInt) {
            dataQueue.add(pushInt);
        }

        public int peek() {
            if (dataQueue.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            while (dataQueue.size() != 1) {
                helpQueue.add(dataQueue.poll());
            }
            int res = dataQueue.poll();
            helpQueue.add(res);
            swap();
            return res;
        }

        public int pop() {
            if (dataQueue.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            while (dataQueue.size() > 1) {
                helpQueue.add(dataQueue.poll());
            }
            int res = dataQueue.poll();
            swap();
            return res;
        }

        private void swap() {
            Queue<Integer> tmp = helpQueue;
            helpQueue = dataQueue;
            dataQueue = tmp;
        }

    }



}
