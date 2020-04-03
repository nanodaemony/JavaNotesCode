package com.nano.datastructure.贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/9dd19c9305704138bdf83e2dffdcb4f4
 * 来源：牛客网
 *
 * 给定一组石头，每个石头有一个正数的重量。每一轮开始的时候，选择两个石头一起碰撞，假定两个石头的重量为x，y，x<=y,碰撞结果为
 * 1. 如果x==y，碰撞结果为两个石头消失
 * 2. 如果x != y，碰撞结果两个石头消失，生成一个新的石头，新石头重量为y-x
 *
 * 最终最多剩下一个石头为结束。求解最小的剩余石头质量的可能性是多少。
 */
public class 石头碰撞 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int[] pool = new int[num];

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.naturalOrder());

        for (int i = 0;  i < num; i++) {
            pool[i] = scanner.nextInt();
        }
        for (int i = 0;  i < num; i++) {
            if (!priorityQueue.isEmpty() && priorityQueue.contains(pool[i])) {
                // 弹出顶端的元素
                priorityQueue.remove(pool[i]);
            } else {
                priorityQueue.offer(pool[i]);
            }
        }


//        while (!priorityQueue.isEmpty()) {
//            System.out.println(priorityQueue.poll());
//        }
        System.out.println(lastStoneWeight(pool));
     }



    public static int lastStoneWeight(int[] stones) {
        int n = stones.length;
        while (!(checkStones(stones) == n || checkStones(stones) == n-1)) {
            if (stones[n-2] == stones[n-1]) {
                stones[n-2] = 0;
                stones[n-1] = 0;
            } else {
                stones[n-1] -= stones[n-2];
                stones[n-2] = 0;
            }
        }
        // 全是0，或者只有最后一个元素不为0
        return stones[n-1] == 0 ? 0 : stones[n-1];
    }

    /**
     * 统计数组stones中值为0的元素个数
     * @param stones
     * @return
     */
    public static int checkStones(int[] stones) {
        Arrays.sort(stones);
        int count = 0, n = stones.length;
        for (int i=0; i<n; i++) {
            if (stones[i] == 0) {
                count++;
            }
        }
        return count;
    }

}
