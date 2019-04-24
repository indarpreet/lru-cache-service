package com.lru.dto;

import com.lru.model.Node;

public class CacheDTO {

	private int key;
	private int value;

	/**
	 * @return the key
	 */
	public int getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(int key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * Converts {@link Node} to user readable object
	 * @param node
	 * @return
	 */
	public static CacheDTO convertEntityToDTO(Node node) {
		CacheDTO cacheDto = new CacheDTO();
		cacheDto.setKey(node.getKey());
		cacheDto.setValue(node.getValue());
		return cacheDto;
	}

}
