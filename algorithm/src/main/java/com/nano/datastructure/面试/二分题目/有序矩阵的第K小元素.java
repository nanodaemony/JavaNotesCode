package com.nano.datastructure.面试.二分题目;

/**
 * @author: nano
 * @time: 2020/9/13 16:34
 */
public class 有序矩阵的第K小元素 {

	public int kthSmallest(int[][] matrix, int k) {
		int m = matrix.length, n = matrix[0].length;
		// 分别起始为左上角与右下角
		int low = matrix[0][0], high = matrix[m - 1][n - 1];
		while (low <= high) {
			// 中点索引
			int mid = low + (high - low) / 2;
			int cnt = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
					cnt++;
				}
			}
			if (cnt < k) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}

}
