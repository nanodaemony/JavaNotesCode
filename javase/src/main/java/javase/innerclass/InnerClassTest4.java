package javase.innerclass;

public class InnerClassTest4 {

    public int field1 = 1;
    protected int field2 = 2;
    int field3 = 3;
    private int field4 = 4;

    public InnerClassTest4() {
        System.out.println("创建 " + this.getClass().getSimpleName() + " 对象");
    }

    // 在方法内部创建局部内部类
    private void localInnerClassTest() {
        // 局部内部类 A，只能在当前方法中使用
        class A {
            // static int field = 1; // 编译错误！局部内部类中不能定义 static 字段
            public A() {
                System.out.println("创建 " + A.class.getSimpleName() + " 对象");
                System.out.println("其外部类的 field1 字段的值为: " + field1);
                System.out.println("其外部类的 field2 字段的值为: " + field2);
                System.out.println("其外部类的 field3 字段的值为: " + field3);
                System.out.println("其外部类的 field4 字段的值为: " + field4);
            }
        }
        A a = new A();
        if (true) {
            // 局部内部类 B，只能在当前代码块中使用
            class B {
                public B() {
                    System.out.println("创建 " + B.class.getSimpleName() + " 对象");
                    System.out.println("其外部类的 field1 字段的值为: " + field1);
                    System.out.println("其外部类的 field2 字段的值为: " + field2);
                    System.out.println("其外部类的 field3 字段的值为: " + field3);
                    System.out.println("其外部类的 field4 字段的值为: " + field4);
                }
            }
            B b = new B();
        }
        // B b1 = new B(); // 编译错误！不在类 B 的定义域内，找不到类 B，
    }

    public static void main(String[] args) {
        InnerClassTest4 outObj = new InnerClassTest4();
        outObj.localInnerClassTest();
    }
}

