package com.nano.javase.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 日志处理器
 * @author nano
 */
public class LogHandler implements InvocationHandler {

    // 被代理的对象，实际的方法执行者
    Object target;

    // 传入被代理对象
    public LogHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 调用invoke方法之前执行
        before();
        // 反射调用 target 的 method 方法
        Object result = method.invoke(target, args);
        // 调用invoke方法之后执行
        after();
        // 返回方法的执行结果
        return result;
    }

    // 调用invoke方法之前执行
    private void before() {
        System.out.println(String.format("log start time [%s] ", new Date()));
    }

    // 调用invoke方法之后执行
    private void after() {
        System.out.println(String.format("log end time [%s] ", new Date()));
    }
}
