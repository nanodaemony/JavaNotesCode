package com.nano.datastructure.面试.双指针题目;

/**
 * @author: nano
 * @time: 2020/8/14 16:36
 */
public class 合并两个有序数组 {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// 找到nums1中从后向前插入的位置
		int index = m + n - 1;
		// 双指针分别指向数组末尾
		int p1 = m - 1;
		int p2 = n - 1;
		// 将数组nums2全部数据插入到数组nums1为止
		while (p2 >= 0) {
			// p1位置有效且p1值较大
			if(p1 >= 0 && nums1[p1] >= nums2[p2]) {
				nums1[index] = nums1[p1];
				p1--;
			} else {
				nums1[index] = nums2[p2];
				p2--;
			}
			// 从右往左移动index
			index--;
		}
	}


}
