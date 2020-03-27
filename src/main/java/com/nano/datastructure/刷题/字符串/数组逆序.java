package com.nano.datastructure.刷题.字符串;

/**
 * 将一个字符数组逆序
 * @author nano
 */
public class 数组逆序 {


    public void reverseArray(char[] array, int start, int end) {
        char temp = 0;
        while (start < end) {
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

}
