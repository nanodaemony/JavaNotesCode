package com.nano.datastructure.刷题.字符串;

/**
 * @author: nano
 * @time: 2020/7/16 22:24
 */
public class Q1446字符串中的连续字符 {


	public int maxPower(String str) {

		if(str == null) return 0;
		int res = 1;
		// 字符计数器
		int counter = 1;
		// 上一个字符
		char temp = str.charAt(0);
		for(int i = 1; i < str.length(); i++) {
			// 如果当前的字符与上一个相同
			if(str.charAt(i) == temp) {
				counter++;
			} else {
				// 不同就更新结果并重置计数器
				res = Math.max(res, counter);
				counter = 1;
				temp = str.charAt(i);
			}
		}
		// 最后一定要更新结果，防止出现aaaaa这种记录
		res = Math.max(res, counter);
		return res;
	}

}
