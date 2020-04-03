package com.nano.designpattern.flyweight;

/**
 * 享元类
 */
public interface ChessFlyWeight {
    void setColor(String c);
    String getColor();
    void display(Coordinate c);
}
