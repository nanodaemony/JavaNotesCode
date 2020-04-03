package com.nano.datastructure.刷题.动态规划;

/**
 * 有重量分别为3，5，7公斤的三种货物，和一个载重量为X公斤的箱子（不考虑体积等其它因素，只计算重量）
 * 需要向箱子内装满X公斤的货物，要求使用的货物个数尽可能少（三种货物数量无限）
 */
public class 换钱最少张数 {


    public static void main(String[] args) {
        int[] arr = {5,2,3,1};
        int aim = 5;
        System.out.println(minCoins1(arr, aim));
    }

    public static int minCoins1(int[] arr, int aim){
        // Base case
        if(arr == null || arr.length == 0 || aim < 0){
            return -1;
        }
        //dp数组
        int[][] dp = new int[arr.length][aim + 1];
        // 设置一个最大值
        int maxValue = Integer.MAX_VALUE;
        // 设置第一行
        for(int j = 1; j <= aim; j++){
            dp[0][j] = maxValue;
            if(j - arr[0] >= 0 && dp[0][j - arr[0]] != maxValue){
                dp[0][j] = dp[0][j - arr[0]] + 1;
            }
        }
        int left = 0;
        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j <= aim; j++){
                left = maxValue;
                if(j - arr[i] >=0 && dp[i][j - arr[i]] != maxValue){
                    left = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i - 1][j]);
            }
        }
        return dp[arr.length - 1][aim] != maxValue ? dp[arr.length - 1][aim] : -1;
    }

}
