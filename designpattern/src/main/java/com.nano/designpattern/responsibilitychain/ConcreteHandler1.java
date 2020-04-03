package com.nano.designpattern.responsibilitychain;

public class ConcreteHandler1 extends Handler {

    public ConcreteHandler1(Handler successor) {
        super(successor);
    }

    @Override
    protected void handleRequest(Request request) {
        if (request.getType().equals("Type1")) {
            System.out.println(request.getName() + " is handle by ConcreteHandler1");
            return;
        }
        if (successor != null) {
            // 交给下一个处理器进行处理
            successor.handleRequest(request);
        }
    }
}
