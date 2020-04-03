package com.nano.designpattern.interpret;

import java.util.StringTokenizer;

public class TerminalExpression extends Expression {
    private String literal = null;

    public TerminalExpression(String str) {
        literal = str;
    }

    // 实现解释方法
    public boolean interpret(String str) {
        StringTokenizer st = new StringTokenizer(str);
        while (st.hasMoreTokens()) {
            String test = st.nextToken();
            if (test.equals(literal)) {
                return true;
            }
        }
        return false;
    }
}
