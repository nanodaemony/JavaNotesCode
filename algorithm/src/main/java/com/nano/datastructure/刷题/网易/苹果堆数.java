package com.nano.datastructure.刷题.网易;

import java.util.Scanner;

/**
 * 又到了丰收的季节，恰逢小易去牛牛的果园里游玩。
 * 牛牛常说他对整个果园的每个地方都了如指掌，小易不太相信，所以他想考考牛牛。
 * 在果园里有N堆苹果，每堆苹果的数量为ai，小易希望知道从左往右数第x个苹果是属于哪一堆的。
 * 牛牛觉得这个问题太简单，所以希望你来替他回答
 */
public class 苹果堆数 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int heapNumber = scanner.nextInt();
        int[] apple = new int[heapNumber];
        for (int i = 0; i < heapNumber; i++) {
            apple[i] = scanner.nextInt();
        }
        int queryNumber = scanner.nextInt();
        int[] query = new int[queryNumber];
        for (int i = 0;  i < queryNumber; i++) {
            query[i] = scanner.nextInt();
        }

        int[] appleIndex = new int[apple.length];
        int temp = 0;
        for (int i = 0;  i < apple.length; i++) {
            temp = temp + apple[i];
            appleIndex[i] = temp;
        }

        for (int queryIndex : query) {
            System.out.println(findHead(appleIndex, queryIndex));
        }

        // 5
        //2 7 3 4 9
        //3
        //1 25 11
    }


    private static int findHead(int[] appleIndex, int target) {
        for (int i = 0; i < appleIndex.length; i++) {
            if (target <= appleIndex[i]) {
                return i + 1;
            }
        }
        return -1;
    }


}
