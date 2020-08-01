package com.nano.datastructure.刷题.数组与矩阵;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: nano
 * @time: 2020/7/22 15:27
 */
public class Q1512好数对的数目 {

	public int numIdenticalPairs(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// 放入Map中并记录每个数字出现的次数
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		int ans = 0;
		for (int value : map.values()) {
			ans = ans + value * (value - 1) / 2;
		}

		return ans;
	}

	public int numIdenticalPairs2(int[] nums) {
		int[] temp = new int[101];
		int ans = 0;
		for (int num : nums) {
			// temp[num]存放的就是满足条件1的数目
			temp[num]++;
			//t emp[num]-1理解为：满足条件1的好数对的数目。只不过这里的求值过程为倒序的
			ans += temp[num] - 1;
		}


		return ans;

	}


}
