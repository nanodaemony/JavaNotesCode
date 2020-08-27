package com.nano.datastructure.面试.贪心问题;

import java.util.Arrays;

/**
 * @author: nano
 * @time: 2020/8/26 21:16
 */
public class 分配饼干 {

	public int findContentChildren(int[] child, int[] nice) {
		// 先排个序
		Arrays.sort(child);
		Arrays.sort(nice);
		int gi = 0, si = 0;
		// 都没越界才行
		while (gi < child.length && si < nice.length) {
			// 如果当前饼干满意度大于孩子的期望就移动说明合格一个
			if (child[gi] <= nice[si]) {
				gi++;
			}
			// 移动饼干指针
			si++;
		}
		// 返回满意的孩子数
		return gi;
	}

}
