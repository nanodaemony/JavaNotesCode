package javase.thread.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: nano
 * @time: 2020/8/1 15:20
 */
class ConsumerThread implements Runnable {
	// 阻塞队列
	private BlockingQueue<String> queue;
	private volatile boolean flag = true;

	public ConsumerThread(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		System.out.println("消费线程启动...");
		try {
			while (flag) {
				System.out.println("消费者,正在从队列中获取数据..");
				// 从阻塞队列获取元素
				String data = queue.poll(2, TimeUnit.SECONDS);
				if (data != null) {
					System.out.println("消费者,拿到队列中的数据data:" + data);
					Thread.sleep(1000);
				} else {
					System.out.println("消费者,超过2秒未获取到数据..");
					flag = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("消费者退出线程...");
		}
	}
}
