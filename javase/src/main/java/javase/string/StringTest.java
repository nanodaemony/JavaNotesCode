package javase.string;

public class StringTest {


    public static void main(String[] args) {


        String s1 = new String("aaa");
        String s2 = new String("aaa");

        System.out.println(s1 == s2);

        String s3 = "aaa";
        String s4 = "aaa";

        System.out.println(s1 == s3);
        System.out.println(s3 == s4);

        String s5 = "bbb";
        String s6 = "bbb";

        System.out.println(s5 == s6);

        s1 = s1.intern();   // 检查String Pool中没有"aaa"则添加进去
        s2 = s2.intern();

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);


//        String a = "aaa";
//        String b = "aaa";
//        System.out.println(a == b);
//        String s1 = new String("aaa");
//        String s2 = new String("aaa");
//        String s6 = "aaa";
//        String s7 = "aaa";
//        System.out.println(s1 == s2);           // false
//        System.out.println(s1 == s3);
//        String s4 = s1.intern();                // 检查String Pool中没有"aaa"则添加进去
//        String s5 = s1.intern();                // 检查String Pool已经有了"aaa"则直接获取出来
//        System.out.println(s4 == s5);           // true 因为指向的是同一对象
//


    }

}
