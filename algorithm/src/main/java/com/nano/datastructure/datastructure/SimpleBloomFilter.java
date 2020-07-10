package com.nano.datastructure.datastructure;

import java.util.BitSet;

/**
 * 自定义布隆过滤器
 *
 * @author: nano
 * @time: 2020/7/9 20:33
 */
public class SimpleBloomFilter {

	// 位数组的大小
	private static final int DEFAULT_SIZE = 2 << 24;

	// 通过这个数组可以创建 6 个不同的哈希函数
	private static final int[] SEEDS = new int[]{3, 13, 46, 71, 91, 134};

	// 位数组。数组中的元素只能是 0 或者 1
	private BitSet bits = new BitSet(DEFAULT_SIZE);

	// 存放包含hash函数的类的数组
	private SimpleHash[] hashFuncs = new SimpleHash[SEEDS.length];

	// 初始化多个包含hash函数的类的数组，每个类中的hash函数都不一样
	public SimpleBloomFilter() {
		// 初始化多个不同的 Hash 函数
		for (int i = 0; i < SEEDS.length; i++) {
			hashFuncs[i] = new SimpleHash(DEFAULT_SIZE, SEEDS[i]);
		}
	}

	/**
	 * 添加元素到位数组
	 */
	public void add(Object value) {
		for (SimpleHash func : hashFuncs) {
			bits.set(func.hash(value), true);
		}
	}

	/**
	 * 判断指定元素是否存在于位数组
	 */
	public boolean contains(Object value) {
		boolean contains = true;
		for (SimpleHash f : hashFuncs) {
			contains = contains && bits.get(f.hash(value));
		}
		return contains;
	}

	/**
	 * 静态内部类。用于hash操作
	 */
	public static class SimpleHash {

		private int cap;
		private int seed;

		public SimpleHash(int cap, int seed) {
			this.cap = cap;
			this.seed = seed;
		}

		/**
		 * 计算hash值
		 */
		public int hash(Object value) {
			int h;
			return (value == null) ? 0 : Math.abs(seed * (cap - 1) & ((h = value.hashCode()) ^ (h >>> 16)));
		}
	}

	public static void main(String[] args) {
		String value1 = "https://www.baidu.cn/";
		String value2 = "https://www.sina.com";
		SimpleBloomFilter filter = new SimpleBloomFilter();
		System.out.println(filter.contains(value1));
		System.out.println(filter.contains(value2));
		filter.add(value1);
		filter.add(value2);
		System.out.println(filter.contains(value1));
		System.out.println(filter.contains(value2));
	}
}
