package javase.juc;

import java.util.concurrent.CountDownLatch;

/**
 * 演示CountDownLaunch
 * @author cz
 */
public class CountDownLaunchSample {

	public static void main(String[] args) throws InterruptedException {
		long now = System.currentTimeMillis();
		// 定义栅栏
		CountDownLatch countDownLatch = new CountDownLatch(2);
		// 开启看医生线程
		new Thread(new SeeDoctorTask(countDownLatch)).start();
		// 开启买药任务
		new Thread(new ByMedicineTask(countDownLatch)).start();
		// 等待前面的2个任务执行完毕，否则一直阻塞
		countDownLatch.await();
		System.out.println("Over，回家 cost:" + (System.currentTimeMillis() - now));
	}

    /**
     * 看医生的任务
     */
    static class SeeDoctorTask implements Runnable {

        private CountDownLatch countDownLatch;

        // 传入这个CountDownLatch
        public SeeDoctorTask(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println("开始看医生");
                Thread.sleep(2000);
                System.out.println("看医生结束，准备离开病房");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                if (countDownLatch != null) {
                    // 任务完成一个
                    countDownLatch.countDown();
                }
            }
        }

    }

    /**
     * 买药任务
     */
    static class ByMedicineTask implements Runnable {

        private CountDownLatch countDownLatch;

        public ByMedicineTask(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println("开始在医院药房排队买药....");
                Thread.sleep(5000);
                System.out.println("排队成功，可以开始缴费买药");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                if (countDownLatch != null) {
                    // 买药任务完成通知栅栏
                    countDownLatch.countDown();
                }
            }
        }
    }
}


