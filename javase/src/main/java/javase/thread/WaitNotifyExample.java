package javase.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: nano
 * @time: 2020/8/1 14:33
 */
public class WaitNotifyExample {

	public synchronized void before() {
		System.out.println("before");
		// 唤醒
		notifyAll();
	}

	public synchronized void after() {
		try {
			// 等待
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("after");
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		WaitNotifyExample example = new WaitNotifyExample();
		executorService.execute(() -> example.after());
		// 睡眠1秒
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executorService.execute(() -> example.before());
	}
}
