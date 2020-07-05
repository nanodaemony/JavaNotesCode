package javase.juc.atomic;

import javase.juc.utils.UnsafeInstance;
import sun.misc.Unsafe;

/**
 */
public class AtomicStudentAgeUpdater {
    private String name ;
    private volatile int age;

    private static final Unsafe unsafe = UnsafeInstance.reflectGetUnsafe();
    private static final long valueOffset;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset(AtomicStudentAgeUpdater.class.getDeclaredField("age"));
            System.out.println("valueOffset:--->"+valueOffset);
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public void compareAndSwapAge(int old,int target){
        unsafe.compareAndSwapInt(this,valueOffset,old,target);
    }


    public AtomicStudentAgeUpdater(String name,int age){
        this.name = name;
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

    public static void main(String[] args) {
        AtomicStudentAgeUpdater updater = new AtomicStudentAgeUpdater("杨过",18);
        updater.compareAndSwapAge(18,56);

        System.out.println("真实的杨过年龄---"+updater.getAge());

    }
}
