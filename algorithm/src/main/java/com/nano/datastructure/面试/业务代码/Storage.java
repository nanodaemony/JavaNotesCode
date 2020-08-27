package com.nano.datastructure.面试.业务代码;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 消费者生产者模型的仓库类
 *
 * @author: nano
 * @time: 2020/8/21 20:23
 */
public class Storage {

	// 仓库最大存储量
	private static final int MAX_SIZE = 10;
	// 仓库存储的队列
	private Queue<String> queue = new LinkedList<>();
	// 锁
	private final Lock lock = new ReentrantLock();
	// 仓库满的条件变量
	private final Condition fullCondition = lock.newCondition();
	// 仓库空的条件变量
	private final Condition emptyCondition = lock.newCondition();

	// 生产者
	public void produce(String good) {
		try {
			// 获得锁
			lock.lock();
			while (queue.size() >= MAX_SIZE) {
				System.out.println("仓库已满");
				// 仓库满了生产者等待,满条件等待
				fullCondition.await();
			}
			// 生产者添加货物
			queue.offer(good);
			System.out.println("生产者:" + Thread.currentThread().getName() + "生产产品,库存:" + queue.size());
			// 解锁空条件
			emptyCondition.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	// 消费者方法
	public void consume() {
		try {
			// 获得锁
			lock.lock();
			while (queue.size() == 0) {
				System.out.println("仓库为空");
				// 达成空条件,等待
				emptyCondition.await();
			}
			// 从队列弹出元素消费
			queue.poll();
			System.out.println("消费者:" + Thread.currentThread().getName() + "消费产品,库存:" + queue.size());
			// 释放掉满条件
			fullCondition.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}


	// 消费者
	static class Producer implements Runnable {
		private Storage storage;

		public Producer(Storage storage) {
			this.storage = storage;
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
					storage.produce("123");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 消费者
	static class Consumer implements Runnable {
		private Storage storage;

		public Consumer(Storage storage) {
			this.storage = storage;
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(3000);
					storage.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		// 注意这里只有一个仓库
		Storage storage = new Storage();
		// 生产者和消费者都往仓库里面放东西,所以传入同一个仓库实例
		Thread p1 = new Thread(new Producer(storage));
		Thread p2 = new Thread(new Producer(storage));
		Thread p3 = new Thread(new Producer(storage));

		Thread c1 = new Thread(new Consumer(storage));
		Thread c2 = new Thread(new Consumer(storage));
		Thread c3 = new Thread(new Consumer(storage));

		p1.start();
		p2.start();
		p3.start();
		c1.start();
		c2.start();
		c3.start();
	}
}

