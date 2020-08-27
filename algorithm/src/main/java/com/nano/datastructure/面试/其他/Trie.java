package com.nano.datastructure.面试.其他;

/**
 * @author: nano
 * @time: 2020/8/21 17:29
 */
public class Trie {
	// 26个字母
	Trie[] next = new Trie[26];
	// 是否结束
	boolean isEnd = false;

	public Trie() { }

	public void insert(String word) {
		Trie cur = this;
		for (char c : word.toCharArray()) {
			// 如果当前字符没有后续的分叉则新建一个分分支
			if (cur.next[c - 'a'] == null) {
				// 一个Trie对象就是一个结点
				cur.next[c - 'a'] = new Trie();
			}
			// 不断深入创建结点
			cur = cur.next[c - 'a'];
		}
		// 表示这个结点是一个单词的结尾
		cur.isEnd = true;
	}

	public boolean search(String word) {
		Trie cur = this;
		for (char c : word.toCharArray()) {
			if (cur.next[c - 'a'] == null) return false;
			// 不断寻找
			cur = cur.next[c - 'a'];
		}
		// 判断是否到了结尾
		return cur.isEnd;
	}

	public boolean startsWith(String prefix) {
		Trie cur = this;
		for (char c : prefix.toCharArray()) {
			if (cur.next[c - 'a'] == null) return false;
			cur = cur.next[c - 'a'];
		}
		return true;
	}

}