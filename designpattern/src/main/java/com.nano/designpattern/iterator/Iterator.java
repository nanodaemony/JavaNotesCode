package com.nano.designpattern.iterator;

public interface Iterator<Item> {

    Item next();

    boolean hasNext();
}
