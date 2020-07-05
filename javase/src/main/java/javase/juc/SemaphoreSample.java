package javase.juc;

import java.util.concurrent.Semaphore;

import lombok.Value;

/**
 * 可用于流量控制，限制最大的并发访问数
 *
 * @author cz
 */
public class SemaphoreSample {

	public static void main(String[] args) {
		// 传入访问线程限制数
		Semaphore semaphore = new Semaphore(2);
		for (int i = 0; i < 5; i++) {
			new Thread(new Task(semaphore, "Thread + " + i)).start();
		}
	}

    /**
     * 任务线程
     */
	static class Task extends Thread {

		Semaphore semaphore;

		public Task(Semaphore semaphore, String threadName) {
			this.semaphore = semaphore;
			this.setName(threadName);
		}

		@Override
		public void run() {
			try {
				System.out.println(Thread.currentThread().getName() + "我要获取资源");
			    // 获取公共资源
				semaphore.acquire();
				System.out.println(Thread.currentThread().getName() + ":aquire() at time:" + System.currentTimeMillis());
				Thread.sleep(5000);

                // 释放公共资源
				semaphore.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
