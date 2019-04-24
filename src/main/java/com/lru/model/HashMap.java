package com.lru.model;

public class HashMap {

	private Node arr[];

	/**
	 * Initialize the hashMap for cache on application startup with default size
	 * as 100
	 */
	public HashMap(int size) {
		arr = new Node[size];

	}

	/**
	 * @return the arr
	 */
	public Node[] getArr() {
		return arr;
	}

	/**
	 * put value in hashMap if the integer value(key) is greater than the size
	 * of the map it doubles its size and copy all the elements in new hashMap.
	 * 
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

			this.arr = increaseMapSize(key);
			this.arr[key] = node;
		}
		return true;

	}
	/**
	 * Increase Map size if the key value is greater than size of map
	 * @param key
	 * @return new Array
	 */
	private Node[] increaseMapSize(int key) {
		Node newHashMap[] = new Node[key * 2];
		for (int i = 0; i < this.arr.length; i++) {
			newHashMap[i] = this.arr[i];
		}
		return newHashMap;
	}

	/**
	 * get the value from the map
	 * @param key
	 * @return {@link Node}
	 */
	public Node get(int key) {
		if(key > this.arr.length-1){
			this.arr = increaseMapSize(key);
		}
		return this.arr[key];
	}

	/**
	 * remove value from map
	 * 
	 * @param key
	 * @return {@link Node}
	 */
	public Node remove(int key) {
		Node node = this.arr[key];
		this.arr[key] = null;
		return node;
	}
}
