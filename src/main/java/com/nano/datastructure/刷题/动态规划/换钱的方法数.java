package com.nano.datastructure.刷题.动态规划;

/**
 * 给定数组arr，arr中所有的值都为整数且不重复。每个值代表一种面值的货币，
 * 每种面值的货币可以使用任意张，再给定一个整数代表要找的钱数，
 * 求换钱有多少种方法。
 */
public class 换钱的方法数 {

    // 换钱的方法数
    public static int coins1(int[] arr, int aim) {
        // 方法一：暴力递归，时间复杂度最差为O（aim^N）
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    private static int process1(int[] arr, int index, int aim) {
        // 方法数为0
        int res = 0;
        // 说明index到了钱币面值数组的末尾
        if (index == arr.length) { // 因递归中有index + 1,所以最大为arr.length
            // aim=0,只有一种方法，就是所有面值都不用 如果剩余的钱 aim 刚好为0，则认为找到一种方法
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += process1(arr, index + 1, aim - arr[index] * i);
                // 对于arr[5,10,25,1],aim=1000
                // 用0张5，让[5,10,25,1]组成剩下的1000，方法res1
                // 用1张5，让[5,10,25,1]组成剩下的995，方法res2
                // 用200张5，让[5,10,25,1]组成剩下的0，方法res201
                // res  =res1 + .... + res201
            }
        }
        return res;
    }


    // 获得换钱的方法数目(记忆搜索方法O(N*aim^2))
    public static int getCoinNum02(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim <= 0) {
            return 0;
        }
        // 用于记录的memo map
        int[][] map = new int[arr.length + 1][aim + 1];
        return process02(arr, 0, aim, map);

    }

    // 使用记录数组的记忆化搜索
    public static int process02(int[] arr, int index, int aim, int[][] map) {

        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            int mapValue = 0;
            for (int i = 0; arr[index] * i <= aim; i++) {

                // 对比记录已经计算过的值
                mapValue = map[index + 1][aim - arr[index] * i];
                if (mapValue != 0) {
                    // 找到已经计算的结果
                    res += mapValue == -1 ? 0 : mapValue;
                } else {
                    res += process02(arr, index + 1, aim - arr[index] * i, map);
                }
            }
        }
        // 更新记录map的值
        map[index][aim] = res == 0 ? -1 : res;
        return res;
    }


    //方法二：动态规划，非最优，时间复杂度为O（N×aim）
    public static int coins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        //dp[i][j]表示使用arr[0...i]组成j的方法数
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;//矩阵第一列，组成0的方法：1种
        }
        for (int j = 0; arr[0] * j <= aim; j++) {
            dp[0][arr[0] * j] = 1;//矩阵第一行，arr[0]组成arr[0]*j的方法：1种
        }
        //求一般位置的dp[i][j],由两者叠加
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[i][j] = dp[i - 1][j];//不用arr[i]组成j
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;//先用一张arr[i],剩下arr[0...i]组成j-arr[i]
            }
        }
        return dp[arr.length - 1][aim];//arr[0...N]组成aim的方法数
    }
}
