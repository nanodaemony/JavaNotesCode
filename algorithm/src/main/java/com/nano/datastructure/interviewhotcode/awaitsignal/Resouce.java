package com.nano.datastructure.interviewhotcode.awaitsignal;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: nano
 * @time: 2020/8/3 13:04
 */
public class Resouce {

	private int MAX_VALUE = 3;
	private int MIN_VALUE = 0;
	private int number = 0;
	// 显式锁
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	// 生产方法
	public void product() {
		try {
			lock.lock();
			// 如果生产的数量大于最大值则阻塞
			while (number >= MAX_VALUE) {
				System.out.println("【生产者】：当前仓库满了，停止生产");
				condition.await();
			}
			number++;
			System.out.println("【生产者】：生产了一个产品\t【现仓储量为】:" + number);
			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	// 消费方法
	public void consumer() {
		try {
			lock.lock();
			// 如果消费的值=0则阻塞
			while (number <= MIN_VALUE) {
				System.out.println("【消费者】：当前没有产品可以消费");
				condition.await();
			}
			number--;
			System.out.println("【消费者】：消费了一个产品\t【现仓储量为】:" + number);
			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}

