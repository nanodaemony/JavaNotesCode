package com.nano.datastructure.刷题.动态规划;

/**
 * 有一个整型数组 A，代表数值不同的纸牌排成一条线。玩家 a 和
 * 玩家 b 依次拿走每张纸牌，规定玩家 a 先拿，玩家 b 后拿，但
 * 是每个玩家每次只能拿走最左或最右的纸牌，玩家 a 和玩家 b 都
 * 绝顶聪明，他们总会采用最优策略。请返回最后获胜者的分数。
 * 给定纸牌序列  A 及序列的大小 n，请返回最后分数较高者得
 * 分数(相同则返回任意一个分数)。保证 A 中的元素均小于
 * 等于 1000。且 A 的大小小于等于300。
 */
public class 排成一条线的纸牌博弈问题 {


    // 暴力递归法
    public int cardGame(int[] arr, int n) {
        if (arr == null || n == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, n - 1), s(arr, 0, n - 1)); // write code here
    }

    // 先手拿取最大
    public int f(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }
        return Math.max(arr[start] + s(arr, start + 1, end), arr[end] + s(arr, start, end - 1));
    }

    // 后手拿取最小
    public int s(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }
        return Math.min(f(arr, start + 1, end), f(arr, start, end - 1));
    }


    // 动态规划法
    public int cardGameDp(int[] arr, int n) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // 需要两个dp数组
        int[][] f = new int[n][n];
        int[][] s = new int[n][n];
        for (int j = 0; j < arr.length; j++) {
            f[j][j] = arr[j];
            for (int i = j - 1; i >= 0; i--) {
                // f[i][j]表示在arr[i...j]区间内当前玩家最大的累加和
                f[i][j] = Math.max(arr[j] + s[i][j - 1], arr[i] + s[i + 1][j]);
                // s[i][j]表示在arr[i..j]区间内的最小累加和
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return Math.max(f[0][n - 1], s[0][n - 1]);
    }

}
