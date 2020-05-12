package javase.innerclass;

public class InnerClassTest2 {

    // 外部类实例字段
    public int outerField = 1;

    public static int outerStaticField = 3;

    public InnerClassTest2() {
        System.out.println("创建 " + this.getClass().getSimpleName() + " 对象");
        // 创建静态内部类对象
        StaticClass innerObj = new StaticClass();
        System.out.println("其内部类的 field1 字段的值为: " + innerObj.field1);
        System.out.println("其内部类的 field2 字段的值为: " + innerObj.field2);
        System.out.println("其内部类的 field3 字段的值为: " + innerObj.field3);
        System.out.println("其内部类的 field4 字段的值为: " + innerObj.field4);
        System.out.println("内部类静态字段值：" + StaticClass.field5);
    }

    static class StaticClass {
        // 静态内部类中可以定义各种属性
        public int field1 = 1;
        protected int field2 = 2;
        int field3 = 3;
        private int field4 = 4;
        // 静态内部类中可以定义 static 属性
        static int field5 = 5;

        public StaticClass() {
            System.out.println("创建 " + StaticClass.class.getSimpleName() + " 对象");
            // 可以引用外部类的静态字段
            System.out.println("外部类静态字段值：" + InnerClassTest2.outerStaticField);
            // 不能引用外部类的实例字段
            // System.out.println("其外部类的 field1 字段的值为: " + outerField); // 编译错误！！
        }
    }

    public static void main(String[] args) {
        // 无需依赖外部类对象，直接创建内部类对象
        // InnerClassTest.StaticClass staticClassObj = new InnerClassTest.StaticClass();
        InnerClassTest2 outerObj = new InnerClassTest2();

        StaticClass staticClass = new StaticClass();
    }
}

