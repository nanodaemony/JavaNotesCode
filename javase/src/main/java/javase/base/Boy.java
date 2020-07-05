package javase.base;

public class Boy {
    // 两个静态变量
    public static Boy staticBoy1 = new Boy();
    public static Boy staticBboy2 = new Boy();

    public static final int a = 0;

    static
    {
        System.out.println("静态块");
        System.out.println("设置age=10");
        age = 10;

    }

    private static int age = 20;

    {
        System.out.println("构造块");
    }


    public static void main(String[] args) {
        Boy boy = new Boy();
        System.out.println("age:" + age);
        Boy boy1 = new Boy();

    }
}