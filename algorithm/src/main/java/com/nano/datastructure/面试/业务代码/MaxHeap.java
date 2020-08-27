package com.nano.datastructure.面试.业务代码;

import java.util.ArrayList;

/**
 * @author: nano
 * @time: 2020/8/21 23:27
 */
public class MaxHeap {

	// 存储元素的数组
	private int[] data;
	// 元素个数
	private int capacity = 0;

	public MaxHeap(int cap) {
		// 索引0不用，所以多分配一个空间
		data = new int[cap + 1];
	}

	// 返回当前队列中最大元素
	public int max() {
		return data[1];
	}

	// 插入元素
	public void insert(int num) {
		capacity++;
		// 先把新元素加到最后
		data[capacity] = num;
		// 然后让它上浮到正确的位置
		swim(capacity);
	}

	// 删除并返回当前队列中最大元素
	public int delMax() {
		// 最大堆的堆顶就是最大元素
		int max = data[1];
		// 把这个最大元素换到最后，删除之
		swap(1, capacity);
		// 元素置0模拟删除
		data[capacity] = 0;
		capacity--;
		// 让pq[1]下沉到正确位置
		sink(1);
		return max;
	}

	// 上浮元素
	private void swim(int index) {
		// 如果浮到堆顶,就不能再上浮
		while (index > 1 && data[index] > data[parent(index)]) {
			// 如果第index个元素比上层大,将index换上去
			swap(parent(index), index);
			// 替换index
			index = parent(index);
		}
	}

	// 下沉第index个元素,以维护最大堆性质
	private void sink(int index) {
		// 如果沉到堆底,就沉不下去了
		while (left(index) <= capacity) {
			// 先假设左边节点较大
			int older = left(index);
			// 如果右边节点存在,比一下大小
			if (right(index) <= capacity && data[right(index)] > data[older]) {
				// 现在右边是较大的结点
				older = right(index);
			}
			// 结点index比俩孩子都大,就不必下沉了
			if (data[index] > data[older]) break;
			// 否则与较大的一边交换,下沉index结点
			swap(index, older);
			// 下沉索引为较大的结点的索引
			index = older;
		}
	}

	// 交换数组的两个元素
	private void swap(int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	// 父节点的索引
	int parent(int root) {
		return root / 2;
	}

	// 左孩子的索引
	int left(int root) {
		return root * 2;
	}

	// 右孩子的索引
	int right(int root) {
		return root * 2 + 1;
	}

}
