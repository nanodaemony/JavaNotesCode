package com.nano.datastructure.刷题.队列与栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: nano
 * @time: 2020/7/7 12:40
 */
public class Q225用队列实现栈 {


	private Queue<Integer> queue = new LinkedList<>();

	public void push(int x) {
		// 加入到队列中
		queue.add(x);
		// 得到队列的大小
		int size = queue.size();
		// 把前面的元素全部搬运到刚插入的元素的后面
		while (size-- > 1) {
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
