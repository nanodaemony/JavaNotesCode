package com.nano.datastructure.刷题.拼多多;

import java.util.Arrays;
import java.util.Scanner;

public class 最大乘积 {


    public static void main(String[] args) {

        String a = "123";
        String b = "345";
        System.out.println(add(a, b));


    }

    private static String add(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        char[] temp1 = null;
        char[] temp2 = null;

        temp1 = chars1.length >= chars2.length ? chars1 : chars2;
        temp2 = chars1.length >= chars2.length ? chars2 : chars1;

        int carry = 0;

        char[] res = new char[temp1.length + 1];

        for (int i = 0; i < temp2.length; i++) {

            char temp = (char) (temp1[i] + temp2[i] + carry);
            if(temp >= 10) {
                res[i] = (char) (temp % 10);
                carry = 1;
            } else {
                res[i] = temp;
                carry = 0;
            }
        }

        for (int i = temp2.length; i < temp1.length; i++) {
            if (carry == 1) {
                res[i] = (char) (temp1[i] + carry);
            } else {
                res[i] = temp1[i];
            }
        }

        for (char c : res) {
            System.out.println(c);
        }
        return Arrays.toString(res);
    }


}
