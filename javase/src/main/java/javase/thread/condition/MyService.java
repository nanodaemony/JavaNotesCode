package javase.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: nano
 * @time: 2020/8/1 14:39
 */
public class MyService {

	// 实例化一个ReentrantLock对象
	private ReentrantLock lock = new ReentrantLock();
	// 为线程A注册一个ConditionA
	public Condition conditionA = lock.newCondition();
	// 为线程B注册一个ConditionB
	public Condition conditionB = lock.newCondition();

	public void awaitA() {
		try {
			lock.lock();
			System.out.println(Thread.currentThread().getName() + "进入了awaitA方法");
			long timeBefore = System.currentTimeMillis();
			// 执行conditionA等待
			conditionA.await();
			long timeAfter = System.currentTimeMillis();
			System.out.println(Thread.currentThread().getName() + "被唤醒");
			System.out.println(Thread.currentThread().getName() + "等待了: " + (timeAfter - timeBefore) / 1000 + "s");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void awaitB() {
		try {
			lock.lock();
			System.out.println(Thread.currentThread().getName() + "进入了awaitB方法");
			long timeBefore = System.currentTimeMillis();
			// 执行conditionB等待
			conditionB.await();
			long timeAfter = System.currentTimeMillis();
			System.out.println(Thread.currentThread().getName() + "被唤醒");
			System.out.println(Thread.currentThread().getName() + "等待了: " + (timeAfter - timeBefore) / 1000 + "s");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void signallA() {
		try {
			lock.lock();
			System.out.println("启动唤醒程序");
			// 唤醒所有注册conditionA的线程
			conditionA.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public void signallB() {
		try {
			lock.lock();
			System.out.println("启动唤醒程序");
			// 唤醒所有注册conditionB的线程
			conditionB.signalAll();
		} finally {
			lock.unlock();
		}
	}


	public static void main(String[] args) throws InterruptedException {

		MyService service = new MyService();
		// 两个线程
		Runnable runnable1 = new MyServiceThread1(service);
		Runnable runnable2 = new MyServiceThread2(service);

		new Thread(runnable1, "a").start();
		new Thread(runnable2, "b").start();

		// 线程sleep2秒钟
		Thread.sleep(2000);
		// 唤醒所有持有conditionA的线程
		service.signallA();

		Thread.sleep(2000);
		// 唤醒所有持有conditionB的线程
		service.signallB();
	}
}
