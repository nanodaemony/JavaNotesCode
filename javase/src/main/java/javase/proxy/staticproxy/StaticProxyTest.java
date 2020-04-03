package javase.proxy.staticproxy;

/**
 * 静态代理测试类
 * @author nano
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        UserService userServiceImpl = new UserServiceImpl();
        UserService proxy = new UserServiceProxy(userServiceImpl);

        proxy.select();
        proxy.update();
    }


}
