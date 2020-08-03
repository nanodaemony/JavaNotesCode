package com.nano.datastructure.interviewhotcode.waitnotify;

/**
 * @author: nano
 * @time: 2020/8/3 11:34
 */
public class Test {

	public static void main(String[] args) {
		// 用一个仓库模拟
		Resource resource = new Resource();
		// 生产者线程
		new Thread(() -> {
			try {
				for (int i = 0; i < 20; i++) {
					Thread.sleep(0);
					resource.product();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();

		// 消费者线程
		new Thread(() -> {
			try {
				Thread.sleep(10);
				for (int i = 0; i < 20; i++) {
					// 消费
					resource.customer();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
	}
}
