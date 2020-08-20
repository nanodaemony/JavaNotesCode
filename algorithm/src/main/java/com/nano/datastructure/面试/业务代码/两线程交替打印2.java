package com.nano.datastructure.面试.业务代码;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: nano
 * @time: 2020/8/15 10:29
 */
public class 两线程交替打印2 {

	// 定义全局锁
	private static ReentrantLock lock = new ReentrantLock();
	// 两个条件
	private static Condition conditionA = lock.newCondition();
	private static Condition conditionB = lock.newCondition();

	private static int counter = 0;

	public static void main(String[] args) {
		Thread thread1 = new Thread(runnable1);
		Thread thread2 = new Thread(runnable2);
		thread1.setPriority(Thread.MAX_PRIORITY);
		thread1.start();
		thread2.start();
	}


	static Runnable runnable1 = new Runnable() {
		@Override
		public void run() {
			for (int i = 0 ; i < 10 ; i ++){
				try {
					lock.lock();
					System.out.println(counter++);
					// 打印完之后A等待B唤醒
					conditionA.await();
					conditionB.signal();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
			}
		}
	};


	static Runnable runnable2 = new Runnable() {
		@Override
		public void run() {
			for (int i = 0 ; i < 10 ; i ++){
				try {
					lock.lock();
					System.out.println(counter++);
					// 打印完之后A唤醒B等待
					conditionA.signal();
					conditionB.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
			}
		}
	};


}
