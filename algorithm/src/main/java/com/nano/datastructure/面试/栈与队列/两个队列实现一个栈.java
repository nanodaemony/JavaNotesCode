package com.nano.datastructure.面试.栈与队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: nano
 * @time: 2020/8/14 20:02
 */
public class 两个队列实现一个栈 {


	private Queue<Integer> queue = new LinkedList<>();

	public void push(int x) {
		// 得到当前队列的大小
		int size = queue.size();
		// 加入到队列中
		queue.add(x);
		// 把前面的元素全部搬运到刚插入的元素的后面
		for (int i = 0; i < size; i++) {
			queue.add(queue.poll());
		}
	}

	public int pop() {
		return queue.remove();
	}

	public int top() {
		return queue.peek();
	}

	public boolean empty() {
		return queue.isEmpty();
	}

}
