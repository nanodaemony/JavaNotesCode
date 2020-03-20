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



    public static int minConins(int[] arr, int aim){
        if(arr == null || arr.length == 0 || aim < 0){
            return -1;
        }
        int[][] dp = new int[arr.length][aim+1];
        int max = Integer.MAX_VALUE;
        //设置第一行
        for(int j=1; j <= aim; j++){
            dp[0][j] = max;
            if(j-arr[0] >= 0 && dp[0][j-arr[0]] != max ){
                dp[0][j] = dp[0][j-arr[0]] + 1;
            }
        }
        int left = 0;
        for(int i=1; i < arr.length; i++){
            for(int j=1; j <=aim; j++){
                left = max;
                if(j-arr[i] >=0 && dp[i][j-arr[i]] != max){
                    left = dp[i][j-arr[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i-1][j]);
            }
        }
//        for(int i=0; i < arr.length; i++){
//            for(int j=0; j<= aim; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        return dp[arr.length-1][aim] != max ? dp[arr.length-1][aim] : -1;
    }


}
