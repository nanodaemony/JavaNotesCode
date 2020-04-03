package com.nano.datastructure.刷题.网易;

import java.util.Scanner;

/**
 *
 */
public class 迷路牛牛找方向 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String dirction = scanner.next();

        char[] direcs = dirction.toCharArray();

        int numL = 0;
        int numR = 0;

        for (char c : direcs) {
            if (c == 'L') {
                numL++;
            } else if (c == 'R') {
                numR++;
            }
        }

        int res = numL - numR;

        if (res >= 0) {
            if (res % 4 == 0) {
                System.out.println("N");
            } else if (res % 4 == 1) {
                System.out.println("W");
            } else if (res % 4 == 2) {
                System.out.println("S");
            } else if (res % 4 == 3) {
                System.out.println("E");
            }
        } else {

            int resR = numR - numL;

            if (resR % 4 == 0) {
                System.out.println("N");
            } else if (resR % 4 == 1) {
                System.out.println("E");
            } else if (resR % 4 == 2) {
                System.out.println("S");
            } else if (resR % 4 == 3) {
                System.out.println("W");
            }
        }




    }


}
