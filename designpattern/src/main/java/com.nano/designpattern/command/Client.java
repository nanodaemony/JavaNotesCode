package com.nano.designpattern.command;

public class Client {
    public static void main(String[] args) {
        // 遥控器
        Invoker invoker = new Invoker();
        // 灯
        Light light = new Light();
        // 开关灯命令
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);

        invoker.setOnCommand(lightOnCommand, 0);
        invoker.setOffCommand(lightOffCommand, 0);
        // 开灯
        invoker.onButtonWasPushed(0);
        // 关灯
        invoker.offButtonWasPushed(0);
    }
}
