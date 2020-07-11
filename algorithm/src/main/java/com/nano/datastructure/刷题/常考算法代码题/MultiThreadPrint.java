package com.nano.datastructure.刷题.常考算法代码题;

import org.junit.runner.RunWith;

/**
 * 多线程打印
 *
 * @author: nano
 * @time: 2020/7/11 16:31
 */
public class MultiThreadPrint implements Runnable {


	private static char[] ch = {'A', 'B', 'C'};

	private static int count = 0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (; ; )
			print();
	}

	private static synchronized void print() {
		System.out.print(ch[count % 3]);
		count++;
	}


	public static void main(String[] args) {
		new Thread(new MultiThreadPrint()).start();
		new Thread(new MultiThreadPrint()).start();
		new Thread(new MultiThreadPrint()).start();

	}
}
