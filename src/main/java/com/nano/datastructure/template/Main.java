package com.nano.datastructure.template;

import java.util.Scanner;
public class Main{
    public static void main(String[ ] args) {
        // Read data
        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();
        int num = scan.nextInt();
        int[] nums = strArrToIntArr(data.split(" "));

        //scan.close();

        System.out.println("");
    }

    /**
     * 注意一次读两行的写法
     */
    public void readTwo() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String dirction = scanner.next();
    }


    /**
     * 把字符串数组转成一般数组
     *
     * @return 一般数组
     */
    private static int[] strArrToIntArr(String[] stringArray) {
        if (stringArray == null || stringArray.length == 0) {
            return new int[1];
        }
        int[] data = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            data[i] = Integer.parseInt(stringArray[i]);
        }
        return data;
    }
}