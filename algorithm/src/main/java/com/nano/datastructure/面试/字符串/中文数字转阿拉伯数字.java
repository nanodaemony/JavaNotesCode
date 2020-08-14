package com.nano.datastructure.面试.字符串;

/**
 * @author: nano
 * @time: 2020/8/14 22:34
 */
public class 中文数字转阿拉伯数字 {


	static char[] cnArr = {'零','一', '二', '三', '四', '五', '六', '七', '八', '九'};
	static char[] chArr = {'十', '百', '千', '万', '亿'};
	public static int chineseNumToArabicNum(String chineseNum) {
		int result = 0;
		// 存放一个单位的数字如：十万
		int temp = 1;
		// 判断是否有表示单位的文字
		int count = 0;
		for (int i = 0; i < chineseNum.length(); i++) {
			boolean b = true;// 判断是否是单位
			char c = chineseNum.charAt(i);
			for (int j = 0; j < cnArr.length; j++) {  // 非单位，即数字
				if (c == cnArr[j]) {
					if (count != 0) { // 添加下一个单位之前，先把上一个单位值添加到结果中
						result += temp;
						temp = 1;
						count = 0;
					}
					// 下标+1，就是对应的值
					temp = j;
					b = false;
					break;
				}
			}
			if (b) {  // 单位{'十','百','千','万','亿'}
				for (int j = 0; j < chArr.length; j++) {
					if (c == chArr[j]) {
						switch (j) {
							case 0:
								temp *= 10;
								break;
							case 1:
								temp *= 100;
								break;
							case 2:
								temp *= 1000;
								break;
							case 3:
								temp *= 10000;
								break;
							case 4:
								temp *= 100000000;
								break;
							default:
								break;
						}
						count++;
					}
				}
			}
			if (i == chineseNum.length() - 1) {  // 遍历到最后一个字符
				result += temp;
			}
		}
		return result;
	}

}
