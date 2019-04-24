package com.lru.service;

import org.springframework.stereotype.Component;

import com.lru.dto.CacheDTO;
import com.lru.model.LRUCache;
import com.lru.model.Node;

@Component
public class LruService {
	/**
	 * service to fetch data from cache
	 * @param id
	 * @return {@link CacheDTO}
	 */
	public CacheDTO getValue(int id) {
		Node node = LRUCache.getInstance().getValue(id);
		if (null != node) {
			return CacheDTO.convertEntityToDTO(node);
		}
		return null;
	}
	/**
	 * service to put data into cache
	 * @param id
	 * @return {@link CacheDTO}
	 */
	public CacheDTO putValue(int id) {
		Node node = LRUCache.getInstance().putValue(id);
		if (null != node) {
			return CacheDTO.convertEntityToDTO(node);
		}
		return null;

	}

}
