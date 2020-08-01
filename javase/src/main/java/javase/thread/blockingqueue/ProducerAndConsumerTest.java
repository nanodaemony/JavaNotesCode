package javase.thread.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: nano
 * @time: 2020/8/1 15:21
 */
public class ProducerAndConsumerTest {
	public static void main(String[] args) throws InterruptedException {
		// 初始化阻塞队列
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);
		// 往生产者和消费者同时传入这个阻塞队列对象
		ProducerThread producerThread1 = new ProducerThread(queue);
		ProducerThread producerThread2 = new ProducerThread(queue);
		ConsumerThread consumerThread1 = new ConsumerThread(queue);
		// 开启线程
		new Thread(producerThread1).start();
		new Thread(producerThread2).start();
		new Thread(consumerThread1).start();
		// 执行2s后，生产者不再生产
		Thread.sleep(2 * 1000);
		producerThread1.stopThread();
		producerThread2.stopThread();

	}
}
