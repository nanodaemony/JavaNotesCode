package com.nano.designpattern.iterator;

public class Client {

    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        // 获取迭代器
        Iterator<Integer> iterator = aggregate.createIterator();
        // 遍历
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
