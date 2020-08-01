package javase.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: nano
 * @time: 2020/8/1 14:36
 */
public class AwaitSignalExample {
	// 显式锁
	private Lock lock = new ReentrantLock();
	// 通过lock对象获取Condition对象
	private Condition condition = lock.newCondition();

	public void before() {
		// 在锁范围内使用Condition
		lock.lock();
		try {
			System.out.println("before");
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public void after() {
		lock.lock();
		try {
			// 在此处等待
			condition.await();
			System.out.println("after");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		AwaitSignalExample example = new AwaitSignalExample();
		// 这里是同一个example对象的两个方法，所以用的是同一个锁
		executorService.execute(() -> example.after());
		executorService.execute(() -> example.before());
	}
}
