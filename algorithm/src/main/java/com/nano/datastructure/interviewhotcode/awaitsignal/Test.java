package com.nano.datastructure.interviewhotcode.awaitsignal;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过 Lock 实现生产者与消费者
 * 资源类：将公共的资源放在一个单独的类中，可以将其看做一个产品，自身就就有生产和消费的能力（方法）
 *
 * @author: nano
 * @time: 2020/8/3 11:35
 */
public class Test {

	public static void main(String[] args) {
		Resouce resouce = new Resouce();
		// 生产者线程
		new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				resouce.product();
			}
		}, "生产者").start();

		// 消费者线程
		new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				resouce.consumer();
			}
		}, "消费者").start();
	}


}
//资源类
