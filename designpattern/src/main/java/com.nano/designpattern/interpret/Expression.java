package com.nano.designpattern.interpret;

/**
 * 表达式类
 */
public abstract class Expression {
    // 解释
    public abstract boolean interpret(String str);
}
