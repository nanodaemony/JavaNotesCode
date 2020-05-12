package javase;

/**
 * 飞行接口
 * @author nano
 */
public interface Fly {

    int x = 123;            // 默认为 public static final
    // int y;               // 必须初始化
    public int z = 0;       // 不用写public
    // private int k = 0;   // Modifier 'private' not allowed here
    // protected int l = 0; // Modifier 'protected' not allowed here
    // private void fun3(); // Modifier 'private' not allowed here

    void flyOnRiver();   // 接口方法

    // 默认实现的方法
    default void flyOnSky(){
        System.out.println("在天空中飞");
    }

    // 接口中静态方法必须有方法体{}
    static void flyOnGround() {}


}
