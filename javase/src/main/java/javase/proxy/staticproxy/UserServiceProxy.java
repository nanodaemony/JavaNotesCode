package javase.proxy.staticproxy;

import java.util.Date;

/**
 * 用户服务静态代理类
 */
public class UserServiceProxy implements UserService {

    /**
     * 被代理的对象
     */
    private UserService target;

    /**
     * 构造方法传入被代理对象
     */
    public UserServiceProxy(UserService target) {
        this.target = target;
    }


    @Override
    public void select() {
        before();
        target.select();
        after();
    }

    @Override
    public void update() {
        before();
        target.update();
        after();
    }

    // 在执行方法之前执行
    private void before() {
        System.out.println(String.format("log start time [%s] ", new Date()));
    }
    // 在执行方法之后执行
    private void after() {
        System.out.println(String.format("log end time [%s] ", new Date()));
    }
}
