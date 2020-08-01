package com.nano.datastructure.刷题.字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/7/17 12:26
 */
public class Q1408数组中的字符串匹配 {


	public List<String> stringMatching(String[] words) {
		List<String> resList = new ArrayList<String>();
		StringBuffer buffer = new StringBuffer();
		// 将字符串全部拼接
		for (int i = 0; i < words.length; i++) {
			buffer.append(words[i]);
			buffer.append(",");
		}
		// 寻找某个单词的前后出现索引，不相同则说明包含子串
		for (int i = 0; i < words.length; i++) {
			if (buffer.indexOf(words[i]) != buffer.lastIndexOf(words[i])) {
				resList.add(words[i]);
			}
		}
		return resList;
	}


}
