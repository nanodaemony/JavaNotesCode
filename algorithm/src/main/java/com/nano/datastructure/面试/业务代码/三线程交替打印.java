package com.nano.datastructure.面试.业务代码;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: nano
 * @time: 2020/8/15 14:39
 */
public class 三线程交替打印 {


	private static int count = 0;
	// 定义全局锁
	private static ReentrantLock lock = new ReentrantLock();
	private static Condition conditionA = lock.newCondition();
	private static Condition conditionB = lock.newCondition();
	private static Condition conditionC = lock.newCondition();

	// 栅栏,用于控制打印多少轮
	private static CountDownLatch countDownLatch = new CountDownLatch(10);

	public static void main(String[] args) {
		Thread thread1 = new Thread(runnable1);
		Thread thread2 = new Thread(runnable2);
		Thread thread3 = new Thread(runnable3);
		thread1.setPriority(Thread.MAX_PRIORITY);
		thread1.start();
		thread2.start();
		thread3.start();
		try {
			// 栅栏在此处等待完成
			countDownLatch.await();
			System.out.println("完成");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static Runnable runnable1 = new Runnable() {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					lock.lock();
					if (count % 3 != 0)
						conditionA.await();
					System.out.print("A");
					count++;
					conditionB.signal();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}
	};

	static Runnable runnable2 = new Runnable() {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					lock.lock();
					if (count % 3 != 1)
						conditionB.await();
					System.out.print("B");
					count++;
					conditionC.signal();// 唤醒条件3
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}
	};

	static Runnable runnable3 = new Runnable() {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					lock.lock();
					if (count % 3 != 2)
						conditionC.await();
					System.out.print("C");
					count++;
					conditionA.signal();// 唤醒条件1
					// 完成一轮则减一
					countDownLatch.countDown();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}
	};


}
