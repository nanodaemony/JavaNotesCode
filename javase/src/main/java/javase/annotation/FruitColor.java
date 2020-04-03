package javase.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 水果颜色注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FruitColor {

    /**
     * 颜色枚举
     */
    public enum Color{ BLUE, RED, GREEN};

    /**
     * 颜色属性
     */
    Color fruitColor() default Color.GREEN;

}
