package com.nano.datastructure.面试.业务代码;


import java.util.HashMap;
import java.util.Map;

/**
 * 自定义的LFU缓存类
 *
 * @author: https://leetcode-cn.com/problems/lfu-cache/solution/chao-xiang-xi-tu-jie-dong-tu-yan-shi-460-lfuhuan-c/
 */
public class LFUCache {
	// 双链表中的链表节点对象
	protected static class Node {
		private final int key;
		private int value;
		private int freq; // 被访问的频率
		// 前后指针
		protected Node pre;
		protected Node next;

		public Node(int key, int value, int freq) {
			this.key = key;
			this.value = value;
			this.freq = freq;
		}

		public Node(int key, int value, int freq, Node pre, Node next) {
			this.key = key;
			this.value = value;
			this.freq = freq;
			this.pre = null;
			this.next = null;
		}

		public void updateValue(int value) {
			this.value = value;
		}

		public void increFreq() {
			this.freq++;
		}

		public int getKey() {
			return this.key;
		}

		public int getValue() {
			return this.value;
		}

		public int getFreq() {
			return this.freq;
		}

		public static final Node createEmptyNode() {
			return new Node(-1, -1, -1, null, null);
		}
	}

	// 自定义的双向链表类
	protected static class LinkedList {
		// 双向链表的头尾结点
		private final Node head;
		private final Node tail;

		public LinkedList() {
			// 创建空节点
			this.head = Node.createEmptyNode();
			this.tail = Node.createEmptyNode();
			this.head.next = this.tail;
			this.tail.pre = this.head;
		}

		/**
		 * 将指定的节点插入到链表的第一个位置
		 */
		public void insertFirst(Node node) {
			if (node == null) throw new IllegalArgumentException();
			node.next = this.head.next;
			this.head.next.pre = node;
			node.pre = this.head;
			this.head.next = node;
		}

		/**
		 * 从链表中删除指定的节点
		 */
		public void deleteNode(Node node) {
			if (node == null) throw new IllegalArgumentException();
			node.pre.next = node.next;
			node.next.pre = node.pre;
			node.pre = null;
			node.next = null;
		}

		/**
		 * 从链表中获取最后一个节点
		 */
		public Node getLastNode() {
			if (this.head.next == this.tail) {
				return Node.createEmptyNode();
			}
			return this.tail.pre;
		}

		/**
		 * 判断链表是否为空，除了head和tail没有其他节点即为空链表
		 */
		public boolean isEmpty() {
			return this.head.next == this.tail;
		}
	}

	// key->Node: 存储键值的hash表
	private final Map<Integer, Node> keyMap = new HashMap<>();

	// freq->LinkedList: 存储频率的hash表
	private final Map<Integer, LinkedList> freqMap = new HashMap<>();

	// 最大容量
	private final int capacity;

	// 缓存中最低频率
	private int minFreq = 0;

	public LFUCache(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * 获取一个元素，如果key不存在则返回-1，否则返回对应的value，同时更新被访问元素的频率
	 */
	public int get(int key) {
		// 没找到
		if (!this.keyMap.containsKey(key)) return -1;
		Node node = this.keyMap.get(key);
		// 增加使用频率
		this.increment(node);
		return node.getValue();
	}

	/**
	 * 插入指定的key和value，如果key存在则更新value，同时更新频率，
	 * 如果key不存并且缓存满了，则删除频率最低的元素，并插入新元素。否则，直接插入新元素
	 */
	public void put(int key, int value) {
		if (this.keyMap.containsKey(key)) {
			Node node = this.keyMap.get(key);
			node.updateValue(value);
			this.increment(node);
		} else {
			if (this.capacity == 0) {
				return;
			}
			if (this.keyMap.size() == this.capacity) {
				this.remoteMinFreqNode();
			}
			Node node = new Node(key, value, 1);
			this.increment(node, true);
			this.keyMap.put(key, node);
		}
	}


	/**
	 * 更新节点的访问频率
	 */
	private void increment(Node node) {
		increment(node, false);
	}

	/**
	 * 更新节点的访问频率
	 * @param isNewNode 是否是新节点，新插入的节点和非新插入节点更新逻辑不同
	 */
	private void increment(Node node, boolean isNewNode) {
		if (isNewNode) {
			this.minFreq = 1;
			this.insertToLinkedList(node);
		} else {
			this.deleteNode(node);
			node.increFreq();
			this.insertToLinkedList(node);
			if (!this.freqMap.containsKey(this.minFreq)) {
				++this.minFreq;
			}
		}
	}

	/**
	 * 根据节点的频率，插入到对应的LinkedList中，如果LinkedList不存在则创建
	 */
	private void insertToLinkedList(Node node) {
		if (!this.freqMap.containsKey(node.getFreq())) {
			this.freqMap.put(node.getFreq(), new LinkedList());
		}
		LinkedList linkedList = this.freqMap.get(node.getFreq());
		linkedList.insertFirst(node);
	}

	/**
	 * 删除指定的节点，如果节点删除后，对应的双链表为空，则从__freqMap中删除这个链表
	 */
	private void deleteNode(Node node) {
		LinkedList linkedList = this.freqMap.get(node.getFreq());
		linkedList.deleteNode(node);
		if (linkedList.isEmpty()) {
			this.freqMap.remove(node.getFreq());
		}
	}

	/**
	 * 删除频率最低的元素，从freqMap和keyMap中都要删除这个节点，
	 * 如果节点删除后对应的链表为空，则要从__freqMap中删除这个链表
	 */
	private void remoteMinFreqNode() {
		LinkedList linkedList = this.freqMap.get(this.minFreq);
		Node node = linkedList.getLastNode();
		linkedList.deleteNode(node);
		this.keyMap.remove(node.getKey());
		if (linkedList.isEmpty()) {
			this.freqMap.remove(node.getFreq());
		}
	}
}



