package com.lru.model;

public class MyHashMap {

	private Node arr[];

	public MyHashMap() {
		arr = new Node[100];

	}

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

	public Node get(int key) {
		return this.arr[key];
	}

	public Node remove(int key) {
		Node node = this.arr[key];
		this.arr[key] = null;
		return node;
	}
}
