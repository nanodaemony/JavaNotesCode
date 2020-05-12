package javase.genericity;

import java.lang.reflect.Field;

/**
 * 自定义泛型类
 *
 * @param <T>
 */
public class Erasure<T extends String> {
    T object;

    public Erasure(T object) {
        this.object = object;
    }

    public static void main(String[] args) {
        Erasure<String> erasure = new Erasure<String>("hello");
        Class erasureClass = erasure.getClass();
        System.out.println("erasure class is:" + erasureClass.getName());

        Field[] fs = erasureClass.getDeclaredFields();
        for (Field f : fs) {
            System.out.println("Field name: " + f.getName() + ", type:" + f.getType().getName());
        }
    }

}
