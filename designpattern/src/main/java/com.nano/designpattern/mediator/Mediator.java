package com.nano.designpattern.mediator;

/**
 * 中介者接口
 * @author nano
 */
public abstract class Mediator {
    // 做事情
    public abstract void doEvent(String eventType);
}
