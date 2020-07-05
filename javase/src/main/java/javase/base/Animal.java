package javase.base;

import lombok.Data;

/**
 * 动物父类
 * @author nano
 */
@Data
public class Animal {

    private String name;

    private String age;

    public Animal(){}

    public Animal(String name, String age) {
        this.name = name;
        this.age = age;
        System.out.println("一只动物出生");
    }

    // 父类方法
    public void eatFood() {
        System.out.println("动物吃东西");
    }

}
