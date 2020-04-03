package com.nano.designpattern.visitor;

public interface Element {
    void accept(Visitor visitor);
}