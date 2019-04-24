package com.lru.model;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Component;

import com.lru.controller.SpringBootWebApplication;

/**
 * This class creates data structure for least recently used cache
 * 
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

	private static LRUCache cacheManager[];

	private HashMap hashMap;

	/**
	 * initialize cache size on application startup 
	 * This method is called from {@link SpringBootWebApplication}
	 * The maxSize of the cache is defined
	 * @param maxSize
	 */
	public LRUCache(int maxSize) {
		this.maxSize = maxSize;
		this.hashMap = new HashMap();
		cacheManager = new LRUCache[1];
		cacheManager[0] = this;
	}
    /**
     * The cacheManager which keeps the cache object
     * @return {@link LRUCache}
     */
	public static LRUCache getInstance() {
		return cacheManager[0];
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


	/**
	 * @return the cacheManager
	 */
	public static LRUCache[] getCacheManager() {
		return cacheManager;
	}


	/**
	 * @param cacheManager the cacheManager to set
	 */
	public static void setCacheManager(LRUCache[] cacheManager) {
		LRUCache.cacheManager = cacheManager;
	}


	/**
	 * @return the hashMap
	 */
	public HashMap getHashMap() {
		return hashMap;
	}


	/**
	 * @param hashMap the hashMap to set
	 */
	public void setHashMap(HashMap hashMap) {
		this.hashMap = hashMap;
	}
	
	/**
	 * inserts value inside cache and if cache is full deletes least recently used element and then inserts.
	 * The data structure used is LinkedList with HashMap to get high time complexity
	 * @param key
	 * @return {@link Node}
	 */
	public Node putValue(int key) {
		// if key is not present
		if (null == this.hashMap.get(key)) {
			int multiplicationConstant = 400;
			Node recentNode = new Node();
			recentNode.setKey(key);
			recentNode.setValue(key * multiplicationConstant);
			// if the size of the cache is full
			if (this.size == this.maxSize) {
				Node deleted = this.old;
				this.old = this.old.getNext();
				this.old.setPrev(null);
				this.recent.setNext(recentNode);
				recentNode.setPrev(this.recent);
				this.recent = recentNode;
				this.hashMap.put(recentNode.getKey(), recentNode);
				this.hashMap.remove(deleted.getKey());
				return deleted;
			} else {
				if (null != this.recent) {
					this.recent.setNext(recentNode);
					recentNode.setPrev(this.recent);
					this.recent = recentNode;
					this.size++;
				} else {
					this.recent = recentNode;
					this.old = recentNode;
					this.size++;
				}
				this.hashMap.put(recentNode.getKey(), recentNode);
			}
		}

		return null;
	}
	/**
	 * find the value inside cache if not found throws exception and if found returns {@link Node}
	 * @param key
	 * @return {@link Node}
	 */
	public Node getValue(int key) {
		//if size of the cache is greater than zero
		if (this.size > 0) {
			Node node = this.hashMap.get(key);
			if (null != node) {
				if (null != node.getPrev() && null != node.getNext()) {
					node.getPrev().setNext(node.getNext());
					node.getNext().setPrev(node.getPrev());
					this.recent.setNext(node);
					node.setPrev(this.recent);
					this.recent = node;
				} else if (null == node.getPrev() && null != node.getNext()) {
					node.getNext().setPrev(null);
					this.old = node.getNext();
					this.recent.setNext(node);
					node.setPrev(this.recent);
					this.recent = node;

				}
				return node;
			}
			throw new NoSuchElementException();
		}

		throw new NoSuchElementException();
	}
}
