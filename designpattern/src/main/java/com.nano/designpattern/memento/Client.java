package com.nano.designpattern.memento;

public class Client {
    public static void main(String[] args) {
        // 定义Memento管理者对象
        CareTaker taker = new CareTaker();

        Emp emp = new Emp("Jack", 48, 900);
        System.out.println("Init State：" + emp.getEname() + " age：" + emp.getAge() + " salary：" + emp.getSalary());
        // 备忘一次
        taker.setMemento(emp.memento());
        System.out.println("注意：备忘一次");

        // 修改对象状态
        emp.setAge(18);
        emp.setEname("Alice");
        emp.setSalary(9000);
        System.out.println("Changed State：" + emp.getEname() + " age：" + emp.getAge() + " salary：" + emp.getSalary());

        // 恢复到备忘录对象保存的状态
        emp.recovery(taker.getMemento());
        System.out.println("注意：恢复到备忘录对象保存的状态");

        System.out.println("Back To Init State： " + emp.getEname() + " age：" + emp.getAge() + " salary：" + emp.getSalary());
    }
}
