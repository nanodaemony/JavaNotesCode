package com.nano.datastructure.刷题.字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: nano
 * @time: 2020/8/13 18:37
 */
public class 最长不重复子串 {


	public int lengthOfLongestSubstring2(String str) {

		Map<Character, Integer> dic = new HashMap<>();
		int temp = -1, res = 0;

		for(int i = 0; i < str.length(); i++) {
			// 如果map中已经包含这个字符则更新左指针 i
			if(dic.containsKey(str.charAt(i))) {
				// 更新左指针
				temp = Math.max(temp, dic.get(str.charAt(i)));
			}
			// 哈希表记录
			dic.put(str.charAt(i), i);
			// 更新最大长度
			res = Math.max(res, i - temp);
		}
		return res;
	}

	public int lengthOfLongestSubstring(String s) {
		// 存放结果
		int res = 0, tmp = 0;
		// 遍历一次
		for (int j = 0; j < s.length(); j++) {
			// 从j的前一个元素开始找
			int i = j - 1;
			// 线性查找,直到找到与j位置相同的索引i或者找到开始处
			while (i >= 0 && s.charAt(i) != s.charAt(j)) i--;
			// 滚动更新temp,dp[j - 1] -> dp[j]
			tmp = tmp < j - i ? tmp + 1 : j - i;
			// 更新res，max(dp[j - 1], dp[j])
			res = Math.max(res, tmp);
		}
		return res;
	}


}
