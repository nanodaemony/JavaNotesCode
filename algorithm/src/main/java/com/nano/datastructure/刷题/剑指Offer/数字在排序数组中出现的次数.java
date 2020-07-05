package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/3 19:19
 */
public class 数字在排序数组中出现的次数 {



	public int search(int[] nums, int target) {
		// 用二分查找k-0.5、k+0.5两数应该插入的位置，相减即次数
		return binarySearch(nums, target + 0.5) - binarySearch(nums, target - 0.5);
	}

	private int binarySearch(int[] nums, double target) {
		int left = 0, right = nums.length - 1;
		// 迭代二分
		while (left <= right) {
			int mid = (right + left) >>> 1;
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			}
		}
		return left;
	}



	public int search2(int[] nums, int target) {
		return rightBound(nums, target) - leftBound(nums, target) + 1;
	}

	// 第一次出现的下标或者第一个比target大的下标
	private int leftBound(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) >>> 1;
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] >= target) {
				right = mid - 1;
			}
		}
		return left;
	}

	// 最后一次出现的下标或者第一个比target小的下标
	private int rightBound(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) >>> 1;
			if (nums[mid] <= target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			}
		}
		return right;
	}

}
