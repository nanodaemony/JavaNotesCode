package com.nano.datastructure.面试.搜索与回溯题目;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/26 13:48
 */
public class 分割回文串 {

	private List<List<String>> resList = new ArrayList<>();
	public List<List<String>> partition(String str) {
		int len = str.length();
		if (len == 0) return resList;

		// 注意只使用stack相关的接口
		Deque<String> stack = new ArrayDeque<>();
		backtracking(str, 0, len, stack);
		return resList;
	}

	private void backtracking(String str, int start, int len, Deque<String> path) {
		// 长度刚好等于这么多
		if (start == len) {
			resList.add(new ArrayList<>(path));
			return;
		}

		for (int i = start; i < len; i++) {

			// 因为截取字符串是消耗性能的,因此采用传子串索引的方式判断一个子串是否是回文子串
			// 不是的话则剪枝,也就是后面的不用判断了
			if (!checkPalindrome(str, start, i)) {
				continue;
			}
			// 选择当前路径
			path.addLast(str.substring(start, i + 1));
			backtracking(str, i + 1, len, path);
			// 撤消选择
			path.removeLast();
		}
	}

	/**
	 * 这一步的时间复杂度是O(N),因此可以采用动态规划先把回文子串的结果记录在一个表格里
	 */
	private boolean checkPalindrome(String str, int left, int right) {
		// 严格小于即可
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) return false;
			left++;
			right--;
		}
		return true;
	}



	//-----------------回溯+动态规划-------------------------
	private List<List<String>> res = new ArrayList<>();
	public List<List<String>> partition2(String str) {
		int len = str.length();
		if (len == 0) return res;
		// 预处理,dp[i][j]表示s[i][j]是否是回文
		boolean[][] dp = new boolean[len][len];
		// 状态转移方程:在s[i] == s[j]时,dp[i][j]参考dp[i + 1][j - 1]
		for (int i = 0; i < len; i++) {
			// 注意:j <= i取等号表示1个字符的时候也需要判断
			for (int j = 0; j <= i; j++) {
				if (str.charAt(j) == str.charAt(i) && (i - j <= 2 || dp[j + 1][i - 1])) {
					dp[j][i] = true;
				}
			}
		}
		Deque<String> stack = new ArrayDeque<>();
		backtracking(str, 0, len, dp, stack);
		return res;
	}

	private void backtracking(String s, int start, int len, boolean[][] dp, Deque<String> path) {
		if (start == len) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = start; i < len; i++) {
			// 剪枝
			if (!dp[start][i]) {
				continue;
			}
			path.addLast(s.substring(start, i + 1));
			backtracking(s, i + 1, len, dp, path);
			path.removeLast();
		}
	}


}
