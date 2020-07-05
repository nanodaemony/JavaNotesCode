import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test {


    public static void main(String[] args) {


        String str = "42760000";
        int ieee754Int = Integer.parseInt(str, 16);
        float realValue = Float.intBitsToFloat(ieee754Int);
        System.out.println(realValue);

        String channelData = "427B9F683DDC2A307FC000007FC000007FC00000";

        float f = Float.intBitsToFloat(new BigInteger("7FC00000", 16).intValue());
        if (f == Float.NaN) {
            System.out.println("123");
        };
        System.out.println(
                );


        double toi1 = ParseUtils.getDoubleValueByHexString(channelData.substring(0, 8));
        double thi1 = ParseUtils.getDoubleValueByHexString(channelData.substring(8, 16));
        double chb1 = ParseUtils.getDoubleValueByHexString(channelData.substring(16, 24));
        double chbo21 = ParseUtils.getDoubleValueByHexString(channelData.substring(24, 32));
        double cthb1 = ParseUtils.getDoubleValueByHexString(channelData.substring(32));
        System.out.println(toi1);
        System.out.println(thi1);
        System.out.println(chb1);
        System.out.println(chbo21);
        System.out.println(cthb1);
    }


}

