package javase.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: nano
 * @time: 2020/7/7 13:32
 */
public class SynchronizedExample {

	public void func1() {
		// 对代码块加锁
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				System.out.print(i + " ");
			}
		}
	}


	public void func2() {
		// 对类对象加锁
		synchronized (SynchronizedExample.class) {
			for (int i = 0; i < 10; i++) {
				System.out.print(i + " ");
			}
		}
	}



	@Test
	public void testLockClass() {
		// 由于是锁住整个类 所以同一个类的两个不同对象也需要等待
		SynchronizedExample e1 = new SynchronizedExample();
		SynchronizedExample e2 = new SynchronizedExample();
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(() -> e1.func2());
		executorService.execute(() -> e2.func2());
	}


	public static void main(String[] args) {
		// 由于同步的是代码块 所以使用两个不同对象的锁不用同步
		SynchronizedExample e1 = new SynchronizedExample();
		SynchronizedExample e2 = new SynchronizedExample();
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(() -> e1.func1());
		executorService.execute(() -> e2.func1());
	}

}
