package com.nano.javase.annotation;

import java.lang.reflect.Field;

/**
 * 读取水果相关注解信息的工具类
 * @author nano
 */
public class FruitInfoUtil {

    public static void getFruitInfo(Class<?> clazz) {

        String strFruitName = " 水果名称：";
        String strFruitColor = " 水果颜色：";
        String strFruitProvicer = "供应商信息：";

        // 通过class对象获取字段
        Field[] fields = clazz.getDeclaredFields();

        //遍历字段属性判断标注了什么注解
        for(Field field : fields){
            // 水果名称
            if(field.isAnnotationPresent(FruitName.class)){
                FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
                strFruitName = strFruitName+fruitName.value();
                System.out.println(strFruitName);
            }
            // 水果颜色
            else if(field.isAnnotationPresent(FruitColor.class)){
                FruitColor fruitColor = (FruitColor) field.getAnnotation(FruitColor.class);
                strFruitColor = strFruitColor + fruitColor.fruitColor().toString();
                System.out.println(strFruitColor);
            }
            // 水果供应商
            else if(field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider = (FruitProvider) field.getAnnotation(FruitProvider.class);
                strFruitProvicer = " 供应商编号：" + fruitProvider.id() + " 供应商名称：" + fruitProvider.name() + " 供应商地址：" + fruitProvider.address();
                System.out.println(strFruitProvicer);
            }
        }
    }

}
