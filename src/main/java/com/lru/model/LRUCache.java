package com.lru.model;

import java.util.NoSuchElementException;

import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

/**
 * This class creates data structure for least recently used cache
 * @author isokhi
 */
@Component
public class LRUCache {
	// recently used node
	private Node recent;
	
	// least recently used node
	private Node old; 
	
	// size for cache defined when application initialized
	private int maxSize;
	
	// actual size of the cache
	private int size;
	
	
	private static LRUCache cacheManager[] = new LRUCache[1];
	
	
	private MyHashMap myHashMap;
	

	public LRUCache() {
	}

	public LRUCache(int maxSize) {
		this.maxSize = maxSize;
		this.myHashMap = new MyHashMap();
		cacheManager[0] = this;
	}
	
	public static LRUCache getInstance(){
		return cacheManager[0];
	}
	
	public Node putValue( int key ){
		
		if(null == this.myHashMap.get(key)){
		int multiplicationConstant = 400;
		Node recentNode = new Node();
		recentNode.setKey(key);
		recentNode.setValue(key * multiplicationConstant);
		if(this.size == this.maxSize){
			Node deleted = this.old;
			this.old = this.old.next ;
			this.old.prev = null;
			this.recent.next = recentNode;
			recentNode.prev = this.recent;
			this.recent = recentNode;
			this.myHashMap.put(recentNode.key, recentNode);
			this.myHashMap.remove(deleted.key);
			return deleted;
		}else{
			
			if(null != this.recent){
				this.recent.next = recentNode;
				recentNode.prev = this.recent;
				this.recent = recentNode;
				this.size++;
			}else{
				this.recent = recentNode;
				this.old = recentNode;
				this.size++;
			}
			this.myHashMap.put(recentNode.key, recentNode);
			return null;
		}
		}else{
			return null;
		}
		
	}
	
	
public Node getValue(int key){

	if(this.size > 0){
		Node node = this.myHashMap.get(key);
		if(null != node){
			if(null != node.prev && null != node.next){
				node.prev.next = node.next;
				node.next.prev = node.prev;
				this.recent.next = node;
				node.prev = recent;
				this.recent = node;
			}else if(null == node.prev){
				node.next.prev = null;
				this.old = node.next;
				
			}
			return node;
			}
		throw new NoSuchElementException();
	}
	
	throw new NoSuchElementException();
}
}
