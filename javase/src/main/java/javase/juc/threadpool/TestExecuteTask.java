package javase.juc.threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试线程池执行任务
 *
 * @author: nano
 * @time: 2020/6/16 9:24
 */
public class TestExecuteTask {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 6, 200,
				TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(4));
		for (int i = 0; i < 15; i++) {
			executor.execute(new MyTask(i));
			System.out.println("线程池中核心线程数目：" + executor.getCorePoolSize() +
					"线程池中总线程数目：" + executor.getPoolSize() + ",队列中等待执行的任务数目：" +
					executor.getQueue().size() + ",已执行完别的任务数目：" + executor.getCompletedTaskCount());
		}
//		executor.shutdown();
	}


	static class MyTask implements Runnable {

		private int taskId;

		public MyTask(int id) {
			this.taskId = id;
		}

		@Override
		public void run() {
			System.out.println("开始执行task:"+ taskId);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("task "+ taskId +"执行完毕");
		}
	}

}
