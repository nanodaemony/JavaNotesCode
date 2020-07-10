package com.nano.datastructure.刷题.数组与矩阵;

/**
 * @author: nano
 * @time: 2020/7/7 15:20
 */
public class Q670最大交换 {

	public int maximumSwap(int num) {
		// 将数字转为char数组
		char[] charArray = String.valueOf(num).toCharArray();
		// 最大值
		int max = Integer.MIN_VALUE;
		// 最大值所在索引
		int maxIndex = 0;
		// 初始化一个数组并拷贝这个数的个位
		int [] array = new int[charArray.length];
		array[charArray.length - 1] = charArray.length - 1;

		// 从个位往高位遍历（逆序遍历）
		for (int i = charArray.length - 1; i >= 0; i--) {
			// char运算！！！
			if (charArray[i] - '0' > max) {
				// 更新最大值数值和最大值指针
				max = charArray[i] - '0';
				maxIndex = i;
			}
			array[i] = maxIndex;
		}
		// 正向遍历找到第一个符合条件的交换元素
		for (int i = 0; i < charArray.length; i ++) {
			if (array[i] != i && charArray[array[i]] != charArray[i]) {
				char tmp = charArray[i];
				charArray[i] = charArray[array[i]];
				charArray[array[i]] = tmp;
				break;
			}
		}
		return Integer.parseInt(new String(charArray));
	}

}
