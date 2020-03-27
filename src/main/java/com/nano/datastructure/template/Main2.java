package com.nano.datastructure.template;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 组数

        for (int zu = 0; zu < n; zu++) {
            int color = sc.nextInt();  //多少种颜色
            int[] stock = new int[color];
            for (int i = 0; i < color; i++) {
                stock[i] = sc.nextInt();
            }

            int res = 0;
            int flag = 0;
            for (int i = 0; i < color; i++) {
                if (stock[i] == 0 || stock[i] == 1) {
                    flag = flag;
                } else {
                    flag++;
                }
            }
            if (flag == 0) {
                System.out.println(-1);
            } else {
                for (int i = 0; i < color; i++) {
                    if (stock[i] != 0) {
                        res++;
                    }
                }
                res++;
                System.out.println(res);
            }
        }
    }
}
