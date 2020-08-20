package com.nano.datastructure.面试.数组题目;

/**
 * @author: nano
 * @time: 2020/8/19 20:59
 */
public class 放苹果的方法数 {


	public int appleNum(int apple, int plate) {

		// Base case
		// 当没有苹果可放的时候,只存在一种情况,那就是盘子全为空
		// 当只剩下一个盘子的时候,也只有一种情况,就是所有的果子都放在这个盘子里
		if (apple == 0 || plate == 1) return 1;
		// 当盘子的数量比苹果多的时候
		if(plate > apple) {
			return appleNum(apple, plate);
		} else {
			// 第一种情况,至少存在一个空盘子,所以拿去那个空盘子
			// 第二种情况,每个盘子里都有苹果,那么每个盘子里拿掉一个苹果
			return appleNum(apple, plate - 1) + appleNum(apple - plate, plate);
		}
	}


}