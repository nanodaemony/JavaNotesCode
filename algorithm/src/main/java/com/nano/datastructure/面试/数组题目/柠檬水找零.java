package com.nano.datastructure.面试.数组题目;

/**
 * @author: nano
 * @time: 2020/8/20 20:09
 */
public class 柠檬水找零 {

	public boolean lemonadeChange(int[] bills) {
		int five = 0, ten = 0;
		for (int money: bills) {
			// 支付的5元
			if (money == 5) {
				five++;
				// 支付的10元
			} else if (money == 10) {
				if (five == 0) return false;
				five--;
				ten++;
				// 支付的20元
			} else {
				// 如果5元还有且10元还有,则优先支付10元的
				if (five > 0 && ten > 0) {
					five--;
					ten--;
					// 否则支付3个5元
				} else if (five >= 3) {
					five = five - 3;
				} else {
					// 无法支付
					return false;
				}
			}
		}
		return true;
	}



}
