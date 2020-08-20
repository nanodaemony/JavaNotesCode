package com.nano.datastructure.面试.数组题目;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: nano
 * @time: 2020/8/14 22:03
 */
public class 螺旋打印矩阵 {


	/**
	 * 根据N生成一个螺旋数组
	 */
	public static int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		// 上下左右四个边界
		int left = 0, right = n - 1, up = 0, down = n - 1;
		// 直到num小于平方
		int num = 1;
		while (num <= n * n) {
			// 从左往右
			for (int i = left; i <= right; i++) {
				res[up][i] = num;
				num++;
			}
			up++;
			// 从上往下
			for (int i = up; i <= down; i++) {
				res[i][right] = num;
				num++;
			}
			right--;
			// 从左往右
			for (int i = right; i >= left; i--) {
				res[down][i] = num;
				num++;
			}
			down--;
			// 从下到上
			for (int i = down; i >= up; i--) {
				res[i][left] = num;
				num++;
			}
			left++;
		}
		return res;
	}



	/**
	 * 根据已有M*N的矩阵打印
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> resList = new ArrayList<>();
		if (matrix == null || matrix.length == 0) return resList;
		// 上下左右四个指针
		int left = 0;
		int up = 0;
		int down = matrix.length - 1;
		int right = matrix[0].length - 1;
		// 多于两行才进行打印
		while (left < down && up < right) {
			for (int i = up; i < right; i++) resList.add(matrix[left][i]);	// 从左到右
			for (int i = left; i < down; i++) resList.add(matrix[i][right]);// 从上到下
			for (int i = right; i > up; i--) resList.add(matrix[down][i]);	// 从右往左
			for (int i = down; i > left; i--) resList.add(matrix[i][up]);	// 从下到上
			left++;
			down--;
			up++;
			right--;
		}
		// 只有一行时
		if (up == right) {
			while (left <= down) {
				resList.add(matrix[left++][up]);
			}
		} else {
			// 只有一列时
			if (left == down) {
				while (up <= right) {
					resList.add(matrix[left][up++]);
				}
			}
		}
		return resList;
	}


	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int m = scanner.nextInt();
		int n = scanner.nextInt();
		System.out.println(Arrays.deepToString(generateMatrix(m, n)));
	}

	// 生成一个M*N的数组
	public static int[][] generateMatrix(int m, int n) {
		int[][] matrix = new int[m][n];
		// 上下左右四个指针
		int left = 0;
		int up = 0;
		int down = matrix.length - 1;
		int right = matrix[0].length - 1;
		int num = 1;
		// 多于两行才进行打印
		while (left < down && up < right) {
			for (int i = up; i < right; i++) matrix[left][i] = num++;
			for (int i = left; i < down; i++) matrix[i][right] = num++;
			for (int i = right; i > up; i--) matrix[down][i] = num++;
			for (int i = down; i > left; i--) matrix[i][up] = num++;
			left++;
			down--;
			up++;
			right--;
		}
		// 只有一行时
		if (up == right) {
			while (left <= down) {
				matrix[left++][up] = num++;
			}
		} else {
			// 只有一列时
			if (left == down) {
				while (up <= right) {
					matrix[left][up++] = num++;
				}
			}
		}
		return matrix;
	}


}
