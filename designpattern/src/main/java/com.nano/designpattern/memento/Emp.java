package com.nano.designpattern.memento;

import lombok.Data;

/**
 * 源发器类 Originator 被管理者
 */
@Data
public class Emp {

    private String ename;
    private int age;
    private double salary;

    // 进行备忘操作，并返回备忘录对象
    public EmpMemento memento(){
        return new EmpMemento(this);
    }

    // 进行数据恢复，恢复成制定备忘录对象的值
    public void recovery(EmpMemento mmt){
        this.ename = mmt.getEname();
        this.age = mmt.getAge();
        this.salary = mmt.getSalary();
    }

    public Emp(String ename, int age, double salary) {
        super();
        this.ename = ename;
        this.age = age;
        this.salary = salary;
    }

}
