package com.nano.designpattern.iterator;

/**
 * 聚合接口
 */
public interface Aggregate {
    ConcreteIterator<Integer> createIterator();
}
