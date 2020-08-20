package com.nano.datastructure.面试.业务代码;

/**
 * @author: nano
 * @time: 2020/8/15 10:29
 */
public class 两线程交替打印 {

	// 计数器
	private static int count = 0;
	// 弄一个对象锁
	private final static Object lock = new Object();

	static class TurningRunner implements Runnable {
		@Override
		public void run() {
			while (count <= 10) {
				// 获取锁
				synchronized (lock) {
					// 拿到锁就打印
					System.out.println(Thread.currentThread().getName() + ":" + count);
					count++;
					// 唤醒其他线程
					lock.notifyAll();
					try {
						// 如果任务还没有结束，则让出当前的锁并休眠
						if (count <= 10) {
							lock.wait();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread a = new Thread(new TurningRunner(), "偶数");
		Thread b = new Thread(new TurningRunner(), "奇数");
		a.start();
		b.start();
	}

}
