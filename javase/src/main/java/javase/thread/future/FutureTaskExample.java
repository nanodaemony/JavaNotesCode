package javase.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 封装任务
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() 			{
            @Override
            public Integer call() throws Exception {
                int result = 0;
                // 此处故意计算很久
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(100);
                    result += i;
                }
                // 返回Integer类型结果
                return result;
            }
        });
        // 线程传入futureTask
        Thread computeThread = new Thread(futureTask);
        computeThread.start();

        Thread fastThread = new Thread(() -> {
            System.out.println("FastThread时间:" + System.currentTimeMillis());
            System.out.println("other task is running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        fastThread.start();
        // 获取futureTask的执行结果
        System.out.println("阻塞等待结果");
        System.out.println(futureTask.get());
        System.out.println("FutureTask计算完成时间:" + System.currentTimeMillis());
    }
}
