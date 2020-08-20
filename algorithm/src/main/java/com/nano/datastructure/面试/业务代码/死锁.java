package com.nano.datastructure.面试.业务代码;

/**
 * @author: nano
 * @time: 2020/8/15 14:53
 */
public class 死锁 {

	// 定义两个资源
	private static Object resource1 = new Object();
	private static Object resource2 = new Object();

	public static void main(String[] args) {
		new Thread(() -> {
			// 持有资源1
			synchronized (resource1) {
				System.out.println(Thread.currentThread() + "Get resource1");
				try {
					// 这里休眠1秒
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread() + "Waiting get resource2");
				// 等待1秒后才申请资源2
				synchronized (resource2) {
					System.out.println(Thread.currentThread() + "Get resource2");
				}
			}
		}, "线程 1").start();

		new Thread(() -> {
			// 持有资源2
			synchronized (resource2) {
				System.out.println(Thread.currentThread() + "get resource2");
				try {
					// 这里休眠1秒
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread() + "waiting get resource1");
				// 等待1秒后才申请资源1
				synchronized (resource1) {
					System.out.println(Thread.currentThread() + "get resource1");
				}
			}
		}, "线程 2").start();
	}

}
