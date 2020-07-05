package javase.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试固定线程池
 *
 * @author: nano
 * @time: 2020/6/15 21:30
 */
public class TestCachedThreadPool{
	public static void main(String[] args){
		// 创建线程池
		ExecutorService executorService = Executors.newCachedThreadPool();
//      ExecutorService executorService = Executors.newFixedThreadPool(5);
//		ExecutorService executorService = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++){
			executorService.execute(() -> System.out.println(Thread.currentThread().getName() + "线程被调用了。"));
			System.out.println("************* a" + i + " *************");
		}
		executorService.shutdown();
	}
}
