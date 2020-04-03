package com.nano.designpattern.bridge;

public abstract class RemoteControl {
    // 需要控制的TV对象
    protected TV tv;

    public RemoteControl(TV tv) {
        this.tv = tv;
    }

    public abstract void on();

    public abstract void off();

    public abstract void tuneChannel();
}