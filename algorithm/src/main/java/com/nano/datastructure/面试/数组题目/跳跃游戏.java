package com.nano.datastructure.面试.数组题目;

/**
 * @author: nano
 * @time: 2020/8/14 16:24
 */
public class 跳跃游戏 {

	public boolean canJump(int[] nums) {
		int n = nums.length;
		int rightmost = 0;
		for (int i = 0; i < n; ++i) {
			if (i <= rightmost) {
				rightmost = Math.max(rightmost, i + nums[i]);
				if (rightmost >= n - 1) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean canJump2(int[] nums) {
		// 数组第一个元素为0且数组元素大于一个的时候，必定不能到达
		if (nums[0] == 0 && nums.length > 1) return false;
		// 未跳过的0的数量
		int zeroCounter = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == 0) {
				// 遇到0，未跳过的0计数+1
				zeroCounter++;
				for (int j = 0; j < i; j++) {
					if (nums[j] >= i - j + 1) {
						// 如果遇到的这个0前面有数字可以跳过它，那么未跳过的0计数-1
						zeroCounter--;
						// 跳过之后就去寻找下一个0
						break;
					}
				}
			}
		}
		// 如果所有的0都能跳过，那么未跳过的0计数为0，返回true
		if (zeroCounter == 0) {
			return true;
		} else {
			return false;
		}
	}

}
