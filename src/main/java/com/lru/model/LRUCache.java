package com.lru.model;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Component;

/**
 * This class creates data structure for least recently used cache
 * @author isokhi
 */
@Component
public class LRUCache {
	// recently used node
	Node recent;
	
	// least recently used node
	Node old; 
	
	// size for cache defined when application initialized
	int maxSize;
	
	// actual size of the cache
	int size;
	

	public LRUCache(int maxSize) {
		this.maxSize = maxSize;
		
		
	}


	/**
	 * @return the recent
	 */
	public Node getRecent() {
		return recent;
	}


	/**
	 * @param recent the recent to set
	 */
	public void setRecent(Node recent) {
		this.recent = recent;
	}


	/**
	 * @return the old
	 */
	public Node getOld() {
		return old;
	}


	/**
	 * @param old the old to set
	 */
	public void setOld(Node old) {
		this.old = old;
	}


	/**
	 * @return the maxSize
	 */
	public int getMaxSize() {
		return maxSize;
	}


	/**
	 * @param maxSize the maxSize to set
	 */
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}


	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}


	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
	public Node putValue( int key ){
		int multiplicationConstant = 400;
		Node recentNode = new Node();
		recentNode.setKey(key);
		recentNode.setValue(key * multiplicationConstant);
		if(size == maxSize){
			Node deleted = old;
			old = old.next ;
			old.prev = null;
			recent.next = recentNode;
			recentNode.prev = recent;
			recent = recentNode;
			return deleted;
		}else{
			
			if(null != recent){
				recent.next = recentNode;
				recent = recentNode;
				size++;
			}else{
				recent = recentNode;
				old = recentNode;
			}
			return null;
		}
		
	}
	
	
public Node getValue(int key){

	if(size > 0){
		Node node = old;
		// This part can be further optimized by using hashMap for storing key value pairs O(n) -> O(1)
		while(null != node){
			if(node.key == key){
			   return node;
			}else{
				node = node.next;
			}
		}
	}
	
	throw new NoSuchElementException();
}
}
