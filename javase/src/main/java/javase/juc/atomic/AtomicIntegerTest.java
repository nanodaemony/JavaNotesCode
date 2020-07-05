package javase.juc.atomic;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicIntegerTest
 * @author cz
 */
public class AtomicIntegerTest {
	static AtomicInteger atomicInteger = new AtomicInteger();
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(() -> atomicInteger.incrementAndGet()).start();
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("自加10次数值：--->" + atomicInteger.get());

		ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(6);
	}

}
