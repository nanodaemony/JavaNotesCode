package com.nano.designpattern.facade;

public class SubSystem {
    // 开电视
    public void turnOnTV() {
        System.out.println("turnOnTV()");
    }
    // 放置CD
    public void setCD(String cd) {
        System.out.println("setCD( " + cd + " )");
    }
    // 开始观看
    public void startWatching(){
        System.out.println("startWatching()");
    }
}
