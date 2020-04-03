package com.nano.designpattern.builder;

public class User {
    // 多个属性字段
    private final int age;
    private final int safeID;
    private final String name;
    private final String address;

    public int getAge() {
        return age;
    }

    public int getSafeID() {
        return safeID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    // 私有构造方法
    private User(Builder b) {
        age = b.age;
        safeID = b.safeID;
        name = b.name;
        address = b.address;
    }

    // 内部生成器类
    public static class Builder {
        // 属性默认值
        private int age = 0;
        private int safeID = 0;
        private String name = null;
        private String address = null;

        // 构建的步骤
        public Builder(String name) {
            this.name = name;
        }

        public Builder age(int val) {
            age = val;
            return this;
        }

        public Builder safeID(int val) {
            safeID = val;
            return this;
        }

        public Builder address(String val) {
            address = val;
            return this;
        }

        // 构建，返回一个新对象
        public User build() {
            return new User(this);
        }
    }

}
