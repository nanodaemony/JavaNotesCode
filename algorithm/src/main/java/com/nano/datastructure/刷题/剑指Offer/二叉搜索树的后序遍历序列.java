package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/1 20:27
 */
public class 二叉搜索树的后序遍历序列 {

	public boolean VerifySquenceOfBST(int[] sequence) {
		// Base case
		if (sequence == null || sequence.length == 0) return false;
		// 验证一个范围是不是
		return verify(sequence, 0, sequence.length - 1);
	}


	private boolean verify(int[] sequence, int first, int last) {
		// 如果只有一或两个元素直接返回
		if (last - first <= 1) return true;
		// 后序遍历根结点值在最后一个
		int rootVal = sequence[last];
		// 从头开始搜索剪切点
		int cutIndex = first;
		while (cutIndex < last && sequence[cutIndex] <= rootVal) {
			cutIndex++;
		}
		for (int i = cutIndex; i < last; i++)
			if (sequence[i] < rootVal)
				return false;
		return verify(sequence, first, cutIndex - 1) && verify(sequence, cutIndex, last - 1);
	}

}
