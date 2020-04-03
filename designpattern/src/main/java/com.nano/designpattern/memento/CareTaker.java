package com.nano.designpattern.memento;

/**
 * 负责人类 用于保存memento
 * @author nano
 */
public class CareTaker {

    private EmpMemento memento;

    // private List<EmpMemento> list = new ArrayList<EmpMemento>();

    public EmpMemento getMemento() {
        return memento;
    }

    public void setMemento(EmpMemento memento) {
        this.memento = memento;
    }
}
