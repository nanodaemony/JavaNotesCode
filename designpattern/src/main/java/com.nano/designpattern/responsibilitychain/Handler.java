package com.nano.designpattern.responsibilitychain;

/**
 * 处理器类
 * @author nano
 */
public abstract class Handler {

    // 处理器
    protected Handler successor;

    public Handler(Handler successor) {
        this.successor = successor;
    }

    // 处理请求
    protected abstract void handleRequest(Request request);
}
