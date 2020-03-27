package com.nano;

import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class Test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String preString = scanner.nextLine();
        int num = scanner.nextInt();
        List<String> resList = new ArrayList<>(num);
        for (int i = 0; i <= num; i++) {
            resList.add(scanner.nextLine());
        }
        resList.stream().filter(s -> s.startsWith(preString))
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }



}
