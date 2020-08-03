package com.nano.datastructure.interviewhotcode.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: nano
 * @time: 2020/8/3 11:36
 */
public class BlockProductConsumer {
	public static void main(String[] args) {
		Resource resource = new Resource(new ArrayBlockingQueue(3));
		// 生产者线程
		new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				resource.product();
			}
		}, "生产者").start();

		// 消费者线程
		new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				try {
					resource.consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "消费者").start();

		try {
			TimeUnit.MILLISECONDS.sleep(10);
			resource.stop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


