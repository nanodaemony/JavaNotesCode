package com.nano.datastructure.string;


public class KMP {

    // N >= M

    /**
     * 找到match子串在origin中的下标
     * @param origin 最长字符串
     * @param match 待寻找的子串
     * @return 子串位置 没有返回-1
     */
    public static int getIndexOf(String origin, String match) {
        if (origin == null || match == null || match.length() < 1 || origin.length() < match.length()) {
            return -1;
        }
        char[] originStr = origin.toCharArray();
        char[] matchStr = match.toCharArray();
        // 两个字符串的比对位置
        int originIndex = 0;
        int matchIndex = 0;
        // 找到待匹配子串的最长前缀数组
        int[] nextArr = getNextArray(matchStr); // O (M)
        // O(N)
        // 循环保证不能越界
        while (originIndex < originStr.length && matchIndex < matchStr.length) {
            // 如果两个比对位置相等
            if (originStr[originIndex] == matchStr[matchIndex]) {
                // 比对指针同时后移
                originIndex++;
                matchIndex++;

                // 说明比对子串已经到了第一个位置（人为规定第一个字符的最长前缀为-1）
            } else if (nextArr[matchIndex] == -1) { // str2中比对的位置已经无法往前跳了
                // 原始字符串对比指针往下移动一个
                originIndex++;

                // 表示原始字符串的对比位置不动 match串的对比位置往前跳
            } else {
                // 跳的位置为最长前缀数组的大小值
                matchIndex = nextArr[matchIndex];
            }
        }
        // i1 越界  或者  i2越界了
        return matchIndex == matchStr.length ? originIndex - matchIndex : -1;
    }

    /**
     * 得到待匹配match子串的最长前缀数组
     *
     * @param ms 子串字符数组
     * @return 最长前缀数组
     */
    public static int[] getNextArray(char[] ms) {
        // 人为定义第一个为-1
        if (ms.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        //  人为定义第二个为0
        next[1] = 0;
        int index = 2; // next数组的位置
        // cn指拿哪个位置的字符和i-1的字符比 初始时为0
        int cn = 0;
        while (index < next.length) {
            // 如果对的上说明比前一个多一个
            if (ms[index - 1] == ms[cn]) {
                // index++准备求下一个位置信息
                next[index++] = ++cn;

                // cn往前跳
            } else if (cn > 0) { // 当前跳到cn位置的字符，和i-1位置的字符配不上
                cn = next[cn];
            } else {
                // 表示cn没法往前跳了，这个位置的最长前缀为0
                next[index++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "cc";
        System.out.println(getIndexOf(str, match));

    }

}
