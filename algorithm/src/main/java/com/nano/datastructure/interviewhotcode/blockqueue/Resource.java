package com.nano.datastructure.interviewhotcode.blockqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: nano
 * @time: 2020/8/3 16:00
 */
public class Resource {
	// 标记while无限循环
	private volatile boolean FLAG = true;
	// 队列中存入的数值
	private AtomicInteger atomicInteger = new AtomicInteger();
	// 组合一个阻塞队列，通过构造器传入
	private BlockingQueue blockingQueue;

	public Resource(BlockingQueue blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	// 生产者
	public void product() {
		try {
			while (FLAG) {
				blockingQueue.put(String.valueOf(atomicInteger.incrementAndGet()));
				System.out.println("生产者生产第" + blockingQueue.size() + "个产品");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 消费者
	public void consumer() throws InterruptedException {
		while (FLAG) {
			blockingQueue.take();
			System.out.println("消费者消费第" + (blockingQueue.size() + 1) + "个产品");
		}
	}

	public void stop() {
		FLAG = false;
		System.out.println("========================");
	}
}

