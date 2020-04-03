package com.nano.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者，也就是天气服务发布系统
 * 实现了Observerable接口，对Observerable接口的三个方法进行了具体实现
 */
public class WeatherTopic implements Topic {

    // 注意到这个List集合的泛型参数为Observer接口，
    // 设计原则：面向接口编程而不是面向实现编程
    private List<Observer> list;
    private String message;

    public WeatherTopic() {
        list = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if (!list.isEmpty()) {
            list.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < list.size(); i++) {
            Observer observer = list.get(i);
            observer.update(message);
        }
    }
    // 设置消息
    public void setInfomation(String s) {
        this.message = s;
        System.out.println("天气系统更新消息： " + s);
        //消息更新，通知所有观察者
        notifyObserver();
    }
}