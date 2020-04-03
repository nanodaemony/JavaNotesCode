package com.nano.designpattern.responsibilitychain;

public class Client {

    public static void main(String[] args) {
        // 构造一个处理器构成的链
        Handler handler1 = new ConcreteHandler1(null);
        Handler handler2 = new ConcreteHandler2(handler1);

        // 使用处理器链进行处理
        Request request1 = new Request(RequestType.TYPE1, "request1");
        handler2.handleRequest(request1);
        Request request2 = new Request(RequestType.TYPE2, "request2");
        handler2.handleRequest(request2);
    }

}
