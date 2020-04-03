package com.nano.datastructure.sort;

/**
 * 堆排序
 * @author nano
 */
public class HeapSort {
    public static void heapSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        // 这一步是不断取元素构造大顶堆 构建完成之后堆值并不是完全有序的
        for (int i = 0; i < array.length; i++) {
            heapInsert(array, i);
        }
        // 当前size等于数组大小 size表示结构的大小
        int size = array.length;
        // 交换堆的对顶元素与最后一个元素
        swap(array, 0, --size);
        // 不断把堆顶元素与最后一个元素进行交换 然后进行下沉
        while (size > 0) {
            // 重组堆使其满足大顶堆
            sink(array, 0, size);
            // 再交换堆顶与最后一个元素
            swap(array, 0, --size);
        }
    }

    /**
     * 将元素插入堆并进行上浮
     *
     * @param array 数组
     * @param index 索引
     */
    public static void heapInsert(int[] array, int index) {
        // 如果子节点元素比父节点小就交换
        while (array[index] > array[(index - 1) / 2]) {
            swap(array, index, (index - 1) / 2);
            // 索引变成父节点索引
            index = (index - 1) / 2;
        }
    }

    /**
     * 堆顶元素下沉操作
     *
     * @param array 数组
     * @param index 索引
     * @param size 堆的大小
     */
    private static void sink(int[] array, int index, int size) {
        // 左子节点
        int left = index * 2 + 1;
        while (left < size) {

            int largest = left + 1 < size && array[left + 1] > array[left] ? left + 1 : left;
            largest = array[largest] > array[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(array, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
