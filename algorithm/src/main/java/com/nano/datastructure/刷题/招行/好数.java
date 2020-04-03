package com.nano.datastructure.刷题.招行;

import java.util.Scanner;

/**
 * 招行
 * X数
 * @author nano
 */
public class 好数 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int res = 0;
        for (int i = 1; i <= N; i++) {

            if (isXNumber(i)) {
                res++;
            }
        }

        System.out.println(res);

    }

    private static boolean isXNumber(int num) {
        char[] nums = ("" + num).toCharArray();

        // 是否包含有效的数字 2569之一
        boolean isContainUsefulNum = false;
        for (char c : nums) {
            if (c == '3' || c == '4' || c == '7') {
                return false;
            }
            if (c == '2' || c == '5' || c == '6' || c == '9') {
                isContainUsefulNum = true;
            }
        }
        // 此时的数就是好数
        if (isContainUsefulNum) {
            return true;
        } else {
            return false;
        }
    }





}
