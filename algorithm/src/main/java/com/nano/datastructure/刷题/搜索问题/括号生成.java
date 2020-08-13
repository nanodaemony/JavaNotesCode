package com.nano.datastructure.刷题.搜索问题;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/solution/jian-dan-dfsmiao-dong-by-sweetiee/
 *
 * @author: nano
 * @time: 2020/8/13 17:04
 */
public class 括号生成 {


	List<String> resList = new ArrayList<>();

	public List<String> generateParenthesis(int n) {
		if (n == 0) return resList;
		// 执行深度优先遍历，搜索可能的结果
		dfs("", n, n);
		return resList;
	}

	/**
	 * @param tempStr 当前递归得到的结果
	 * @param left   左括号还有几个可以使用
	 * @param right  右括号还有几个可以使用
	 */
	private void dfs(String tempStr, int left, int right) {
		// 因为每一次尝试，都使用新的字符串变量，所以无需回溯
		// 在递归终止的时候，直接把它添加到结果集即可
		if (left == 0 && right == 0) {
			resList.add(tempStr);
			return;
		}

		// 剪枝（左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
		if (left > right) return;

		if (left > 0) dfs(tempStr + "(", left - 1, right);
		if (right > 0) dfs(tempStr + ")", left, right - 1);
	}

}
