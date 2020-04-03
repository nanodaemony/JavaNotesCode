package com.nano.designpattern.iterator;

/**
 * 聚合接口实现类
 */
public class ConcreteAggregate implements Aggregate {
    private Integer[] items;

    public ConcreteAggregate() {
        items = new Integer[10];
        for (int i = 0; i < items.length; i++) {
            items[i] = i;
        }
    }


    @Override
    public ConcreteIterator<Integer> createIterator() {
        return new ConcreteIterator<Integer>(items);
    }
}
