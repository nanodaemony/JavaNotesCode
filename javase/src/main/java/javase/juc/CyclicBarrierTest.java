package javase.juc;

import java.util.concurrent.CyclicBarrier;

/**
 * 循环栅栏demo
 * @author cz
 */
public class CyclicBarrierTest implements Runnable {

    /**
     * 循环栅栏
     */
    private CyclicBarrier cyclicBarrier;

    private int index ;

    public CyclicBarrierTest(CyclicBarrier cyclicBarrier, int index) {
        this.cyclicBarrier = cyclicBarrier;
        this.index = index;
    }

    @Override
    public void run() {
        try {
            System.out.println("index: " + index);
            index--;
            // 等待
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(11, () -> System.out.println("所有特工到达屏障，准备开始执行秘密任务"));
        for (int i = 0; i < 10; i++) {
            new Thread(new CyclicBarrierTest(cyclicBarrier, i)).start();
        }
        // 等待完成任务
        cyclicBarrier.await();
        System.out.println("全部到达屏障....");
    }
}
