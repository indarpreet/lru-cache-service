package com.lru.test;

import java.util.NoSuchElementException;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.lru.model.LRUCache;
import com.lru.model.Node;

@RunWith(SpringRunner.class)
public class LruApplicationTests {

	LRUCache lruCache;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() {
		LRUCache lruCache = new LRUCache(2);
	}
	/**
	 * put value check
	 */
	@Test
	public void putValue() {
		// given
		LRUCache cache = lruCache.getInstance();
		// when
		Node node = cache.putValue(1);
		// then
		Assertions.assertThat(cache.getSize()).isEqualTo(1);
	}
	/**
	 * put value with deleting least recently used
	 */
	@Test
	public void putValueWithDelete() {

		// given
		LRUCache cache = lruCache.getInstance();
		// when
		Node node1 = cache.putValue(1);
		Node node2 = cache.putValue(2);
		Node node3 = cache.putValue(3);
		// then
		Assertions.assertThat(node1).isEqualTo(null);
		Assertions.assertThat(cache.getSize()).isEqualTo(2);
		Assertions.assertThat(node2).isEqualTo(null);
		Assertions.assertThat(cache.getMaxSize()).isEqualTo(2);
		Assertions.assertThat(node3.getKey()).isEqualTo(1);
	}
	/**
	 * test value not found exception
	 */
	@Test
	public void getValueNotFound() {
		// given
		LRUCache cache = lruCache.getInstance();
		// when
		Node node1 = cache.putValue(1);
		Node node2 = cache.putValue(2);

		// then
		thrown.expect(NoSuchElementException.class);
		Node node3 = cache.getValue(3);

	}
	/**
	 * test value found
	 */
	@Test
	public void getValueFound() {
		// given
		LRUCache cache = lruCache.getInstance();
		// when
		Node node1 = cache.putValue(1);
		Node node2 = cache.getValue(1);
		// then
		Assertions.assertThat(node2.getKey()).isEqualTo(1);

	}
	/**
	 * test least recently used delete case
	 */
	@Test
	public void leastRecentlyUsedCheck() {
		// given
		LRUCache cache = lruCache.getInstance();
		// when
		cache.putValue(1);
		cache.putValue(2);
		cache.getValue(2);
		cache.getValue(1);
		Node deleted = cache.putValue(3);
		// then
		Assertions.assertThat(deleted.getKey()).isEqualTo(2);

	}
	
	/**
	 * test increasing size of the hashMap when the map is full or the key value is more than map size
	 */
	@Test
	public void testHashMapIncreaseInSize() {
		// given
		LRUCache cache = lruCache.getInstance();
		// when
		cache.putValue(1);
		cache.putValue(2);
		cache.putValue(3);
		cache.putValue(4);
		cache.putValue(6);
		cache.putValue(7);
		Node deleted = cache.putValue(3);
		// then
		Assertions.assertThat(cache.getHashMap().getArr().length).isEqualTo(8);

	}

}
