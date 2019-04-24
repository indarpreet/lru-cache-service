package com.lru.model;

public class MyHashMap {

	private Node arr[];
	/**
	 * Initialize the hashMap for cache on application startup with default size as 100
	 */
	public MyHashMap() {
		arr = new Node[100];

	}
	/**
	 * put value in hashMap if the integer value(key) is greater 
	 * than the size of the map it doubles its size and copy all the elements in new hashMap.
	 * @param key
	 * @param node
	 * @return {@link boolean}
	 */
	public boolean put(int key, Node node) {
		int length = this.arr.length;
		if (key <= length - 1) {
			if (null == this.arr[key]) {
				this.arr[key] = node;

			} else {
				return false;
			}
		} else {
			Node newHashMap[] = new Node[key * 2];
			for (int i = 0; i < length; i++) {
				newHashMap[i] = this.arr[i];
			}
			newHashMap[key] = node;
			this.arr = newHashMap;
		}
		return true;

	}
	/**
	 * get the value from the map
	 * @param key
	 * @return {@link Node}
	 */
	public Node get(int key) {
		return this.arr[key];
	}
	/**
	 * remove value from map
	 * @param key
	 * @return {@link Node}
	 */
	public Node remove(int key) {
		Node node = this.arr[key];
		this.arr[key] = null;
		return node;
	}
}
