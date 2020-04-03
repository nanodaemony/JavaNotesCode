package com.nano.designpattern.responsibilitychain;

/**
 * 具体处理器2
 */
public class ConcreteHandler2 extends Handler {

    // 传入successor
    public ConcreteHandler2(Handler successor) {
        super(successor);
    }

    @Override
    protected void handleRequest(Request request) {
        if (request.getType().equals("Type2")) {
            System.out.println(request.getName() + " is handle by ConcreteHandler2");
            return;
        }
        if (successor != null) {
            // 交给下一个处理器进行处理
            successor.handleRequest(request);
        }
    }
}
