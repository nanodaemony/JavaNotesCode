package com.nano.designpattern.builder;

public class Client {
    public static void main(String[] args) {
        // 使用生成器产生对象
        User user = new User.Builder("Ace")
                .age(10)
                .address("beijing")
                .safeID(2)
                .build();
    }
}
