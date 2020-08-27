package com.nano.datastructure.面试.业务代码;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: nano
 * @time: 2020/8/21 21:03
 */
public class LRUCache {
	// 存放元素
	Map<String, Node> map = new HashMap<>();
	// 链表的头尾指针
	Node head, tail;
	// 缓存最⼤容量
	int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * 插入元素
	 */
	public void put(String key, Object value) {
		// 说明缓存中没有任何元素
		if (head == null) {
			// 创建新结点,head与tail同时指向新结点
			head = new Node(key, value);
			tail = head;
			// 新结点放入map
			map.put(key, head);
		}
		// 说明缓存中已经存在这个元素
		Node node = map.get(key);
		if (node != null) {
			// 更新值
			node.value = value;
			// 把这个结点从链表删除并且插⼊到头结点
			removeAndInsert(node);
		} else {
			// 说明当前缓存不存在这个值
			Node newHead = new Node(key, value);
			// 此处溢出则需要删除最近最近未使用的节点也就是尾部结点
			if (map.size() >= capacity) {
				// 删除尾结点并移除map
				map.remove(tail.key);
				tail = tail.pre;
				tail.next = null;
			}
			// 放入新的结点
			map.put(key, newHead);
			// 将新的结点插入链表头部
			newHead.next = head;
			head.pre = newHead;
			head = newHead;
		}
	}

	/**
	 * 从缓存中取值
	 */
	public Object get(String key) {
		// 获取值
		Node node = map.get(key);
		// 如果有值则需要将这个结点放到链表头部
		if (node != null) {
			// 把这个节点删除并插⼊到头结点
			removeAndInsert(node);
			return node.value;
		}
		// 没有这个键就返回null
		return null;
	}

	// 将结点变幻到头结点的统一操作
	private void removeAndInsert(Node node) {
		// 特殊情况先判断，例如该节点是头结点或是尾部节点
		if (node == head) {
			return;
		} else if (node == tail) {
			tail = node.pre;
			tail.next = null;
		} else {
			// 移除node
			node.pre.next = node.next;
			node.next.pre = node.pre;
		}
		// 插⼊到头结点
		node.next = head;
		node.pre = null;
		head.pre = node;
		head = node;
	}

	private static class Node {
		String key;		// 键
		Object value;	// Object类型的值
		// 前驱与后续指针
		Node next;
		Node pre;

		public Node(String key, Object value) {
			this.key = key;
			this.value = value;
		}
	}
}
