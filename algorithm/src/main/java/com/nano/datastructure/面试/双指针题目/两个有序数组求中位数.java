package com.nano.datastructure.面试.双指针题目;

/**
 * @author: nano
 * @time: 2020/8/25 22:29
 */
public class 两个有序数组求中位数 {


	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int total = len1 + len2;
		int left = (total + 1) / 2;
		int right = (total + 2) / 2;
		return (findK(nums1, 0, nums2, 0, left) + findK(nums1, 0, nums2, 0, right)) / 2.0;

	}

	// 找到两个数组中第k小的元素
	public int findK(int[] nums1, int i, int[] nums2, int j, int k) {
		if (i >= nums1.length) return nums2[j + k - 1];
		if (j >= nums2.length) return nums1[i + k - 1];
		if (k == 1) {
			return Math.min(nums1[i], nums2[j]);
		}
		// 计算出每次要比较的两个数的值，来决定"删除""哪边的元素
		int mid1 = (i + k / 2 - 1) < nums1.length ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
		int mid2 = (j + k / 2 - 1) < nums2.length ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
		// 通过递归的方式来模拟删除掉前K/2个元素
		if (mid1 < mid2) {
			return findK(nums1, i + k / 2, nums2, j, k - k / 2);
		}
		return findK(nums1, i, nums2, j + k / 2, k - k / 2);
	}


}
