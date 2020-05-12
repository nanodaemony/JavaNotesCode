package javase.innerclass;

public class InnerClassTest {

    int field1 = 1;
    private int field2 = 2;

    public InnerClassTest() {
        InnerClassA inner = new InnerClassA();
        int v = inner.x2;
    }

    public class InnerClassA {
        int x1 = field1;
        private int x2 = field2;
    }
}

