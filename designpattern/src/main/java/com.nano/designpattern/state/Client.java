package com.nano.designpattern.state;

public class Client {

    public static void main(String[] args) {
        // 获取环境上下文对象
        HomeContext ctx = new HomeContext();
        // 不断修改状态 产生两种行为
        ctx.setState(new FreeState());
        ctx.setState(new BookedState());
    }

}
