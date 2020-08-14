package com.nano.datastructure.面试.其他;

/**
 * @author: nano
 * @time: 2020/8/14 21:55
 */
public class 求平方根 {

	/**
	 * 二分法：n为数字，e为精度
	 */
	public static float sqrt(float num, float e) {
		float x = 0;
		if (num > 0 && e > 0) {
			float low = 0;
			float high = num;
			while (low < high) {
				float mid = (low + high) / 2;
				if (mid * mid < num - e) {
					low = mid;
				} else if (mid * mid > num + e) {
					high = mid;
				} else {
					x = mid;
					break;
				}
			}
		}
		return x;
	}


}
