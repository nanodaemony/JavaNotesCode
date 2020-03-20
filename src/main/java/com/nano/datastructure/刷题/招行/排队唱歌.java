package com.nano.datastructure.刷题.招行;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 招行
 * @author nano
 */
public class 排队唱歌 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> dataList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            dataList.add(sc.nextInt());
        }

        dataList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int res = 0;
        for (int i = 0; i < dataList.size(); i++) {
            res = res + Math.abs(dataList.get(i) - 1 - i);
        }

        System.out.println(res);
    }
}
