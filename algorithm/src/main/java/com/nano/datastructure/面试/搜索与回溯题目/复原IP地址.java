package com.nano.datastructure.面试.搜索与回溯题目;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/21 14:17
 */
public class 复原IP地址 {

	private List<String> resList = new ArrayList<>();

	public List<String> restoreIpAddresses(String str) {
		// 记录IP划分的路径
		StringBuilder addressPath = new StringBuilder();
		// 记录当前划分的次数
		int k = 0;
		backtrack(k, addressPath, str);
		return resList;
	}

	private void backtrack(int k, StringBuilder addressPath, String str) {
		// 如果划分次数到了4次或者str已经划分到没有了就判断是否是正确结果
		if (k == 4 || str.length() == 0) {
			if (k == 4 && str.length() == 0) {
				// 合格情况
				resList.add(addressPath.toString());
			}
			return;
		}
		// 分别考虑每个IP段长度为123个字符串
		for (int i = 0; (i < str.length() && i <= 2); i++) {
			// 当这个IP段的长度不为1但是又是0开头,后面的剪枝不管了
			if (i != 0 && str.charAt(0) == '0') {
				break;
			}
			// 取出长度为1或2或3的字符串为当前的IP段
			String temp = str.substring(0, i + 1);
			// 如果范围是0-255表示合格
			if (Integer.parseInt(temp) <= 255) {
				// 这里判断当前子段是否是第一个IP段
				if (addressPath.length() != 0) {
					temp = "." + temp;
				}
				// 加入到路径中
				addressPath.append(temp);
				// 回溯继续查找
				backtrack(k + 1, addressPath, str.substring(i + 1));
				// 撤消之前的选择(删除之前添加的字符串)
				addressPath.delete(addressPath.length() - temp.length(), addressPath.length());
			}
		}
	}

}
