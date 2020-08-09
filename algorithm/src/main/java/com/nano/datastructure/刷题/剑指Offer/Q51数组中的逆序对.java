package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/3 19:08
 */
public class Q51数组中的逆序对 {


	private long cnt = 0;
	// 在这里声明辅助数组，而不是在merge()递归函数中声明
	private int[] tmp;

	public int InversePairs(int[] nums) {
		tmp = new int[nums.length];
		// 归并排序
		mergeSort(nums, 0, nums.length - 1);
		return (int) (cnt % 1000000007);
	}

	private void mergeSort(int[] nums, int l, int h) {
		if (h - l < 1)
			return;
		int m = l + (h - l) / 2;
		mergeSort(nums, l, m);
		mergeSort(nums, m + 1, h);
		merge(nums, l, m, h);
	}

	private void merge(int[] nums, int l, int m, int h) {
		int i = l, j = m + 1, k = l;
		while (i <= m || j <= h) {
			if (i > m)
				tmp[k] = nums[j++];
			else if (j > h)
				tmp[k] = nums[i++];
			else if (nums[i] < nums[j])
				tmp[k] = nums[i++];
			else {
				tmp[k] = nums[j++];
				this.cnt += m - i + 1;  // nums[i] >= nums[j]，说明 nums[i...mid] 都大于 nums[j]
			}
			k++;
		}
		for (k = l; k <= h; k++)
			nums[k] = tmp[k];
	}

}
