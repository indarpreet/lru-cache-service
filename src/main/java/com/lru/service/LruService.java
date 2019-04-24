package com.lru.service;

import org.springframework.stereotype.Component;

import com.lru.model.LRUCache;
import com.lru.model.Node;

@Component
public class LruService {

	public Node getValue(int id) {
		return LRUCache.getInstance().getValue(id);
		
	}

	public Node putValue(int id) {
		return LRUCache.getInstance().putValue(id);
	}

}
