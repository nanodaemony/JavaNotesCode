package com.nano.datastructure.刷题.招行;

import java.util.Scanner;

/**
 * 爬楼梯
 * @author nano
 */
public class 爬楼梯 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int data = scanner.nextInt();
        System.out.println(process(data));
    }

    private static int process(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return process(n - 1) + process(n - 2);
    }


}
