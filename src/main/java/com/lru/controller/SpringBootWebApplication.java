package com.lru.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.lru.model.LRUCache;

import sun.tools.jar.CommandLine;

@SpringBootApplication
@ComponentScan(value = "com.lru")
public class SpringBootWebApplication extends CommandLine {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);
		// initial cache size is 10
		LRUCache lurCache = new LRUCache(2);
	}

}
