package com.nano.datastructure.面试.数组题目;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: nano
 * @time: 2020/8/19 20:52
 */
public class 矩阵中的最长递增路径长度 {


	Map<Long, Integer> map = new HashMap<>();

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix.length == 0) return 0; // 空数组的处理
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.length; i++) {   // 遍历所有点为起点时的结果
			for (int j = 0; j < matrix[0].length; j++) {
				res = Math.max(res, helper(matrix, i, j));  // 更新res
			}
		}
		return res;
	}

	public int helper(int[][] matrix, int i, int j) {
		// 计算以当前坐标为起点的组合键
		long key = (long) i << 32 | j;
		// 如果当前答案已经计算过
		if (map.containsKey(key)) return map.get(key);
		int ans = 1;
		// 向上
		if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j])
			ans = Math.max(ans, helper(matrix, i - 1, j) + 1);
		// 向下
		if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j])
			ans = Math.max(ans, helper(matrix, i + 1, j) + 1);
		// 向左
		if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j])
			ans = Math.max(ans, helper(matrix, i, j - 1) + 1);
		// 向右
		if (j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j])
			ans = Math.max(ans, helper(matrix, i, j + 1) + 1);
		map.put(key, ans);//记录当前答案
		return ans;
	}
}
