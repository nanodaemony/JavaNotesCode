package com.nano.designpattern.observer;


/**
 * 测试类
 */
public class TestObserver {
    public static void main(String[] args) {
        // 定义天气主题
        WeatherTopic weatherTopic = new WeatherTopic();

        // 定义天气三个观察者
        Observer user1 = new WeatherUser("Bob");
        Observer user2 = new WeatherUser("Jack");
        Observer user3 = new WeatherUser("Alice");

        // 观察者注册到主题上
        weatherTopic.registerObserver(user1);
        weatherTopic.registerObserver(user2);
        weatherTopic.registerObserver(user3);

        // 主题发布消息
        weatherTopic.setInfomation("今天有大雨！！！");

        System.out.println("************************************");
        // 将User1取消订阅主题
        weatherTopic.removeObserver(user1);
        // 再次发布消息
        weatherTopic.setInfomation("明天是晴天");
    }
}
