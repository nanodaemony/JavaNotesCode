package com.nano.datastructure.刷题.剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: nano
 * @time: 2020/7/2 15:22
 */
public class Q38字符串的排列 {

	private ArrayList<String> resList = new ArrayList<>();
	private char[] chars;
	private StringBuilder s;

	public ArrayList<String> permutation(String str) {
		// Base case
		if (str.length() == 0) return resList;
		// 得到所有的字符数组
		chars = str.toCharArray();
		// 排个序
		Arrays.sort(chars);
		// 回溯得到结果 初始化一个Boolean数组用于标记是否已经遍历过
		backTrace(new boolean[chars.length]);
		return resList;
	}

	private void backTrace(boolean[] hasUsed) {

		// 这时候刚好全部涵盖则记录一次结果
		if (s.length() == chars.length) {
			resList.add(s.toString());
			return;
		}
		// 以每个字符为开头进行回溯
		for (int i = 0; i < chars.length; i++) {
			// 如果该索引位置已经使用就继续
			if (hasUsed[i]) continue;
			// 保证不重复
			if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) continue;
			// 记录这个位置已经访问
			hasUsed[i] = true;
			// 加入字符串末尾
			s.append(chars[i]);
			// 回溯
			backTrace(hasUsed);
			// 这一步？？？
			s.deleteCharAt(s.length() - 1);
			// 清除标记
			hasUsed[i] = false;
		}
	}


	//--------------------Version2-----------------------------
	Set<String> ans;

	public String[] permutation2(String s) {
		char[] array = s.toCharArray();
		ans = new HashSet<>();
		dfs(0, array);
		return ans.toArray(new String[ans.size()]);

	}

	//与其说是递归，不如说是树形遍历
	void dfs(int position, char[] arr) {
		// 位置到了末端
		if (position == arr.length)
			ans.add(String.valueOf(arr));
		for (int i = position; i < arr.length; i++) {
			// 对数组swap的过程就是排列的过程，
			// 在for循环中swap，每次swap后，就会有新的元素排在第一位
			swap(arr, position, i);
			dfs(position + 1, arr);
			// 交换回来
			swap(arr, position, i);
		}
	}

	void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


}
