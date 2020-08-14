package com.nano.datastructure.面试.其他;

import java.util.Arrays;

/**
 * @author: nano
 * @time: 2020/8/14 17:22
 */
public class 堆与TopK {


	// 构建大根堆:将array看成完全二叉树的顺序存储结构
	private static int[] buildMaxHeap(int[] array) {
		// 从最后一个节点array.length - 1的父节点(array.length - 1 - 1）/ 2开始
		// 直到根节点0,反复调整堆
		for (int i = (array.length - 2) / 2; i >= 0; i--) {
			adjustDownToUp(array, i, array.length);
		}
		return array;
	}

	// 将元素array[k]自下往上逐步调整树形结构
	private static void adjustDownToUp(int[] array, int k, int length) {
		int temp = array[k];
		for (int i = 2 * k + 1; i < length - 1; i = 2 * i + 1) {
			// i为初始化为节点k的左孩子,沿节点较大的子节点向下调整
			if (i < length && array[i] < array[i + 1]) {
				// 取节点较大的子节点的下标
				i++;   // 如果节点的右孩子>左孩子,则取右孩子节点的下标
			}
			if (temp >= array[i]) {  // 根节点 >=左右子女中关键字较大者,调整结束
				break;
			} else {   // 根节点 <左右子女中关键字较大者
				array[k] = array[i]; // 将左右子结点中较大值array[i]调整到双亲节点上
				k = i; // 【关键】修改k值,以便继续向下调整
			}
		}
		array[k] = temp;  // 被调整的结点的值放人最终位置
	}


	/**
	 * 堆排序
	 */
	public static int[] heapSort(int[] array) {
		// 初始化堆
		array = buildMaxHeap(array);
		for (int i = array.length - 1; i > 1; i--) {
			// 将堆顶元素和堆底元素交换,即得到当前最大元素正确的排序位置
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			// 整理,将剩余的元素整理成堆
			adjustDownToUp(array, 0, i);
		}
		return array;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(heapSort(new int[]{3, 4, 2, 6, 2, 5})));
	}


	public static int[] findMin(int[] array, int[] all) {
		array = buildMaxHeap(array);
		// 前面100个数字(0-99号)已经取出了
		for (int i = 100; i < all.length - 1; i++) {
			if (all[i] >= array[0]) {
				continue;
			} else {
				array[0] = all[i];
				adjustDownToUp(array, 0, array.length);
			}
		}
		return array;
	}

}
