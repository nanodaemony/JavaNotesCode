package javase.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;
        import java.util.concurrent.ExecutorService;
        import java.util.concurrent.Executors;

public class CountdownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        final int totalThread = 10;
        // 定义门栏变量
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        // 线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < totalThread; i++) {
            executorService.execute(() -> {
                System.out.print("run..");
                // 在此处等待
                countDownLatch.countDown();
                System.out.println("finish");
            });
        }
        // 当前线程等待其他的十个线程完成任务
        countDownLatch.await();
        // 全部完成后打印end
        System.out.println("end");
        executorService.shutdown();
    }
}