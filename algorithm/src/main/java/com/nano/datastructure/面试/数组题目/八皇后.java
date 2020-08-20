package com.nano.datastructure.面试.数组题目;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/20 15:13
 */
public class 八皇后 {

	private List<List<String>> resList;
	private List<String> solution;
	private int[] queue;
	private int N;

	public List<List<String>> solveNQueens(int n) {
		//递归回溯
		resList = new ArrayList<>();
		N = n;
		queue = new int[n];
		search(0);
		return resList;
	}

	// cur为当前行数
	private void search(int cur) {
		if (cur == N) { //找到一种解法
			solution = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringBuffer col = new StringBuffer();
				for (int j = 0; j < N; j++) {
					if (queue[i] == j)
						col.append('Q'); // 是皇后
					else
						col.append('.');
				}
				solution.add(col.toString());
			}
			resList.add(solution);
		} else {
			if (cur == 0) {
				//初始化皇后数组
				for (int i = 0; i < N; i++) {
					queue[i] = -1;
				}
			}
			for (int i = 0; i < N; i++) { // 尝试把皇后放在（cur，i）位置
				int j;
				for (j = 0; j < cur; j++) { // 已经摆放的皇后（j, que[j])
					// 和已经摆放的皇后比较
					if (queue[j] == i || cur + i == j + queue[j] || cur - i == j - queue[j]) { //冲突
						break;// 跳出循环，不需要继续比较
					}
				}
				if (j == cur) {// 没有冲突，可以摆放
					queue[cur] = i;// 记录皇后位置
					search(cur + 1);// 继续寻找下一行
					// 回溯
					queue[cur] = -1;// 清除位置
				}
			}
		}
	}

}


