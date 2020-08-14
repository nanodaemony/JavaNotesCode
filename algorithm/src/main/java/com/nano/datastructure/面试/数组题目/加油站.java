package com.nano.datastructure.面试.数组题目;

/**
 * @author: nano
 * @time: 2020/8/14 22:19
 */
public class 加油站 {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int len = gas.length;
		// 总油量
		int sumTank = 0;
		// 当前油箱内的油量
		int curTank = 0;
		int startStation = 0;
		for (int i = 0; i < len; i++) {
			sumTank += gas[i] - cost[i];
			curTank += gas[i] - cost[i];
			if (curTank < 0) {
				startStation = i + 1;
				curTank = 0;
			}
		}
		return sumTank >= 0 ? startStation : -1;
	}

}
