package com.nano.datastructure.面试.动态规划;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: nano
 * @time: 2020/8/21 13:44
 */
public class 单词拆分 {


	public Set<String> set = new HashSet<>();

	public boolean wordBreak(String str, List<String> wordDict) {
		// 初始化dp
		boolean[] dp = new boolean[str.length() + 1];
		dp[0] = true;

		// 构建一个哈希表方便check
		set.addAll(wordDict);

		// 从左往右遍历
		for (int j = 1; j <= str.length(); j++) {
			// 从当前位置往前找
			for (int i = j - 1; i >= 0; i--) {
				// 往前寻找一个dp[i]位置为true且当前i到j范围内的子串在集合内的位置,能够找到就马上退出
				dp[j] = dp[i] && set.contains(str.substring(i, j));
				// 直到dp[j]能行则退出当前循环
				if (dp[j]) break;
			}
		}
		return dp[str.length()];
	}

}
