package com.nano.designpattern.state;

/**
 * Context类 : 房间对象
 * 如果是银行系统，这个Context类就是账号。根据金额不同，切换不同的状态！
 */
public class HomeContext {
    // 传入状态
    private State state;

    public void setState(State s){
        System.out.println("修改状态！");
        state = s;
        state.handle();
    }
}
