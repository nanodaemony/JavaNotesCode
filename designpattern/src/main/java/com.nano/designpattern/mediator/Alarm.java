package com.nano.designpattern.mediator;

/**
 * 闹钟类
 */
public class Alarm extends Colleague {
    // 事件到来时进行动作
    @Override
    public void onEvent(Mediator mediator) {
        mediator.doEvent("alarm");
    }

    public void doAlarm() {
        System.out.println("doAlarm()");
    }
}