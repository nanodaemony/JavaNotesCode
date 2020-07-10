package com.nano.datastructure.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author nano
 */
public class QuickSort {


	public static void main(String[] args) {
		int[] array = {3, 5, 2, 9, 9, 10, 7, 4, 6, 8, 1, 1, 1, 10};
		quickSort2(array);
		System.out.println(Arrays.toString(array));
	}


	public static void quickSort(int[] array) {
		// Base case
		if (array == null || array.length < 2) return;
		// 传入待排数组和两个边界
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] array, int left, int right) {
		// 仅在没有越界的情况下进行
		if (left < right) {
			// 选择一个随机位置作为pivot并交换到数组末尾
			int randomIndex = left + (int) (Math.random() * (right - left + 1));
			swap(array, randomIndex, right);
			//此数组长度永远为2,p[0]为等于pivot区的左边界，p[1]为等于pivot区的右边界
			int[] equalArray = partition(array, left, right);
			// 将分出来的小于区重复上面的动作
			quickSort(array, left, equalArray[0] - 1);
			// 将分出来的大于区重复上面的动作
			quickSort(array, equalArray[1] + 1, right);
		}
	}

	/**
	 * 对数组进行切分成三部分，最后返回等于的范围
	 *
	 * @param array 数组
	 * @param left  左
	 * @param right 右
	 * @return 等于的范围
	 * 总有一个等于pivot的位置，就是等于pivot自身
	 * 返回等于区域(左边界，右边界), 所以返回一个长度为2的数组res, res[0] res[1]
	 */
	public static int[] partition(int[] array, int left, int right) {
		// 声明一个小于区的索引
		int less = left - 1;
		// 声明一个大于区的索引
		int more = right;
		// 取得pivot值
		int pivot = array[right];
		// left表示当前数的位置 arr[right]->划分值
		while (left < more) {
			// 小于pivot值
			if (array[left] < pivot) {
				swap(array, ++less, left++);
				// 大于pivot值
			} else if (array[left] > pivot) {
				swap(array, --more, left);
			} else {
				left++;
			}
		}
		// 如果index索引与more相遇，则退出循环，并且right位置数与more位置数交换
		swap(array, more, right);
		// 用来记录等于区的左边界和右边界对应的索引
		return new int[]{less + 1, more};
	}

	public static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}


	//--------------------另一个版本-----------------------
	public static void quickSort2(int[] array) {
		if (array == null || array.length < 2) return;
		quickSort2(array, 0, array.length - 1);
	}


	private static void quickSort2(int[] array, int left, int right) {
		if (left < right) {
			int pivot = partition2(array, left, right);
			quickSort2(array, left, pivot - 1);
			quickSort2(array, pivot + 1, right);
		}
	}

	private static int partition2(int[] array, int left, int right) {
		// 挑选一个随机的pivot索引并交换到第一个位置上
		int randomPivot = left + (int) (Math.random() * (right - left + 1));
		swap(array, randomPivot, left);
		// 数组第一个值为pivot值
		int pivotValue = array[left];
		int i = left + 1;
		int j = right;
		while (true) {
			while (i <= j && array[i] <= pivotValue) i++;
			while (i <= j && array[j] >= pivotValue) j--;
			// 数组越界退出
			if (i >= j) break;
			// 交换两个值
			swap(array, i, j);
		}
		// 交换第一个pivot元素和j位置
		swap(array, left, j);
		return j;
	}




    public int select(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (right > left) {
            int pivot = partition2(nums, left, right);
            if (pivot == k) {
                return nums[k];
            } else if (pivot > k) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return nums[k];
    }


}
