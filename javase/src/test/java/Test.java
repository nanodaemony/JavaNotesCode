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


        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(2);


        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap();

        ReentrantLock reentrantLock = new ReentrantLock();
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();

        CountDownLatch countDownLatch = new CountDownLatch(5);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        Semaphore semaphore = new Semaphore(6);
    }


}

