package com.nano.datastructure.面试.字符串;

/**
 * @author: nano
 * @time: 2020/8/21 12:37
 */
public class 版本号比较 {

	public int compareVersion(String version1, String version2) {

		// 注意这里需要转义
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		// 两个都遍历完才算完成
		for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
			// 缺少的就用0比较
			int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
			int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
			if (num1 > num2) {
				return 1;
			} else if (num1 < num2) {
				return -1;
			}
		}
		// 全部相等
		return 0;
	}


}
