

package javase.base;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 测试Integer
 * @author: cz
 */
public class IntegerTest{

    public static void main(String[] args) {

        Integer m = 123;  // 123在缓存池中
        Integer n = 123;
        System.out.println(m == n); // true
        // 500不在缓存池中
        Integer a = Integer.valueOf(500);
        Integer b = Integer.valueOf(500);
        System.out.println(a == b); 	// false
        System.out.println(a.equals(b));// true
        // 字面量从缓存池取
        Integer c = 12;
        Integer d = 12;
        System.out.println(c == d);   // true

        // 相当于创建2个对象
        Integer x = new Integer(123);
        Integer y = new Integer(123);
        System.out.println(x == y);    // false
        // 相当于从缓存池取
        Integer z = Integer.valueOf(123);
        Integer k = Integer.valueOf(123);
        System.out.println(z == k);   // true

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("111");


    }

}
