package com.nano.datastructure.刷题.常考算法代码题;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 发红包算法
 *
 * @author: nano
 * @time: 2020/7/11 15:57
 */
public class RedEnvelope {

	/**
	 * 拆分红包
	 *
	 * @param money    总金额（以分为单位）
	 * @param people 总人数
	 */
	public static List<Integer> divideRedPackage(Integer money, Integer people) {
		List<Integer> moneyList = new ArrayList<>();
		Integer restMoney = money;
		Integer restPeople = people;
		Random random = new Random();
		for (int i = 0; i < people - 1; i++) {
			// 随机范围：[1，剩余人均金额的2倍-1] 单位是:分
			int curMoney = random.nextInt(restMoney / restPeople * 2 - 1) + 1;
			moneyList.add(curMoney);
			restMoney = restMoney - curMoney;
			restPeople--;
		}
		// 最后还剩一份
		moneyList.add(restMoney);
		return moneyList;
	}

	public static void main(String[] args) {
		List<Integer> amountList = divideRedPackage(1000, 10);
		for (Integer amount : amountList) {
			// 由于结果是分，这里转换为元
			System.out.println("抢到金额:" + new BigDecimal(amount).divide(new BigDecimal(100)));
		}
	}

}
