package com.nano.datastructure.interviewhotcode.waitnotify;

import java.util.LinkedList;

/**
 * @author: nano
 * @time: 2020/8/3 11:33
 */
public class Resource {
	// 最大容量
	private static int MAX_VALUE = 10;
	// 缓存
	LinkedList<String> linkedList = new LinkedList<>();

	/**
	 * 生产者方法
	 */
	public void product() throws Exception {
		// 注意这里是对linkedList加锁，不能对this加锁
		synchronized(linkedList) {
			while(MAX_VALUE == linkedList.size()) {
				System.out.println("仓库已满，【生产者】：暂时不能执行生产任务!");
				linkedList.wait();
			}
			linkedList.push("李四");
			System.out.println("【生产者】：生产了一个产品\t【现仓储量为】:" + linkedList.size());
			linkedList.notifyAll();
		}
	}

	/**
	 * 消费者方法
	 */
	public void customer() throws Exception {
		/*
		 * 根据jdk的void notifyAll()的描述，“解除那些在该对象上调用wait()方法的线程的阻塞状态。该方法只能在同步方法或同步块内部调用。
		 * 如果当前线程不是对象所得持有者，
		 * 该方法抛出一个java.lang.IllegalMonitorStateException 异常”
		 * so我们使用同一把锁
		 */
		synchronized (linkedList) {
			//多线程判断中使用while，不要使用if否则会出现虚假唤醒问题
			while(linkedList.size() == 0) {
				System.out.println("【消费者】：仓库无货，暂时不能执行消费任务!");
				linkedList.wait();
			}
			// 有货则消费
			linkedList.pop();
			System.out.println("【消费者】：消费了一个产品\t【现仓储量为】:" + linkedList.size());
			linkedList.notifyAll();
		}
	}
}
