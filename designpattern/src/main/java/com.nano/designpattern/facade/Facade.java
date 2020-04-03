package com.nano.designpattern.facade;

public class Facade {
    // 子系统
    private SubSystem subSystem = new SubSystem();
    // 看电影方法
    public void watchMovie() {
        subSystem.turnOnTV();
        subSystem.setCD("九品芝麻官");
        subSystem.startWatching();
    }
}
