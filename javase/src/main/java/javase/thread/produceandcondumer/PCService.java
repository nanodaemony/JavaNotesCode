package javase.thread.produceandcondumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: nano
 * @time: 2020/8/1 14:45
 */
public class PCService {
	// 显式锁
	private Lock lock = new ReentrantLock();
	private boolean flag = false;
	// 获取Condition
	private Condition condition = lock.newCondition();
	// 以此为衡量标志
	private int number = 1;

	/**
	 * 生产者生产
	 */
	public void produce() {
		try {
			// 加锁
			lock.lock();
			while (flag == true) {
				// 等待
				condition.await();
			}
			System.out.println(Thread.currentThread().getName() + "-----生产-----");
			number++;
			System.out.println("number: " + number);
			System.out.println();
			flag = true;
			// 提醒消费者消费
			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	/**
	 * 消费者消费生产的物品
	 */
	public void consume() {
		try {
			// 加锁
			lock.lock();
			while (flag == false) {
				condition.await();
			}
			System.out.println(Thread.currentThread().getName() + "-----消费-----");
			number--;
			System.out.println("number: " + number);
			System.out.println();
			flag = false;
			// 提醒生产者生产
			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		PCService service = new PCService();
		Runnable produce = new ProduceThread(service);
		Runnable consume = new ConsumeThead(service);
		new Thread(produce, "生产者  ").start();
		new Thread(consume, "消费者  ").start();
	}
}
